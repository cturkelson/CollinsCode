using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Lose : MonoBehaviour
{
    //How long the user watches the end screen
    float timer = 3.0f;

    // Update is called once per frame
    void Update()
    {
        //Timer decreasing
        timer -= Time.deltaTime;

        if (timer <= 0.0f) {
	    //Loads the main menu
            Application.LoadLevel(0);
        }
    }
}
