package ru.mbt_bs.fluffy_crm.data.repository;

import ru.mbt_bs.fluffy_crm.data.json.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerRepository {
    Map<String, Object> getCustomer(Integer id);
    void updateCustomer(Customer customer);
    List<Map<String, Object>> getCustomerLinks(String name);
}
