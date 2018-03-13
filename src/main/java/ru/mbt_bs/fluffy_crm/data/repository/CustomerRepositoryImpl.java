package ru.mbt_bs.fluffy_crm.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;

import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CustomerLink> getCustomerLinks(String name) {
        List<CustomerLink> result = new LinkedList<>();
        StringBuilder query = new StringBuilder("SELECT id,name FROM customer ");
        if (name != null && !name.isEmpty()) {
            query.append(" WHERE UPPER(name) LIKE '%");
            for (char Char : name.toUpperCase().toCharArray()) {
                query.append(Char).append("%");
            }
            query.append("' ");
        }
        query.append("ORDER BY name");

        for (Map row : jdbcTemplate.queryForList(query.toString())) {
            CustomerLink customerLink = new CustomerLink();
            customerLink.setId((Integer) row.get("id"));
            customerLink.setName((String) row.get("name"));
            result.add(customerLink);
        }

        return result;
    }
}
