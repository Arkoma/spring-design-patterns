package com.frankmoley.lil.designpatternsapp.factory;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PetFactoryTest {

    private PetFactory underTest = new PetFactory();

    @Test
    public void adoptPetReturnsCatWithProperCasing() {
        Pet result = underTest.adoptPet("cat");
        assertEquals("Cat", result.getClass().getSimpleName());
    }

    @Test
    public void adoptPetReturnsDogWithProperCasing() {
        Pet result = underTest.adoptPet("dog");
        assertEquals("Dog", result.getClass().getSimpleName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwsExceptionWithUnexpectedInput() {
        underTest.adoptPet("walrus");
    }

    @Test
    public void adoptPetSanitizesImproperlyCasedInputs() {
        Pet result = underTest.adoptPet("dOG");
        assertEquals("Dog", result.getClass().getSimpleName());
    }
}