package com.example.demo;

import com.example.demo.objectMother.PopulatorBBDD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PopulationTest {
    @Autowired
    PopulatorBBDD populatorBBDD;

    @Test
    void test() {

    }
}
