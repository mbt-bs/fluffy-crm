package ru.mbt_bs.fluffy_crm.converters;

import java.util.Map;

public class ServiceConverter {
    public static String convertTitle(Map<String, Object> row) {
        return (String) row.get("title");
    }
}
