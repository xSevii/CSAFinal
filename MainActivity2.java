package com.example.apcsa_final_kaylee_ax;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity
{

    ArrayList<Integer> numList = new ArrayList<Integer>();
    int toAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        }); //end of on create
        for (int i = 0; i < 25; i++)//Creates a list containing 25 random numbers between 0-101
        {
            toAdd = (int) (Math.random() * 101);
            numList.add(toAdd);
        }
    }

    public void onClick(View v)
    {


        EditText text = findViewById(R.id.editTextNumber2);
        String temp = text.getText().toString();
        int num = Integer.parseInt(temp);//Takes inputted number and stores it in a variable


        Log.i("info", "num: " + num);
        TextView output = (TextView) findViewById(R.id.textView4);
        String stuff = "number was not found";
        for (int j = 0; j < numList.size(); j++) //Traverses through randomized list
        {
            if(numList.get(j) == num)//Checks if the inputted number is in the list
            {
                stuff = "Number was found";
                Log.i("Info", "Number was found");
            }
        }
        output.setText(stuff);
        Log.i("info", numList+" ");

        text.setText("");
    }

    //This connects to a next button that will go on to the third screen
    public void nextBtn2(View v)
    {
        startActivity(new Intent(MainActivity2.this, MainActivity3.class));

    }

}
