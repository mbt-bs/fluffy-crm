package ru.mbt_bs.fluffy_crm.converters;

import ru.mbt_bs.fluffy_crm.data.json.Customer;
import ru.mbt_bs.fluffy_crm.data.json.Service;
import ru.mbt_bs.fluffy_crm.data.json.Work;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WorkConverter {
    public static List<Work> convertWorkList(List<Map<String, Object>> workList) {
        List<Work> result = new LinkedList<>();
        for (Map row : workList) {
            Work work = new Work();
            work.setId((Long) row.get("id"));
            work.setCustomer(new Customer((Long) row.get("customer_id")));
            work.setService(new Service((Long) row.get("service_id")));
            work.setDate(new Date(((java.sql.Date) row.get("date")).getTime()));
            result.add(work);
        }
        return result;
    }
}
