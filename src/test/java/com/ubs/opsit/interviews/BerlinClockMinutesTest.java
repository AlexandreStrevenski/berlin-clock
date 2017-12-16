package com.ubs.opsit.interviews;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class BerlinClockMinutesTest {

    private BerlinClock berlinClock;

    private final Integer TWENTY_NINE_MINUTES = 29;

    private final String TWENTY_NINE_MINUTES_THIRD_LINE  = "YYRYYOOOOOO";
    private final String FIFTEEN_MINUTES_THIRD_LINE      = "YYROOOOOOOO";
    private final String TWENTY_NINE_MINUTES_FOURTH_LINE = "YYYY";
    private final String TWENTY_ONE_MINUTES_FOURTH_LINE  = "YOOO";


    @Before
    public void setUp(){
        berlinClock = new BerlinClock();
    }

    @Test
    public void testMinutesOnThirdLine(){
        String minutes = berlinClock.getMinutesOnThirdLine(TWENTY_NINE_MINUTES);
        assertThat(minutes, is(TWENTY_NINE_MINUTES_THIRD_LINE));
    }

    @Test
    public void testWrongMinutesOnThirdLine(){
        String minutes = berlinClock.getMinutesOnThirdLine(TWENTY_NINE_MINUTES);
        assertThat(minutes, not(FIFTEEN_MINUTES_THIRD_LINE));
    }

    @Test(expected = DateTimeException.class)
    public void testInvalidMinutesOnThirdLine(){
        berlinClock.getMinutesOnThirdLine(79);
    }

    @Test
    public void testMinutesOnFourthLine(){
        String minutes = berlinClock.getMinutesOnFourthLine(TWENTY_NINE_MINUTES);
        assertThat(minutes, is(TWENTY_NINE_MINUTES_FOURTH_LINE));
    }

    @Test
    public void testWrongMinutesOnFourthLine(){
        String minutes = berlinClock.getMinutesOnFourthLine(TWENTY_NINE_MINUTES);
        assertThat(minutes, not(TWENTY_ONE_MINUTES_FOURTH_LINE));
    }

    @Test(expected = DateTimeException.class)
    public void testInvalidMinutesOnFourthLine(){
        berlinClock.getMinutesOnFourthLine(79);
    }

    @After
    public void tearDown(){
        berlinClock = null;
    }
}
