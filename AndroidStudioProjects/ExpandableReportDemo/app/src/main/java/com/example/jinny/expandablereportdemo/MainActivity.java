package com.example.jinny.expandablereportdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, TextView> _expandableListDetail;
    Button saveBtn;
    EditText expandedListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = (Button) findViewById(R.id.saveBtn);
        expandedListItem = (EditText) findViewById(R.id.expandedListItem);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        //make list data
        expandableListTitle = new ArrayList<String>();
        _expandableListDetail = new HashMap<String, TextView>();
        expandableListTitle.add("WHAT");
        expandableListTitle.add("WHERE");
        expandableListTitle.add("WHEN");
        expandableListTitle.add("WHO");
        expandableListTitle.add("DETAILS");
        final TextView whatText = ((TextView) findViewById(R.id.expandedListItem));
        _expandableListDetail.put(expandableListTitle.get(0), whatText);
        TextView whereText = ((TextView) findViewById(R.id.expandedListItem));
        _expandableListDetail.put(expandableListTitle.get(1), whereText);
        TextView whenText = ((TextView) findViewById(R.id.expandedListItem));
        _expandableListDetail.put(expandableListTitle.get(2), whenText);
        TextView whoText = ((TextView) findViewById(R.id.expandedListItem));
        _expandableListDetail.put(expandableListTitle.get(3), whoText);
        TextView detailsText = ((TextView) findViewById(R.id.expandedListItem));
        _expandableListDetail.put(expandableListTitle.get(4), detailsText);

        //textChangedListener
        //whatText.addTextChangedListener(editTextWatcher);
        //whereText.addTextChangedListener(editTextWatcher);

        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, _expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
    }
    /*
    private TextWatcher editTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            String editTextDetail = expandedListItem.toString().trim();
            saveBtn.setEnabled(editTextDetail.isEmpty());
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String editTextDetail = expandedListItem.toString().trim();
            saveBtn.setEnabled(!editTextDetail.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            String editedTextDetail = expandedListItem.getText().toString();
            expandedListItem.setText(editedTextDetail);
        }
    };
    */
}

