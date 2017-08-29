package com.example.dilip.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button bt;
    Button bt2;
    Random rand;
    String[] verticalLabels = {"0","20","40","60","80","100"};
    String[] horizontalLabels = {"0","100","200","300","400","500","600","700","800","900","1000"};


    protected float[] createRandomVariable()
    {
        float[] arrayValues = new float[30];
        for(int i=0; i< 30; i++)
        {
            int randomNum = rand.nextInt(100) + 100;
            arrayValues[i] = randomNum;
        }
        return arrayValues;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String title = "Health Monitor 11";
        bt = (Button) findViewById(R.id.run_button);
        bt2 = (Button) findViewById(R.id.stop_button);
//        final GraphView graphView = new GraphView(this, [], title, horizontalLabels, verticalLabels, true);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Graph started", Toast.LENGTH_SHORT).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Graph stopped", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
