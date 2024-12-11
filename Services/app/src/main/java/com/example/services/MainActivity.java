package com.example.services;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        Log.i("mylog", //tag name
                "thread id in main activity is:" + Thread.currentThread().getId()); //id of thread
        //event handling for start service button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start the service
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                startService(intent);
            }
        });

        //event handling for stop the service button
        stop.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stop the service
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                stopService(intent);
            }
        }));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}