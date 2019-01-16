package com.example.jinny.expandablereportdemo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, TextView> _expandableListDetail;

    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       HashMap<String, TextView> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this._expandableListDetail = _expandableListDetail;
    }


    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //size?
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.expandableListTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //return this._expandableListDetail.get(this.expandableListTitle.get(groupPosition)).getText();
        return "";
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.list_Title);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        EditText expandedListTextView = (EditText) convertView
                .findViewById(R.id.expandedListItem);
        if (groupPosition == 0) {
            expandedListTextView.setHint("What happened?");
        }else if (groupPosition == 1) {
            expandedListTextView.setHint("Where did it happen?");
        }else if (groupPosition ==2) {
            expandedListTextView.setHint("When did it happen?");
        }else if (groupPosition == 3) {
            expandedListTextView.setHint("Who was the perpetrator(s)?");
        }else {
            expandedListTextView.setHint("Anything else you want to report about?");
        }
        if (!expandedListText.equals(""))
            expandedListTextView.setText(expandedListText);
        
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
