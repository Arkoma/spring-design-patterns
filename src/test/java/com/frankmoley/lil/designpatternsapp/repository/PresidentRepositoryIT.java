package com.frankmoley.lil.designpatternsapp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@DirtiesContext
@RunWith(SpringRunner.class)
/*
  This test depends on data that is seeded in the database using the data.sql file
  in the resources folder
 */
public class PresidentRepositoryIT {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private PresidentRepository underTest;

    @Test
    public void presidentRepositoryIsABean() {
        assertTrue(applicationContext.containsBean("presidentRepository"));
    }

    @Test
    public void testFindByEmail() {
        String firstName = "John";
        String lastName = "Adams";
        String email = "John.Adams@wh.gov";
        Optional<PresidentEntity> presidentEntity = underTest.findPresidentEntityByEmailAddress(email);
        assertTrue(presidentEntity.isPresent());
        assertEquals(firstName, presidentEntity.get().getFirstName());
        assertEquals(lastName, presidentEntity.get().getLastName());
    }

}