package com.frankmoley.lil.designpatternsapp.singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonIT {

    @Autowired
    private NewSchoolSpringSingleton newSchoolSpringSingleton1;

    @Autowired
    private NewSchoolSpringSingleton newSchoolSpringSingleton2;

    @Test
    public void bothSchoolsMakeSameSingleton() {
        OldSchoolSingleton oldSchoolSingleton1 = OldSchoolSingleton.getInstance();
        OldSchoolSingleton oldSchoolSingleton2 = OldSchoolSingleton.getInstance();
        assertNotNull(oldSchoolSingleton1);
        assertSame(oldSchoolSingleton1, oldSchoolSingleton2);
        assertNotNull(newSchoolSpringSingleton1);
        assertSame(newSchoolSpringSingleton1, newSchoolSpringSingleton2);
    }

}