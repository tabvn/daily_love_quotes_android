package com.tabvn.dailylovequotes;

public class Filter {
    private String type;
    private String value;

    public Filter(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
