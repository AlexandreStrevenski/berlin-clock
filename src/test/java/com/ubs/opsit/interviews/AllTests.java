package com.ubs.opsit.interviews;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BerlinClockFixture.class,
        BerlinClockHoursTest.class,
        BerlinClockMinutesTest.class,
        BerlinClockSecondsTest.class})
public class AllTests {

}
