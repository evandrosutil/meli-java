package com.person.age.util;

import java.time.LocalDate;
import java.time.Period;

public class CalcAge {

    private static int year;
    private static int month;
    private static int day;

    public static int execute(int year, int month, int day) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);

        System.out.println(Period.between(birthday, today).getYears());
        return Period.between(birthday, today).getYears();
    }
}