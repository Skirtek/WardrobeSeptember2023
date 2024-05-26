package com.codecool.clothes;

public class Skirt extends Cloth implements LowerCloth {
    public Skirt(String brand) {
        super(brand, ClothType.LOWER);
    }
}
