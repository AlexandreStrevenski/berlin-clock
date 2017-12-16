package com.ubs.opsit.interviews;


import java.time.DateTimeException;

public class BerlinTime {

    private static final Integer MAX_DAY_HOUR = 24;
    private static final Integer MAX_MINUTES = 60;
    private static final Integer MAX_SECONDS = 60;

    private Integer hour;
    private Integer minute;
    private Integer second;

    public static BerlinTime parse(String aTime) {
        String[] split = aTime.split(":");
        if (split.length != 3){ throw new DateTimeException("Wrong time format. The time format should be HH:mm:ss"); }

        Integer hour = Integer.parseInt(split[0]);
        isValidHour(hour);

        Integer minute = Integer.parseInt(split[1]);
        isValidMinute(minute);

        Integer second = Integer.parseInt(split[2]);
        isValidSecond(second);

        return new BerlinTime(hour, minute, second);
    }

    public static void isValidHour(Integer hour) {
        if (hour > MAX_DAY_HOUR){
            throw new DateTimeException(String.format("%s is a invalid hour. The range is from 0 to 24.", hour));
        }
    }

    public static void isValidMinute(Integer minute) {
        if (minute > MAX_MINUTES){
            throw new DateTimeException(String.format("%s is a invalid minute. The range is from 0 to 60.", minute));
        }
    }

    public static void isValidSecond(Integer second) {
        if (second > MAX_SECONDS){
            throw new DateTimeException(String.format("%s is a invalid second. The range is from 0 to 60.", second));
        }
    }

    private BerlinTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public Integer getSecond() {
        return second;
    }
}
