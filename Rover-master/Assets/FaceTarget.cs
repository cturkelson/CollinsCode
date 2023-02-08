using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FaceTarget : MonoBehaviour
{

    public Transform target;

    // Update is called once per frame
    void Update()
    {
	//Controls the direction of the light
        transform.LookAt(target.position);
    }
}
