package ru.mbt_bs.fluffy_crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;
import ru.mbt_bs.fluffy_crm.data.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerLink> getCustomers(String name) {
        return customerRepository.getCustomerLinks(name);
    }
}
