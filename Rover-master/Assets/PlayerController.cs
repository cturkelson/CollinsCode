using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    //Initializes how fast the player flys
    public float speedConstant;

    //Initializes how fast the boost flys
    public float boostConstant;

    //Initializes players camera
    public Camera camera;

    //Initializes player
    public GameObject player;

    //Initializes thrusters
    public ParticleSystem[] thruster;

    //Sets Pitch and Yaw factors
    public float pitchSpeedFactor = 200.0f;
    public float yawSpeedFactor = 150.0f;

    //sets how fast the player can roll
    public float rollSpeedFactor = 2.0f;
 
    //initializes the current boost
    float currentBoost;

    //initializes and sets the boost time
    float boostTimer = 0.0f;

    //finds the center of the Screen
    Vector3 center;

    //Variable to get rotate the jet
    float noTurn = 0.1f;

    void Start()
    {
	//Sets the thruster array
        thruster = GetComponentsInChildren<ParticleSystem > ();

	//sets the Screen for movement
        Cursor.lockState = CursorLockMode.Locked;
        center = new Vector3(Screen.width / 2, Screen.height / 2, 0);
    }

    // Update is called once per frame
    void Update()
    {
	
	//Starts the boost timer
        if (Input.GetKey(KeyCode.Space) && boostTimer <= 0.0f)
        {
            boostTimer += 5.0f;
            currentBoost = boostConstant;
        }

        // Rotate the player with mousedad
        var rot = (Input.mousePosition - center) / Screen.height;

        if (rot.y > noTurn) {
            transform.Rotate(-(rot.y - noTurn) * Time.deltaTime * pitchSpeedFactor, 0, 0);
        }

        if (rot.y < -noTurn) {
            transform.Rotate(-(rot.y + noTurn) * Time.deltaTime * pitchSpeedFactor, 0, 0);
        }

        if (rot.x > noTurn)
        {
            transform.Rotate(0, (rot.x - noTurn) * Time.deltaTime * yawSpeedFactor, 0);
        }

        if (rot.x < -noTurn)
        {
            transform.Rotate(0, (rot.x + noTurn) * Time.deltaTime * yawSpeedFactor, 0);
        }

        // Rotate player with keys.
        // if (Input.GetKey(KeyCode.W))
        // {
        //     transform.rotation *=
        //         Quaternion.AngleAxis(75 * Time.deltaTime, Vector3.right);
        // }

        // if (Input.GetKey(KeyCode.S))
        // {
        //     transform.rotation *=
        //         Quaternion.AngleAxis(-75 * Time.deltaTime, Vector3.right);
        // }

	//Rolls the jet to the left
        if (Input.GetKey(KeyCode.D))
        {
            transform.rotation *=
                Quaternion.AngleAxis(-45 * Time.deltaTime, Vector3.forward * rollSpeedFactor);
        }

        //Rolls the jet to the right
        if (Input.GetKey(KeyCode.A))
        {
            transform.rotation *=
                Quaternion.AngleAxis(45 * Time.deltaTime, Vector3.forward * rollSpeedFactor);
        }

        // Move the player
        var delta = speedConstant * Time.deltaTime;

	//Functionality for the boost and camera
        if (boostTimer >= 0.0f)
        {
            boostTimer -= Time.deltaTime;
            var timePassed = 5.0f - boostTimer;
            currentBoost =
                (-1*(timePassed * timePassed)) + (5.0f * timePassed);
            delta *= currentBoost * boostConstant;
            camera.fieldOfView = 90 + currentBoost * 5;
            for (int i = 0; i < 3; i++)
            {
                thruster[i].startLifetime = 0.6f + currentBoost * .25f;
            }
        } else { 
            camera.fieldOfView = 90;
        }

	//Moves our player forward
        transform.position += transform.forward * delta;
    }
}
