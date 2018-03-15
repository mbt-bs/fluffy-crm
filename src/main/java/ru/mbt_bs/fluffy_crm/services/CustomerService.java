package ru.mbt_bs.fluffy_crm.services;

import ru.mbt_bs.fluffy_crm.data.json.Customer;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;

import java.util.List;

public interface CustomerService {
    List<CustomerLink> getCustomers(String name);
    Customer getCustomer(Integer id);
}
