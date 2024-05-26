package com.codecool;

import com.codecool.clothes.Shirt;
import com.codecool.clothes.Trousers;
import com.codecool.hangers.DoubleHanger;
import com.codecool.hangers.SingleHanger;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe(10);

        int hangersOfEachTypeAmount = 5;

        IntStream.range(0, hangersOfEachTypeAmount) // 0, 1, 2, 3, 4
                .mapToObj(_ -> new SingleHanger())
                .toList()
                .forEach(wardrobe::addHanger);

        IntStream.range(0, hangersOfEachTypeAmount) // 0, 1, 2, 3, 4
                .mapToObj(_ -> new DoubleHanger())
                .toList()
                .forEach(wardrobe::addHanger);

        IntStream.range(0, 11) // 0, 1, 2, 3, 4
                .mapToObj(_ -> new Shirt("House"))
                .toList()
                .forEach(shirt -> {
                    boolean canHang = wardrobe.isPossibleToHangCloth(shirt);

                    if (!canHang) {
                        System.out.println("Can not hang shirt - no available hanger at this moment");
                        return;
                    }

                    wardrobe.hangCloth(shirt);
                });

        IntStream.range(0, hangersOfEachTypeAmount) // 0, 1, 2, 3, 4
                .mapToObj(_ -> new Trousers("Cropp"))
                .toList()
                .forEach(wardrobe::hangCloth);
    }
}