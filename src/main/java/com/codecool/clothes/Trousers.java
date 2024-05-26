package com.codecool.clothes;

public class Trousers extends Cloth implements LowerCloth {
    public Trousers(String brand) {
        super(brand, ClothType.LOWER);
    }
}
