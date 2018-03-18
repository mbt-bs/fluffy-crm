package ru.mbt_bs.fluffy_crm.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WorkRepositoryImpl implements WorkRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getWorkListByCustomerId(Long id) {
        return jdbcTemplate.queryForList("SELECT * FROM works WHERE customer_id=? ORDER BY date DESC", id);
    }
}
