package ru.mbt_bs.fluffy_crm.converters;

import ru.mbt_bs.fluffy_crm.data.json.Customer;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomerConverter {
    public static List<CustomerLink> convertCustomerLinks(List<Map<String, Object>> customerLinks) {
        List<CustomerLink> result = new LinkedList<>();
        for (Map row : customerLinks) {
            CustomerLink customerLink = new CustomerLink();
            customerLink.setId((Integer) row.get("id"));
            customerLink.setName((String) row.get("name"));
            result.add(customerLink);
        }
        return result;
    }

    public static Customer convertCustomer(Map<String, Object> customer) {
        Customer result = new Customer();
        if (customer != null && !customer.isEmpty()) {
            result.setId((Integer) customer.get("id"));
            result.setName((String) customer.get("name"));
            result.setBirthDate((Date) customer.get("bdate"));
            result.setPhone((String) customer.get("phone"));
            result.setEmail((String) customer.get("email"));
            result.setComment((String) customer.get("comment"));
        }
        return result;
    }
}
