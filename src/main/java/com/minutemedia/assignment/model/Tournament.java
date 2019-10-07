package com.minutemedia.assignment.model;

import java.util.UUID;

public class Tournament {
    private String id;
    private String name;

    public Tournament(String id, String name) {
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
