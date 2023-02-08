using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;


public class GameController : MonoBehaviour
{

    //Creates asteroids instance
     public GameObject asteroid;

    //Creates gates instance
    public GameObject gate;
    
    //Variable containing the number of asteroids on the map
    public int numberOfAsteroids;
    
    //GameObject array of gates
    GameObject[] gates;

    //The amount of time to get through a gate
    public float gameTimer = 25.0f;

    //The amount of time added when going through a gate
    public float gateTimeBonus = 10.0f;

    //The radius of our map
    private float radius;

    //Boolean to check if the player is out of the bounds of our world
    private bool playerOutOfBounds = false;

    //Amount of gates for this level
    public int gatesToSpawnOnThisLevel = 10;

    //Amount of gates gone through this level
    private int gatesCollected = 0;

    //Amount of health the player has
    public int playerHealth = 100;

    //healthLabel for our overlay
    [SerializeField] private Text healthLabel;

    //Label for the amount of gates on the level
    [SerializeField] private Text gatesLabel;

    //Label for the time left to get through the gate
    [SerializeField] private Text timeLabel;

    //Label for when our player leaves the world
    [SerializeField] private Text outOfBoundsLabel;

    // Start is called before the first frame update
    void Start()
    {
        //Radius of our world being set
        radius = GetComponent<SphereCollider>().radius;

        // set labels
        healthLabel.text = "HEALTH: ";
        gatesLabel.text = "GATES REMAINING: " + gatesToSpawnOnThisLevel.ToString();
        timeLabel.text = "TIME REMAINING: ";

        // spawn asteroids.
        for (int x = 0; x < numberOfAsteroids + 1; x++) {
            SpawnAsteroid();
        }

        //Gates on our world being set
        gates = GameObject.FindGameObjectsWithTag("Gate");

	//Sets the amount of gates and time bonus for each level
        if (Application.loadedLevel == 1) {
            gatesToSpawnOnThisLevel = 10;
            gateTimeBonus = 20.0f;
        } else if (Application.loadedLevel == 2) {
            gatesToSpawnOnThisLevel = 15;
            gateTimeBonus = 15.0f;
        } else if (Application.loadedLevel == 3) {
            gatesToSpawnOnThisLevel = 20;
            gateTimeBonus = 10.0f;
        }        
    }

    // Update is called once per frame
    void Update()
    {
        // Update game timer
        gameTimer -= Time.deltaTime;
        timeLabel.text = "TIME REMAINING: " + gameTimer.ToString();
        if (gameTimer <= 10.0f) {
            timeLabel.color = Color.red;
        } else {
            timeLabel.color = Color.white;
        }

        if (gameTimer < 0.0f) {
            Debug.Log("Game over");
            gameOver();
        }

        // update labels
        if (playerOutOfBounds) {
            outOfBoundsLabel.text = "RETURN TO ZONE";
        } else {
            outOfBoundsLabel.text = "";
        }

        // health label
        healthLabel.text = "HEALTH: " + playerHealth.ToString();
        if (playerHealth <= 0) {
            gameOver();
        }


        // check gates for level win
        gates = GameObject.FindGameObjectsWithTag("Gate");
        if (gates.Length <= 0) {
            if (gatesCollected == gatesToSpawnOnThisLevel) {
                levelWin();
            } else {
                Debug.Log("Gate Cleared");
                gatesCollected ++;
                gatesLabel.text = "GATES REMAINING: " + (gatesToSpawnOnThisLevel - gatesCollected).ToString();
                gameTimer += gateTimeBonus;
                spawnGate();
            }
        }

    }

    
    // Objects entering and exiting the world bounds.

    void OnTriggerExit(Collider other) {
        if (other.gameObject.tag == "Player") {
            Debug.Log("Player has gone out of bounds");
            playerOutOfBounds = true;
        }
        if (other.gameObject.tag == "Asteroid") {
            Destroy(other.gameObject);
            SpawnAsteroid();
        }
    }

    void OnTriggerEnter(Collider other) {
        if (other.gameObject.tag == "Player") {
            Debug.Log("Player has returned to bounds");
            playerOutOfBounds = false;
        }
    }
    

    //Spawns Asteroids randomly around the world with random sizes
    void SpawnAsteroid() {
        Vector3 position = GetPositionOutsideZone();
        GameObject roid = Instantiate(asteroid, position, Quaternion.identity);
        int scale = Random.Range(10, 30);
        roid.transform.localScale = new Vector3(scale, scale, scale);
        roid.transform.LookAt(Vector3.zero);
        roid.GetComponent<Rigidbody>().velocity = (roid.transform.forward + new Vector3(Random.Range(0, 2.5f), Random.Range(0, 2.5f), Random.Range(0, 2.5f))) * Random.Range(10, 40);
        roid.GetComponent<Rigidbody>().mass *= scale;
    }

    Vector3 GetPositionOutsideZone() {
        Vector3 pos = new Vector3();

        float s = Random.Range(0, 360) * Mathf.PI / 180;
        float t = Random.Range(0, 360) * Mathf.PI / 180;

        pos.x = radius * Mathf.Cos(s) * Mathf.Sin(t);
        pos.y = radius * Mathf.Sin(s) * Mathf.Cos(t);
        pos.z = radius * Mathf.Cos(t);
        
        return pos;
    }
    //SpawnsGate when the one is hit
    void spawnGate() {
        Instantiate(gate, Random.insideUnitSphere * radius, Quaternion.identity);
    }


    void gameOver() {
        //Loads the loser page
         Application.LoadLevel("Loser");

    }

    void levelWin() {
        // Changes to the next level
        Application.LoadLevel(Application.loadedLevel+1);
    }
}
