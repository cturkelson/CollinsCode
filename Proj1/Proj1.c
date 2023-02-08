#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <arpa/inet.h>
#include <fcntl.h>
#include <errno.h>
#include <unistd.h>
#include <time.h>

//Default size of all messages read by parent
#define SIZE 4096
int globalNode = 1;
int badNode;

//Signal handler for control-c exit
void sigHandler (int sigNum){
    if(globalNode == badNode)
    {
        printf("Node %d Closing, The bad node\n",globalNode);
        exit(1);
    }
    else if(globalNode != 0){
  	    printf("Node %d Closing\n",globalNode);
        exit(1);
    }
    else
    {
        printf("Parent closing\n");
        exit(1);
    }
}

//Our apple struct containing the message, node, and if the message has been recieved
struct Apple {
int header;
int node;
char message[SIZE];
};

int main(int argc, char* argv[]){

    //signal call for the handler 
    signal(SIGINT,sigHandler);

    int amountOfNodes;
    int inBounds;
    int pid;
    int applePipeCheck;
    char inputMessage[SIZE];
    char nodeNumber[SIZE];
    struct Apple apple;
    char temp[SIZE];

    

    /*
     Checking to make sure that there are the correct amount of statements
     when calling the program
    */
    if(argc < 2 )
    {
        printf("Not Enough Arguements: Need the amount of nodes to create\n");
        exit(1);
    }
        else if(argc > 2){
        printf("Too Many Arguements: Just need the amount of nodes to create\n");
        exit(1);
    }

    //Setting the amount of nodes and creating the pipes
    amountOfNodes = atoi(argv[1]);
    int applePipe[amountOfNodes][2];
    srand(time(NULL));
    badNode = ((rand()%(amountOfNodes-1))+1);


    //Creating the pipes for the nodes 
    for(int i = 0; i < amountOfNodes; i++)
    {

        applePipeCheck = pipe(applePipe[i]);
        if(applePipeCheck < 0)
        {
            perror("Apple pipe");
            exit(0);
        }
    }

    //Creating each process and closing the pipes each process doesn't use 
    for(int i = 0; i < amountOfNodes - 1; i++)
    {

        pid = fork();
        if(pid < 0)
        {
            perror("Fork");
            exit(0);
        }

        if(pid == 0)
        {
            for(int l = 0; l < amountOfNodes; l++)
            {
                if(l == globalNode - 1)
                {
                    close(applePipe[l][1]);
                }
                else if(l == globalNode)
                {
                    close(applePipe[l][0]);
                }
                else
                {
                    close(applePipe[l][0]);
                    close(applePipe[l][1]);
                }
            }
            break;
        }
        else
        {
            globalNode = (globalNode + 1)%amountOfNodes;
        }
    }

    /*
    The logic for each child process. We start by the read call which is blocking
    so the child process will not contiune until it has recieved a message. After
    recieving the message it will check if the message has been opened, and if the
    message is for their node. Depending on the child it will either pass the
    message on, or read the message then pass it on.
    */
    if(pid == 0)
    {
        while(1)
        {
            read(applePipe[globalNode-1][0], &apple, sizeof(struct Apple));
            if(badNode == globalNode)
            {
                strcpy(temp,apple.message);
                char temp1[SIZE];
                char temp2[SIZE];
                temp[strlen(temp)-1] = '\0';
                int halfApple = strlen(temp)/2;
                if(strlen(temp)%2 != 0)
                {
                    strncpy(temp1,temp,halfApple);
                    strncpy(temp2,temp+halfApple,halfApple+1);
                    strcat(temp2,temp1);
                    strcpy(apple.message,temp2);
                }
                else
                {
                    strncpy(temp1,temp,halfApple);
                    strncpy(temp2,temp+halfApple,halfApple);
                    strcat(temp2,temp1);
                    strcpy(apple.message,temp2);
                }
            }  
            if(apple.header == 0)
            {
                printf("Message has already been delievered, Passing the apple back to dad\n");
                write(applePipe[globalNode][1], &apple, sizeof(struct Apple));
            }
            else if(globalNode == apple.node)
            {
                strcpy(inputMessage,apple.message);
                printf("Node hit! Saving message: %s\n", inputMessage);
                apple.header = 0;
                write(applePipe[globalNode][1], &apple, sizeof(struct Apple));
            }
            else
            {
                printf("Not Intended for this node. Passing on to the next\n");
                write(applePipe[globalNode][1], &apple, sizeof(struct Apple));
            }
        }
    }
    /*
    The logic for the parent process. The parent will ask for a message to pass
    and which node they want it sent to. After recieving the intended node, the
    program checks that the node is within the parameters of 0 and the amount of
    nodes making sure the intended node is in bounds. Once all that is complete,
    program will send the apple and wait to recieve it back.
    */
    else
    {
        while(1)
        {
            inBounds = 0;
            printf("Type your Message\n");
            fgets(inputMessage, SIZE, stdin);

            while(inBounds != 1)
            {
                printf("Which node would you like to have the message?\n");
                fgets(nodeNumber, SIZE, stdin);
                apple.node = atoi(nodeNumber);
                if(apple.node < 0 || apple.node > (amountOfNodes - 1))
                {
                    printf("Out of Bounds\n");
                    inBounds = 0;
                }
                else
                {
                    inBounds = 1;
                    apple.header = 1;
                }

            }
            strcpy(apple.message,inputMessage);
            write(applePipe[0][1],&apple, sizeof(struct Apple));
            read(applePipe[amountOfNodes-1][0], &apple, sizeof(struct Apple));
            printf("Parent Recieved the Apple Back: %s\n",apple.message);
        }
    }

return 1;
}
