using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GateDetection : MonoBehaviour
{

    public GameObject gate;
    //Destroys the old gate after a player has gone through it
    void OnTriggerEnter(Collider other) { 
        if (other.gameObject.tag == "Player") {
            Destroy(gate, 1.0f);
            // play sound.
        }
    }
}
