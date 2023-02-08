using System.Collections;
using System.Collections.Generic;
using UnityEngine;

//Music from https://www.bensound.com/royalty-free-music/5
//Sound effects from
//https://elements.envato.com/laser-3TRG6M5?utm_source=mixkit&utm_medium=referral&utm_campaign=elements_mixkit_cs_sfx_search_no_results&_ga=2.263160526.31862573.1650874045-1194583825.1650874045
//https://mixkit.co/free-sound-effects/
//https://pixabay.com/sound-effects/

public class EnemyController : MonoBehaviour
{
    //Find the players map information
    public Transform player;

    //the vector information for the enemys target (Player)
    public Vector3 m_target;

    
    //Vector for random destinations for the enemy to patrol the map
    Vector3 destination = new Vector3(0, 0, 0);

    //Boolean for the enmeny to check if the player is near by
    bool playerDetected = false;

    //Object for our rocket projectile
    public GameObject rocketPrefab;

    //Checks the Time for how fast the enemy can shoot
    private float m_shootRateTimeStamp;

    public AudioSource source;

    //how fast the enemy can shoot
    public float shotSpeed;

    //Amount of shots fired
    private int shotCount = 0;

    void Start()
    {
	//Method to pick a random set of coordinates for the enemy to go head to
        pickRandomCoordinate();
    }

    void OnTriggerExit(Collider other)
    {
	//Detects if the player leaves the enemys collider
        if (other.gameObject.tag == "Player")
        {
            //Changes the boolean that player has been Detected	
            playerDetected = false;

            //resets the cooridents
            m_target.x = 0;
            m_target.y = 0;
            m_target.z = 0;
            //resets the shot count
            shotCount = 0;
            //repicks the enemies patrol coordinates
            pickRandomCoordinate();
        }
    }

    void OnTriggerEnter(Collider other)
    {
        //Detects if the player enters the enemies collider
        if (other.gameObject.tag == "Player")
        {
            //Sets the enemy destination to the player
            m_target.x = player.position.x;
            m_target.y = player.position.y;
            m_target.z = player.position.z;
            m_target = player.position;

            //Changes the boolean of player detection by an emery to true
            playerDetected = true;
        }
    }

    void pickRandomCoordinate()
    {
	//sets destination to random coordinates inside our world
        destination = Random.insideUnitSphere * 1000;
    }

    void Update()
    {

        //Checks if playerDectected boolean is true
        if (playerDetected)
        {
            if (Time.time > m_shootRateTimeStamp)
            {
		//Creates and Fires laser
                GameObject laser = GameObject.Instantiate(rocketPrefab, transform.position, transform.rotation) as GameObject;
                //Destroys the laser after being fired
                GameObject.Destroy(laser, 3f);
                source.Play();
            }
	    //Sets the destination vector to players position
            destination = player.position;
        }
        else
        {
	    //Checks if the position of the enemy is inside the destination coordinate 
            if (Mathf.Abs(transform.position.x - destination.x) < 10 && Mathf.Abs(transform.position.y - destination.y) < 10 && Mathf.Abs(transform.position.z - destination.z) < 10)
            {
		//picks a new set of coordinates to head to
                pickRandomCoordinate();
            }
        }
	//Finds the direction to look at
        Vector3 dir = destination - transform.position;
        Quaternion rot = Quaternion.LookRotation(dir);
        transform.rotation = Quaternion.Slerp(transform.rotation, rot, Time.deltaTime * 5);

        //Moves the enemy forward
        transform.position += transform.forward * Time.deltaTime * 10;
        Vector3 forward = transform.TransformDirection(Vector3.forward) * 50;
        Debug.DrawRay(transform.position, forward, Color.green);
    }
}
