package ru.mbt_bs.fluffy_crm.data.repository;

import java.util.List;
import java.util.Map;

public interface CustomerRepository {
    List<Map<String, Object>> getCustomerLinks(String name);
    Map<String, Object> getCustomer(Integer id);
}
