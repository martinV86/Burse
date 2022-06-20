package com.belhard.lesson.indicators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LarryUTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void maxMinPrice() {

        List<Integer> startTraging=new ArrayList<Integer>(){{
            add(3);
            add(5);
            add(8);
            add(3);
            add(1);
        }};
        List<Integer>endTraging=new ArrayList<Integer>(){{
            add(5);
            add(8);
            add(3);
            add(1);
            add(6);
        }};
        int max= Collections.max(startTraging);
        int min=Collections.min(endTraging);
        System.out.println(max+" "+min);
    }



    @Test
    void close() {
    }

    @Test
    void larryU() {
    }
}