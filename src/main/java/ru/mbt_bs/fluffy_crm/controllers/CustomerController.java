package ru.mbt_bs.fluffy_crm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mbt_bs.fluffy_crm.data.json.Customer;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;
import ru.mbt_bs.fluffy_crm.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customer")
    public Customer getCustomer(@RequestParam(name = "id", required = false) Integer id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping("/customers")
    public List<CustomerLink> getCustomerLinks(@RequestParam(name = "name", required = false) String name) {
        return customerService.getCustomers(name);
    }
}
