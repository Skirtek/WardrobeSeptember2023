package com.codecool.hangers;

import com.codecool.clothes.Cloth;
import com.codecool.clothes.LowerCloth;
import com.codecool.exceptions.HangerAlreadyInUse;

import java.util.Optional;

public class SingleHanger implements Hanger {
    private Cloth upperCloth;

    public void fillUpperCloth(Cloth cloth) throws HangerAlreadyInUse, IllegalArgumentException {
        if (upperCloth != null) {
            throw new HangerAlreadyInUse("Hanger already in use!");
        }

        if (cloth instanceof LowerCloth) {
            throw new IllegalArgumentException("Lower cloth is not valid in this hanger place");
        }

        upperCloth = cloth;
    }

    public void removeUpperCloth() {
        upperCloth = null;
    }

    public Optional<Cloth> getClothById(int id) {
        return upperCloth != null && upperCloth.getId() == id
                ? Optional.of(upperCloth)
                : Optional.empty();
    }

    @Override
    public Cloth getUpperCloth() {
        return upperCloth;
    }
}
