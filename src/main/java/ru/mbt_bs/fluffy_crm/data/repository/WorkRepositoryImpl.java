package ru.mbt_bs.fluffy_crm.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.mbt_bs.fluffy_crm.data.json.Work;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@Repository
public class WorkRepositoryImpl implements WorkRepository {
    private final JdbcTemplate jdbcTemplate;
    private GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

    @Autowired
    public WorkRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getWorkListByCustomerId(Long id) {
        return jdbcTemplate.queryForList("SELECT * FROM works WHERE customer_id=? ORDER BY date DESC", id);
    }

    @Override
    public void updateWork(Work work) {
        if (work.getId() == null) {
            String query = "INSERT INTO works (customer_id,service_id,date) VALUES (?,?,?)";
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(query, new String[]{"id"});
                ps.setLong(1, work.getCustomer().getId());
                ps.setLong(2, work.getService().getId());
                ps.setDate(2, work.getDate() == null ? null
                        : new Date(work.getDate().getTime()));
                return ps;
            }, keyHolder);
            work.setId((Long) keyHolder.getKey());
        } else {
            jdbcTemplate.update("UPDATE works SET customer_id=?,service_id=?,date=? WHERE id=?",
                    work.getCustomer().getId(), work.getService().getId(), work.getDate().getTime(), work.getId());
        }
    }
}
