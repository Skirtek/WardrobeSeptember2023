package com.codecool.clothes;

public class Blouse extends Cloth implements UpperCloth {
    public Blouse(String brand) {
        super(brand, ClothType.UPPER);
    }
}
