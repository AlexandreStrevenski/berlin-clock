package com.ubs.opsit.interviews;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BerlinClockSecondsTest {

    private static final Integer EVEN_SECOND = 26;
    private static final Integer ODD_SECOND  = 25;


    private BerlinClock berlinClock;

    @Before
    public void setUp(){
        berlinClock = new BerlinClock();
    }

    @Test
    public void testEvenSeconds(){
        char seconds = berlinClock.getSeconds(EVEN_SECOND);
        assertThat(seconds, is('Y'));
    }

    @Test
    public void testOddSeconds(){
        char seconds = berlinClock.getSeconds(ODD_SECOND);
        assertThat(seconds, is('O'));
    }

    @Test(expected = DateTimeException.class)
    public void testInvalidSeconds(){
        berlinClock.getSeconds(75);
    }

    @After
    public void tearDown(){
        berlinClock = null;
    }
}
