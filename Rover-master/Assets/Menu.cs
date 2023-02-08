using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class Menu : MonoBehaviour
{
    //Button initialized	
    public Button button;

    // Start is called before the first frame update
    void Start()
    {
		//Button functionality starting the game
		button.onClick.AddListener(TaskOnClick);
    }

    void TaskOnClick() {
	//Loading the first level
        Application.LoadLevel(1);
    }

}
