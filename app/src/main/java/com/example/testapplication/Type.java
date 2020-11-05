package com.example.testapplication;

public class Type {
    private String name;
    private boolean expanded;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public Type(String name, boolean expanded) {
        this.name = name;
        this.expanded = expanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
