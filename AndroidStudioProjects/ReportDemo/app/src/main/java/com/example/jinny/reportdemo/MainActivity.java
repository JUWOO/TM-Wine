package com.example.jinny.reportdemo;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button whatBtn, whereBtn, whenBtn, whoBtn, detailsBtn, saveBtn;
    private EditText whatText, whereText, whenText, whoText, detailsText;
    private CheckBox whatCheck, whereCheck, whenCheck, whoCheck, detailsCheck;
    private View whatView, whereView, whenView, whoView, detailsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatBtn = (Button) findViewById(R.id.whatBtn);
        whatText = (EditText) findViewById(R.id.whatText);
        whatCheck = (CheckBox) findViewById(R.id.whatCheck);
        whatView = (View) findViewById(R.id.view1);

        whereBtn = (Button) findViewById(R.id.whereBtn);
        whereText = (EditText) findViewById(R.id.whereText);
        whereCheck = (CheckBox) findViewById(R.id.whereCheck);
        whereView = (View) findViewById(R.id.view2);

        whenBtn = (Button) findViewById(R.id.whenBtn);
        whenText = (EditText) findViewById(R.id.whenText);
        whenCheck = (CheckBox) findViewById(R.id.whenCheck);
        whenView = (View) findViewById(R.id.view3);

        whoBtn = (Button) findViewById(R.id.whoBtn);
        whoText = (EditText) findViewById(R.id.whoText);
        whoCheck = (CheckBox) findViewById(R.id.whoCheck);
        whoView = (View) findViewById(R.id.view4);

        detailsBtn = (Button) findViewById(R.id.detailsBtn);
        detailsText = (EditText) findViewById(R.id.detailsText);
        detailsCheck = (CheckBox) findViewById(R.id.detailsCheck);
        detailsView = (View) findViewById(R.id.view5);

        saveBtn = (Button) findViewById(R.id.saveBtn);

        //open and collapse edit text on button click
        whatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whatText.getVisibility() == View.GONE) {
                    if (whereText.getVisibility() == View.VISIBLE || whenText.getVisibility() == View.VISIBLE || whoText.getVisibility() == View.VISIBLE || detailsText.getVisibility() == View.VISIBLE)
                        whereText.setVisibility(View.GONE);
                    whenText.setVisibility(View.GONE);
                    whoText.setVisibility(View.GONE);
                    detailsText.setVisibility(View.GONE);
                    whatText.setVisibility(View.VISIBLE);
                } else {
                    whatText.setVisibility(View.GONE);
                }
                enableBoxes(whatText, whatCheck, saveBtn);
                enableUnderline(whatText, whatView, whereView, whenView, whoView, detailsView);
            }
        });
        whereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whereText.getVisibility() == View.GONE) {
                    if (whatText.getVisibility() == View.VISIBLE || whenText.getVisibility() == View.VISIBLE || whoText.getVisibility() == View.VISIBLE || detailsText.getVisibility() == View.VISIBLE)
                        whatText.setVisibility(View.GONE);
                    whenText.setVisibility(View.GONE);
                    whoText.setVisibility(View.GONE);
                    detailsText.setVisibility(View.GONE);
                    whereText.setVisibility(View.VISIBLE);
                } else {
                    whereText.setVisibility(View.GONE);
                }
                enableBoxes(whereText, whereCheck, saveBtn);
                enableUnderline(whereText, whereView, whatView, whenView, whoView, detailsView);
            }
        });
        whenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whenText.getVisibility() == View.GONE) {
                    if (whatText.getVisibility() == View.VISIBLE || whereText.getVisibility() == View.VISIBLE || whoText.getVisibility() == View.VISIBLE || detailsText.getVisibility() == View.VISIBLE)
                        whatText.setVisibility(View.GONE);
                    whereText.setVisibility(View.GONE);
                    whoText.setVisibility(View.GONE);
                    detailsText.setVisibility(View.GONE);
                    whenText.setVisibility(View.VISIBLE);
                } else {
                    whenText.setVisibility(View.GONE);
                }
                enableBoxes(whenText, whenCheck, saveBtn);
                enableUnderline(whenText, whenView, whatView, whereView, whoView, detailsView);
            }
        });
        whoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whoText.getVisibility() == View.GONE) {
                    if (whatText.getVisibility() == View.VISIBLE || whereText.getVisibility() == View.VISIBLE || whenText.getVisibility() == View.VISIBLE || detailsText.getVisibility() == View.VISIBLE)
                        whatText.setVisibility(View.GONE);
                    whereText.setVisibility(View.GONE);
                    whenText.setVisibility(View.GONE);
                    detailsText.setVisibility(View.GONE);
                    whoText.setVisibility(View.VISIBLE);
                } else {
                    whoText.setVisibility(View.GONE);
                }
                enableBoxes(whoText, whoCheck, saveBtn);
                enableUnderline(whoText, whoView, whatView, whereView, whenView, detailsView);
            }
        });
        detailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailsText.getVisibility() == View.GONE) {
                    if (whatText.getVisibility() == View.VISIBLE || whereText.getVisibility() == View.VISIBLE || whoText.getVisibility() == View.VISIBLE || whenText.getVisibility() == View.VISIBLE)
                        whatText.setVisibility(View.GONE);
                    whereText.setVisibility(View.GONE);
                    whoText.setVisibility(View.GONE);
                    whenText.setVisibility(View.GONE);
                    detailsText.setVisibility(View.VISIBLE);
                } else {
                    detailsText.setVisibility(View.GONE);
                }
                enableBoxes(detailsText, detailsCheck, saveBtn);
                enableUnderline(detailsText, detailsView, whatView, whereView, whenView, whoView);
            }
        });
    }

    //enable checkbox and saveBtn when questions answered
    protected void enableBoxes(final EditText editText, final CheckBox checkBox, final Button saveBtn) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (editText.getText().length() > 0) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText.getText().length() > 0) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                saveBtn.setEnabled(true);
            }
        });
    }

    //set underline view to invisibility whenever edit text is shown
    protected void enableUnderline(TextView tv, View v1, View v2, View v3, View v4, View v5) {
        if (tv.getVisibility() == View.VISIBLE) {
            v1.setVisibility(View.INVISIBLE);
            v2.setVisibility(View.VISIBLE);
            v3.setVisibility(View.VISIBLE);
            v4.setVisibility(View.VISIBLE);
            v5.setVisibility(View.VISIBLE);
        } else {
            v1.setVisibility(View.VISIBLE);
        }
    }
}
