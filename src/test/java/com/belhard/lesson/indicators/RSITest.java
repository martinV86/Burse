package com.belhard.lesson.indicators;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class RSITest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        double rs;
        double ema_u;
         double ema_d;
         int rsi;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void calculationEMA() {
        List<Integer>startTraging=new ArrayList<Integer>(){{
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
        double ema_u=0.0;
        int down=0;
        double ema_d=0.0;
        int up=0;
        int a=0;
        int ema_down;
        int ema_up;
        while (a!=startTraging.size()){
            if(startTraging.get(a)>endTraging.get(a)){
                ema_up=startTraging.get(a)-endTraging.get(a);
                up=++up;
                ema_u=ema_u+ema_up;
            }
            if (startTraging.get(a)<endTraging.get(a)){
                ema_down=endTraging.get(a)-startTraging.get(a);
                down=++down;
                ema_d=ema_d+ema_down;
            }
            a=a++;
        }
        ema_u=ema_u/up;
        ema_d=ema_d/down;
    }

    @org.junit.jupiter.api.Test
    void calculationRS() {

    }

    @org.junit.jupiter.api.Test
    void calculationRSI() {
    }
}