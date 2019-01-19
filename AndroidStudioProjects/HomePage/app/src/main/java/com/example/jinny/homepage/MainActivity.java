package com.example.jinny.homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView report1, report2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        report1 = (TextView) findViewById(R.id.report1);
        report1.setText("User of this app may be now going through the tough time and under a lot of stress...");
        report2 = (TextView) findViewById(R.id.report2);
        report2.setText("#security #being trusted #supported #under my control #community support...");
    }
}
