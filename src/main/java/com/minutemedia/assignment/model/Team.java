package com.minutemedia.assignment.model;

import java.util.UUID;

public class Team {
    private String id;
    private String name;

    public Team(String id, String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
