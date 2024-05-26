package com.codecool.clothes;

public class Shirt extends Cloth implements UpperCloth {
    public Shirt(String brand) {
        super(brand, ClothType.UPPER);
    }
}
