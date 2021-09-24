package com.frankmoley.lil.designpatternsapp.prototype;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProtoTypeIT {

    @Autowired
    FooProtoType fooProtoType1;

    @Autowired
    FooProtoType fooProtoType2;

    @Autowired
    BarNotPrototype barNotPrototype1;

    @Autowired
    BarNotPrototype barNotPrototype2;

    @Test
    public void prototypesAreNotSame() {
        assertSame(barNotPrototype1, barNotPrototype2);
        assertNotSame(fooProtoType1, fooProtoType2);
    }
}