package com.example.jinny.expandablereportdemo;

import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        expandableListDetail.put("WHAT", null);
        expandableListDetail.put("WHERE", null);
        expandableListDetail.put("WHEN", null);
        expandableListDetail.put("WHO", null);
        expandableListDetail.put("DETAILS", null);
        return expandableListDetail;
    }
}
