package ru.mbt_bs.fluffy_crm.converters;

import ru.mbt_bs.fluffy_crm.data.json.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServiceConverter {
    public static String convertTitle(Map<String, Object> row) {
        return (String) row.get("title");
    }

    public static List<Service> convertServiceList(List<Map<String, Object>> data) {
        List<Service> result = new LinkedList<>();
        for (Map<String, Object> row : data) {
            Service service = new Service();
            service.setId((Long) row.get("id"));
            service.setTitle((String) row.get("title"));
            result.add(service);
        }
        return result;
    }
}
