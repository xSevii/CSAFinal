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

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    ArrayList<Integer> arr = new ArrayList<Integer>();
    int added;

    //Adds numbers to the list
    public void numAdd(View v)
    {
        EditText text = findViewById(R.id.SortInputBox);
        String temp = text.getText().toString();
        added = Integer.parseInt(temp);

        arr.add(added);
    }

    //This method sorts the list from least to greatest
    public void sortNums(View v)
    {
        int n = arr.size();
        for(int i = 1; i < n; i++)
        {
            int temp = arr.get(i);
            int j = i - 1;

            while(j >= 0 && arr.get(j) > temp)
            {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, temp);
        }

        Log.i("Info", "Arr: "+ arr);

        String theString = "";
        for(int item: arr)
        {
            theString += item+ ", ";
        }
        TextView output = (TextView) findViewById(R.id.SortDisplayText);
        output.setText(theString);
    }

    //This connects to a next button that will go on to the second screen
    public void nextBtn1(View v)
    {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));

    }


}
