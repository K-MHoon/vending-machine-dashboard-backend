package com.kmhoon.dashboard.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateTimeUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static LocalDate strToLocalDate(final String str) {
        if(str == null || str.isEmpty()) {
            return null;
        }
        return LocalDate.parse(str, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
