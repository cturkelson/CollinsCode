using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Boundary : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    //Checks to see if the player or astroids leave the boundry, if so it notifies the player or destroys the astroids.
    void OnTriggerExit(Collider other) {
        if (other.gameObject.tag == "Player") {
            Debug.Log("Player has gone out of bounds");
        }
        if (other.gameObject.tag == "Asteroid") {
            Destroy(other.gameObject);
        }
    }

    void OnTriggerEnter(Collider other) {
        // Debug.Log(other.gameObject.tag);
    }
}
