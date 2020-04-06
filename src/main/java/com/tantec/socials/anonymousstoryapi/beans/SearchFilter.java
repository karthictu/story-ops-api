package com.tantec.socials.anonymousstoryapi.beans;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class SearchFilter {

    @Getter
    @Setter
    private String filterType;

    @Getter
    private Map<String, String> conditions;

    public SearchFilter() {
        this.filterType = "AND";
        this.conditions = new HashMap<String, String>();
    }

    public void addCondition(String key, String value) {
        this.conditions.put(key, value);
    }
    
}