package com.frankmoley.lil.designpatternsapp.factory;

import org.springframework.stereotype.Component;

@Component
public class PetFactory {

    public Pet adoptPet(String animalType) {
        switch (animalType.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            default:
                throw new UnsupportedOperationException("unknown animal type");
        }
    }
}
