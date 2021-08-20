package com.frankmoley.lil.designpatternsapp.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetFactoryIT {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void petFactoryIsABean() {
        assertTrue(this.applicationContext.containsBean("petFactory"));
    }
}
