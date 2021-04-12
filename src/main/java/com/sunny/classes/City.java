package com.sunny.classes;

import java.util.UUID;

public final class City {
    private final String id;
    private final String name;

    public City(String id, String name){
        this.id = id;
        this.name = name;
    }

    public City(String name){
        this.id = String.valueOf(UUID.randomUUID());
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}