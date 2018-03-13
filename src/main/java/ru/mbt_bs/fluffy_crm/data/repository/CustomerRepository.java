package ru.mbt_bs.fluffy_crm.data.repository;

import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;

import java.util.List;

public interface CustomerRepository {
    List<CustomerLink> getCustomerLinks(String name);
}
