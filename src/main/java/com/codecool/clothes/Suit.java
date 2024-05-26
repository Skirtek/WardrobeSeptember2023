package com.codecool.clothes;

public class Suit extends Cloth implements UpperCloth {
    public Suit(String brand) {
        super(brand, ClothType.UPPER);
    }
}
