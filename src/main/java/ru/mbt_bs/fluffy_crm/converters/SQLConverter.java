package ru.mbt_bs.fluffy_crm.converters;

public class SQLConverter {
    public static String convertStringToLiker(String src) {
        StringBuilder result = new StringBuilder("%");
        for (char singleChar : src.toUpperCase().toCharArray()) {
            result.append(singleChar).append("%");
        }
        return result.toString();
    }
}
