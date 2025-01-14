package org.example.utils;

public class StringUtils {

    public static boolean isBlank(String input) {
        return input == null || input.trim().isBlank();
    }
}
