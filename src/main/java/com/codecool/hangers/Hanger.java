package com.codecool.hangers;

import com.codecool.clothes.Cloth;

import java.util.Optional;

public interface Hanger {
    Optional<Cloth> getClothById(int id);

    Cloth getUpperCloth();

    void fillUpperCloth(Cloth cloth);
}
