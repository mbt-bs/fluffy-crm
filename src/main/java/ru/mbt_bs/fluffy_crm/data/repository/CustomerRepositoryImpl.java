package ru.mbt_bs.fluffy_crm.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.mbt_bs.fluffy_crm.data.json.Customer;
import ru.mbt_bs.fluffy_crm.data.json.CustomerLink;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final JdbcTemplate jdbcTemplate;
    private GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object> getCustomer(Integer id) {
        return jdbcTemplate.queryForMap("SELECT * FROM customer WHERE id=" + id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customer.getId() == null) {
            String query = "INSERT INTO customer (name,date,phone,email,comment) VALUES (?,?,?,?,?)";
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(query, new String[]{"id"});
                ps.setString(1, customer.getName());
                ps.setDate(2, customer.getBirthDate() == null ? null
                        : new Date(customer.getBirthDate().getTime()));
                ps.setString(3, customer.getPhone());
                ps.setString(4, customer.getEmail());
                ps.setString(5, customer.getComment());
                return ps;
            }, keyHolder);
            customer.setId((Integer) keyHolder.getKey());
        } else {
            jdbcTemplate.update("UPDATE customer SET name=?,date=?,phone=?,email=?,comment=? WHERE id=?",
                    customer.getName(), customer.getBirthDate(), customer.getPhone(), customer.getEmail(),
                    customer.getComment(), customer.getId());
        }
    }

    @Override
    public List<Map<String, Object>> getCustomerLinks(String name) {
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

        return jdbcTemplate.queryForList(query.toString());
    }
}