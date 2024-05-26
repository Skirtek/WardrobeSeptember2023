package com.codecool;

import com.codecool.clothes.Cloth;
import com.codecool.clothes.ClothType;
import com.codecool.clothes.UpperCloth;
import com.codecool.exceptions.MaxCapacityReachException;
import com.codecool.hangers.DoubleHanger;
import com.codecool.hangers.Hanger;
import com.codecool.hangers.SingleHanger;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Wardrobe {
    private int maxNumberOfHangers;

    private List<Hanger> listOfHangers;

    public Wardrobe(int maxNumberOfHangers) {
        this.maxNumberOfHangers = maxNumberOfHangers;
        listOfHangers = new ArrayList<>();
    }

    public void addHanger(Hanger hanger) {
        if (listOfHangers.size() >= maxNumberOfHangers) {
            throw new MaxCapacityReachException("You can't have more hangers in this wardrobe");
        }

        listOfHangers.add(hanger);
    }

    public Optional<Cloth> getClothById(int id) {
        return listOfHangers
                .stream()
                .map(hanger -> hanger.getClothById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    public void hangCloth(Cloth cloth) {
        if (cloth instanceof UpperCloth) {
            Hanger hanger = listOfHangers
                    .stream()
                    .filter(h -> h.getUpperCloth() == null)
                    .findAny()
                    .orElseThrow(NoSuchElementException::new);

            hanger.fillUpperCloth(cloth);
        } else {
            DoubleHanger doubleHanger = listOfHangers
                    .stream()
                    .filter(h -> h instanceof DoubleHanger dh && dh.isLowerClothEmpty())
                    .map(h -> (DoubleHanger) h)
                    .findAny()
                    .orElseThrow(NoSuchElementException::new);

            doubleHanger.fillLowerCloth(cloth);
        }
    }

    public boolean isPossibleToHangCloth(Cloth cloth) {
        if (cloth instanceof UpperCloth) {
            return listOfHangers
                    .stream()
                    .anyMatch(h -> h.getUpperCloth() == null);
        } else {
            return listOfHangers
                    .stream()
                    .anyMatch(h -> h instanceof DoubleHanger dh && dh.isLowerClothEmpty());
        }
    }
}
