package com.ubs.opsit.interviews;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;


public class BerlinClockHoursTest {

    private BerlinClock berlinClock;

    private final Integer FIVE_PM = 17;
    private final Integer SIX_PM  = 18;

    private final String MID_NIGHT          =   "OOOO";
    private final String FIVE_PM_FISRT_LINE =   "RRRO";
    private final String SIX_PM_SECOND_LINE =   "RRRO";

    @Before
    public void setUp(){
        berlinClock = new BerlinClock();
    }

    @Test
    public void testHoursOnTheFirstLine(){
        String hours = berlinClock.getHoursOnFirstLine(FIVE_PM);
        assertThat(hours, is(FIVE_PM_FISRT_LINE));
    }

    @Test
    public void testWrongHoursOnTheFirstLine(){
        String hours = berlinClock.getHoursOnFirstLine(FIVE_PM);
        assertThat(hours, not(MID_NIGHT));
    }

    @Test(expected = DateTimeException.class)
    public void testInvalidHoursOnTheFirstLine(){
        berlinClock.getHoursOnFirstLine(35);
    }

    @Test
    public void testHoursOnSecondLine(){
        String hours = berlinClock.getHoursOnSecondLine(SIX_PM);
        assertThat(hours, is(SIX_PM_SECOND_LINE));
    }

    @Test
    public void testWrongHoursOnSecondLine(){
        String hours = berlinClock.getHoursOnSecondLine(SIX_PM);
        assertThat(hours, not(MID_NIGHT));
    }

    @Test(expected = DateTimeException.class)
    public void testInvalidHoursOnTheSecondLine(){
        berlinClock.getHoursOnSecondLine(28);
    }

    @After
    public void tearDown(){
        berlinClock = null;
    }


}
