package com.example.week5_2023_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar sb;
    TextView tv;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb=(SeekBar) findViewById(R.id.seekBar);
        sb.setProgress(10);
        tv=(TextView) findViewById(R.id.myTv);
        tv.setText(""+sb.getProgress());
        lv=(ListView) findViewById(R.id.myList);

        inflate();
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                inflate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void inflate() {
        tv.setText(""+sb.getProgress());
        String[] str= new String[12];
        for(int i=1;i<=12;i++){
            str[i-1]=""+i+"*"+sb.getProgress()+"="+(i*sb.getProgress());
        }

        ArrayAdapter<String> myAdap = new  ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,str);
        lv.setAdapter(myAdap);
    }
}