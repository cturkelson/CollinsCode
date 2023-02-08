using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PointerController : MonoBehaviour
{
	//Initialized the gate
	public GameObject gate;
   

    // Update is called once per frame
    void Update()
    {
         //checks if gate has changed
	if(gate == null)
	{
	//finds the new gate
	gate = GameObject.Find("Gate(Clone)");
	}
	//looks at the next gate
        transform.LookAt(gate.transform);
    }
}
