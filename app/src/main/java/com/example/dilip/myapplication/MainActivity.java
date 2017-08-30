package com.example.dilip.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.jjoe64.graphview.GridLabelRenderer.GridStyle.NONE;


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
            int randomNum = rand.nextInt((100 - 0) + 1) + 100;
            arrayValues[i] = randomNum;
        }
        return arrayValues;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        //graph.setDrawBackground(true);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        //series.setDrawBackground(true);
        //series.setBackgroundColor(Color.BLACK);
        series.setColor(Color.GREEN);
        GridLabelRenderer glr=graph.getGridLabelRenderer();
        Viewport vp=graph.getViewport();
        vp.setBackgroundColor(Color.BLACK);
        glr.setGridColor(Color.WHITE);
        glr.setGridStyle(NONE);
        glr.setHorizontalAxisTitleColor(Color.WHITE);
        glr.setVerticalAxisTitleColor(Color.WHITE);
        glr.setHorizontalLabelsColor(Color.WHITE);
        glr.setVerticalLabelsColor(Color.WHITE);
        glr.setVerticalLabelsSecondScaleColor(Color.WHITE);
        graph.addSeries(series);
        bt = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
