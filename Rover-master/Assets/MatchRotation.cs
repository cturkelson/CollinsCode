using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MatchRotation : MonoBehaviour
{
    //Target being intialized
    public Transform target;

    // Start is called before the first frame update
    void Start()
    {
	//Changing our rotation to our targets rotation
        transform.rotation = target.rotation;
    }

    // Update is called once per frame
    void Update()
    {
	//Changing our rotation to our targets rotation
        transform.rotation = target.rotation;
    }
}
