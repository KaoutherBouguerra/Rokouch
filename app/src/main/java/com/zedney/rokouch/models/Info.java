package com.zedney.rokouch.models;

public class Info {
    String title;
    String val;

    public Info(String title, String val) {
        this.title = title;
        this.val = val;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}

