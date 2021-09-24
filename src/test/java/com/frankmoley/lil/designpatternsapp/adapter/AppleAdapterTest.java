package com.frankmoley.lil.designpatternsapp.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AppleAdapterTest {

    @Mock
    private MoroOrange mockMoroOrange;

    private Orange orange;

    @Test
    public void orangeGetsPeeledWhenEaten() {
        Orange orange = mockMoroOrange;
        Apple apple = new AppleAdapter(orange);
        apple.eat();
        verify(mockMoroOrange, times(1)).peel();
        verify(mockMoroOrange, times(1)).eat();
        verify(mockMoroOrange, times(0)).juice();
    }
}