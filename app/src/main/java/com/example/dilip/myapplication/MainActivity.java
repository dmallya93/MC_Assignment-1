package com.example.dilip.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button bt;
    Button bt2;
    String[] verticalLabels = {"0","20","40","60","80","100"};
    String[] horizontalLabels = {"0","100","200","300","400","500","600","700","800","900","1000"};
    GraphView g;
    LinearLayout graph;
    Thread movingGraph = null;
    Boolean flag = null;
    float[] values = new float[10];

    Handler threadHandle = new Handler(){
        @Override
        public void handleMessage(Message msg){
            for (int i = 0; i < 10; i++) {
                values[i] = (float) Math.ceil(Math.random() * 180);
            }
            g.invalidate();
            g.setValues(values);
        }
    };


    protected float[] createRandomVariable()
    {
        float[] arrayValues = new float[30];
        for(int i=0; i< 20; i++)
        {
            arrayValues[i] = i*100;
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

        g = new GraphView(this, createRandomVariable(), title, horizontalLabels,
                verticalLabels, GraphView.LINE);
        graph = (LinearLayout)findViewById(R.id.moving_graph);
        graph.addView(g);

        try {
            movingGraph = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int k = 0;
                        while (true) {
                            while (flag) {
                                k++;
                                Message msg = threadHandle.obtainMessage(1, Integer.toString(k));
                                threadHandle.sendMessage(msg);
                                Thread.sleep(1000);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == null){
                    flag = true;
                    movingGraph.start();
                    Toast.makeText(MainActivity.this, "Graph Started", Toast.LENGTH_SHORT).show();
                } else if(!flag){
                    flag = true;
                    Toast.makeText(MainActivity.this, "Graph Resumed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                if (values != null) {
                    Toast.makeText(MainActivity.this, "Graph Stopped", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 10; i++) {
                        values[i] = 0;
                    }
                    g.invalidate();
                    g.setValues(values);
                }
            }
        });

    }
}
