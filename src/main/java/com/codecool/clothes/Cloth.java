package com.codecool.clothes;

public abstract class Cloth {
    private int id;

    private String brand;

    private ClothType type;

    private static int currentId = 1;

    public Cloth(String brand, ClothType type) {
        this.id = currentId++;
        this.brand = brand;
        this.type = type;
    }

    public ClothType getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
