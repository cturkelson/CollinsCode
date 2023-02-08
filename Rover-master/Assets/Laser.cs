using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Laser : MonoBehaviour
{
    //Variable controlling how fast the lasers shoots
    public int laserSpeed = 20;
    // Update is called once per frame

    //Instantiates controller
    private GameController controller;


    void Start() {
	//sets the game controller
        controller = GameObject.Find("GameController").GetComponent<GameController>();
    }

    void Update()
    {
	//Moves the Projectiles
        transform.position += transform.forward * Time.deltaTime * laserSpeed; 
    }
   
    //Checks to see if the laser hits the player, then lowers the players health
    void OnTriggerEnter(Collider other) {
        if (other.gameObject.tag == "Player") {
            Debug.Log("Hit player");
            Destroy(other);
            controller.playerHealth -= 1;
        }
    } 
}
