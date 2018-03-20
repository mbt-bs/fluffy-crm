package ru.mbt_bs.fluffy_crm.services;

import ru.mbt_bs.fluffy_crm.data.json.Customer;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;
import ru.mbt_bs.fluffy_crm.data.json.Work;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id);
    void updateCustomer(Customer customer);
    List<CustomerLink> getCustomers(String name);
    void fillCustomerLinksInWorkList(List<Work> works);
}
