package ru.mbt_bs.fluffy_crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mbt_bs.fluffy_crm.converters.CustomerConverter;
import ru.mbt_bs.fluffy_crm.data.json.Customer;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;
import ru.mbt_bs.fluffy_crm.data.json.Work;
import ru.mbt_bs.fluffy_crm.data.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private WorkService workService;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, WorkService workService) {
        this.customerRepository = customerRepository;
        this.workService = workService;
    }

    @Override
    public Customer getCustomer(Long id) {
        List<Work> workList = workService.getWorkAndServiceList(id);
        return CustomerConverter.convertCustomer(customerRepository.getCustomer(id), workList);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public List<CustomerLink> getCustomers(String name) {
        return CustomerConverter.convertCustomerLinks(customerRepository.getCustomerLinks(name));
    }
}
