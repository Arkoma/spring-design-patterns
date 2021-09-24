package com.frankmoley.lil.designpatternsapp.decorator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    @Test
    public void testDedcorator() {
        Pizza pizza = new ThickCrustPizza();
        assertEquals("Thick Crust Pizza", pizza.getDescription());
        assertEquals(new BigDecimal(15), pizza.getCost());

        Pepperoni pepperoni = new Pepperoni(pizza);
        assertEquals("Thick Crust Pizza + pepperoni", pepperoni.getDescription());
        assertEquals(new BigDecimal("16.5"), pepperoni.getCost());

        Pepperoni doublePepperoni = new Pepperoni(pepperoni);
        assertEquals("Thick Crust Pizza + pepperoni + pepperoni", doublePepperoni.getDescription());
        assertEquals(new BigDecimal(18).intValue(), Math.round(doublePepperoni.getCost().floatValue()));

    }
}
