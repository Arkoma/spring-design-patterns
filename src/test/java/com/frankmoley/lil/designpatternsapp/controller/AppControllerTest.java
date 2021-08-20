package com.frankmoley.lil.designpatternsapp.controller;

import com.frankmoley.lil.designpatternsapp.factory.Dog;
import com.frankmoley.lil.designpatternsapp.factory.Pet;
import com.frankmoley.lil.designpatternsapp.factory.PetFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest {

    @InjectMocks
    private AppController underTest;

    @Mock
    private PetFactory mockPetFactory;

    @Test
    public void getDefaultReturnsExpectedString() {
        assertEquals("{\"message\": \"Hello World\"}", underTest.getDefault());
    }

    @Test
    public void adoptPetReturnsExpectedPet() {
        when(mockPetFactory.adoptPet(anyString())).thenReturn(new Dog());
        Pet result = underTest.adoptPet("", "");
        assertEquals("Dog", result.getClass().getSimpleName());
    }

    @Test
    public void adoptPetSetsPetsName() {
        Dog mockDog = mock(Dog.class);
        when(mockPetFactory.adoptPet(anyString())).thenReturn(mockDog);
        underTest.adoptPet("", "");
        verify(mockDog, times(1)).setName(anyString());
    }

    @Test
    public void adoptPetFeedsPet() {
        Dog mockDog = mock(Dog.class);
        when(mockPetFactory.adoptPet(anyString())).thenReturn(mockDog);
        underTest.adoptPet("", "");
        verify(mockDog, times(1)).feed();
    }
}