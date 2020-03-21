package com.infinity.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int min=1;
    int timeTableNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        final SeekBar timeTableSeekBar = findViewById(R.id.tableSeekBar);
        final ListView table = findViewById(R.id.tableList);
        timeTableSeekBar.setProgress(1);
        timeTableSeekBar.setMax(20);

        generatTable(min,table);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if ( progress<1)
                {

                    timeTableSeekBar.setProgress(min);
                    timeTableNumber=min;
                }
                else
                {
                    timeTableNumber=progress;
                }
               generatTable(timeTableNumber,table);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    private void generatTable(int timeTableNumber, ListView table) {
        ArrayList<String> tableArray = new ArrayList<String>();
        for (int i=1; i<=10;i++)
        {


            tableArray.add(Integer.toString(timeTableNumber*i));
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tableArray );


        table.setAdapter(arrayAdapter);
    }
}
