//
// Created by Collin Turkelson on 11/9/22.
//
#include <stdlib.h>
#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <unistd.h>

#define MAXLINE 4096 /*max text line length*/
#define SERV_PORT 3000 /*port*/
#define LISTENQ 8 /*maximum number of client connections*/

int main (int argc, char **argv)
{
    int listenfd, connfd, n;
    pid_t childpid;
    socklen_t clilen;
    char buf[MAXLINE];
    char readBuf[MAXLINE];
    struct sockaddr_in cliaddr, servaddr;

    //pipes and selectors
    int ret, nfdser, nfdchi, iD = 0;
    fd_set user1;
    fd_set user2;
    fd_set client;
    fd_set server;
    int p[4][2];
    pipe(p[0]);
    pipe(p[1]);
    pipe(p[2]);
    pipe(p[3]);

    //Create a socket for the server
    //If sockfd<0 there was an error in the creation of the socket
    if ((listenfd = socket (AF_INET, SOCK_STREAM, 0)) <0) {
        perror("Problem in creating the socket");
        exit(2);
    }


    //preparation of the socket address
    bzero((char *) &servaddr, sizeof(servaddr));
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
    servaddr.sin_port = htons(SERV_PORT);

    //bind the socket
    bind (listenfd, (struct sockaddr *) &servaddr, sizeof(servaddr));

    //listen to the socket by creating a connection queue, then wait for clients
    listen (listenfd, LISTENQ);

    printf("%s\n","Server running...waiting for connections.");

    for ( ; ; ) {

        //Select setup
        FD_ZERO(&server);
        FD_SET(p[0][0], &server);
        FD_SET(p[2][0], &server);
        FD_SET(listenfd, &server);
        (p[0][0] > p[2][0]) ? (nfdser = p[0][0] + 1) : (nfdser = p[2][0] + 1);
        (listenfd > nfdser) ? (nfdser = listenfd + 1) : (nfdser);
        ret = select(nfdser, &server, NULL, NULL, NULL);

        if (ret > 0) {
            if (FD_ISSET(listenfd, &server)) {


                clilen = sizeof(cliaddr);
                //accept a connection
                connfd = accept(listenfd, (struct sockaddr *) &cliaddr, &clilen);

                printf("%s\n", "Received request...");

                if ((childpid = fork()) == 0) {//if itâ€™s 0, itâ€™s child process

                    printf("%s\n", "Child created for dealing with client requests");
                    close(p[0][0]);
                    close(p[1][1]);
                    close(p[2][0]);
                    close(p[3][1]);
                    //close listening socket
                    close(listenfd);

                    int wPipe = iD*2;
                    int rPipe = iD*2+1;
                    int oiD = (iD +1)%2;

                    FD_ZERO(&client);
                    FD_SET(connfd, &client);
                    FD_SET(p[rPipe][0], &client);
                    (connfd > p[rPipe][0]) ? (nfdchi = connfd + 1) : (nfdchi = p[rPipe][0] + 1);

                    while ( (ret = select(nfdchi, &client, NULL, NULL, NULL)) > 0) {
                        if (FD_ISSET(connfd, &client)) {
                                bzero(buf, MAXLINE);
                                recv(connfd, buf, MAXLINE, 0);
                                write(p[wPipe][1], buf, sizeof(buf));
                        }
                        if (FD_ISSET(p[rPipe][0], &client)) {
                            bzero(buf, MAXLINE);
                            n = read(p[rPipe][0], buf, MAXLINE);
                            printf("%s\t%d\t", "String received from: ",oiD);
                            puts(buf);
                            send(connfd, buf, n, 0);
                        }
                        FD_ZERO(&client);
                        FD_SET(connfd, &client);
                        FD_SET(p[rPipe][0], &client);
                    }
                    if(ret < 0)
                        perror("select()");
                    exit(0);
                }
                close(p[iD*2][1]);
                close(p[iD*2+1][0]);
                iD ++;
                //close socket of the server
                close(connfd);
            }
            if (FD_ISSET(p[0][0],&server)) {
                //read from user 1
                bzero(buf, MAXLINE);
                read(p[0][0],buf, sizeof(buf));
                write(p[3][1],buf,sizeof(buf));
            }
            if (FD_ISSET(p[2][0],&server)) {
                //read from user 2
                bzero(buf, MAXLINE);
                read(p[2][0], buf, sizeof(buf));
                write(p[1][1],buf,sizeof(buf));
            }

        }
        else{
            perror("select()");
            exit(EXIT_FAILURE);
        }
        //clean FD_SET AREA
    }


}
