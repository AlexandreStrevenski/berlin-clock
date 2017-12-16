package com.ubs.opsit.interviews;


public class BerlinClock implements TimeConverter {


    private static final char RED      = 'R';
    private static final char YELLOW   = 'Y';
    private static final char OFF      = 'O';

    @Override
    public String convertTime(String aTime) {
        BerlinTime time = BerlinTime.parse(aTime);
        StringBuilder sb = new StringBuilder();
        sb.append(getSeconds(time.getSecond()) + System.lineSeparator());
        sb.append(getHoursOnFirstLine(time.getHour()) +  System.lineSeparator());
        sb.append(getHoursOnSecondLine(time.getHour()) + System.lineSeparator());
        sb.append(getMinutesOnThirdLine(time.getMinute()) + System.lineSeparator());
        sb.append(getMinutesOnFourthLine(time.getMinute()));

        return sb.toString();
    }

    public String getHoursOnFirstLine(Integer hours) {
        BerlinTime.isValidHour(hours);
        Integer lightsToTurnOnFirstLine = hours / 5;

        char[] firstLine = {OFF,OFF,OFF,OFF};
        for (int i = 0; i < lightsToTurnOnFirstLine; i++){
            firstLine[i] = RED;
        }

        return new String(firstLine);
    }

    public String getHoursOnSecondLine(Integer hours) {
        BerlinTime.isValidHour(hours);
        Integer lightsToTurnOnSecondLine = hours % 5;

        char[] secondLine = {OFF,OFF,OFF,OFF};
        for (int i = 0; i < lightsToTurnOnSecondLine; i++){
            secondLine[i] = RED;
        }

        return new String(secondLine);
    }

    public String getMinutesOnThirdLine(Integer minutes) {
        BerlinTime.isValidMinute(minutes);
        Integer lightsToTurnOffThirdLine = minutes / 5;

        char[] thirdLine = {YELLOW,YELLOW,RED,
                            YELLOW,YELLOW,RED,
                            YELLOW,YELLOW,RED,
                            YELLOW,YELLOW};

        for (int i = lightsToTurnOffThirdLine; i < thirdLine.length; i++){
            thirdLine[i] = OFF;
        }

        return new String(thirdLine);
    }

    public String getMinutesOnFourthLine(Integer minutes) {
        BerlinTime.isValidMinute(minutes);
        Integer lightsToTurnOnFourthLine = minutes % 5;

        char[] fourthLine = {OFF,OFF,OFF,OFF};
        for (int i = 0; i < lightsToTurnOnFourthLine; i++){
            fourthLine[i] = YELLOW;
        }

        return new String(fourthLine);
    }

    public char getSeconds(Integer seconds) {
        BerlinTime.isValidSecond(seconds);
        return (isEven(seconds) ? YELLOW : OFF);
    }

    private boolean isEven(Integer seconds) {
        return seconds % 2 == 0;
    }
}
