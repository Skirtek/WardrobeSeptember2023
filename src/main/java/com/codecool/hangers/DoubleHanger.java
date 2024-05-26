package com.codecool.hangers;

import com.codecool.clothes.Cloth;
import com.codecool.clothes.UpperCloth;
import com.codecool.exceptions.HangerAlreadyInUse;

import java.util.Optional;

public class DoubleHanger extends SingleHanger {
    private Cloth lowerCloth;

    public void fillLowerCloth(Cloth cloth) throws HangerAlreadyInUse, IllegalArgumentException {
        if (lowerCloth != null) {
            throw new HangerAlreadyInUse("Hanger already in use!");
        }

        if (cloth instanceof UpperCloth) {
            throw new IllegalArgumentException("Upper cloth is not valid in this hanger place");
        }

        this.lowerCloth = cloth;
    }

    public void removeLowerCloth() {
        lowerCloth = null;
    }

    public void removeUpperAndLowerCloth() {
        removeLowerCloth();
        removeUpperCloth();
    }

    @Override
    public Optional<Cloth> getClothById(int id) {
        Optional<Cloth> upperCloth = super.getClothById(id);

        if (upperCloth.isPresent()) {
            return upperCloth;
        }

        return lowerCloth != null && lowerCloth.getId() == id
                ? Optional.of(lowerCloth)
                : Optional.empty();
    }

    public boolean isLowerClothEmpty() {
        return lowerCloth == null;
    }

    public Cloth getLowerCloth() {
        return lowerCloth;
    }
}
