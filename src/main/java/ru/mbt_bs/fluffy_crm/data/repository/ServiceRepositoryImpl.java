package ru.mbt_bs.fluffy_crm.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.mbt_bs.fluffy_crm.converters.SQLConverter;
import ru.mbt_bs.fluffy_crm.data.json.Service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository {
    private final JdbcTemplate jdbcTemplate;
    private GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

    @Autowired
    public ServiceRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object> getTitleById(Long id) {
        return jdbcTemplate.queryForMap("SELECT title FROM service WHERE id=?", id);
    }

    @Override
    public List<Map<String, Object>> getAllServices() {
        return jdbcTemplate.queryForList("SELECT * FROM service ORDER BY title");
    }

    @Override
    public void updateService(Service service) {
        if (service.getId() == null) {
            String query = "INSERT INTO service (title) VALUES (?)";
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(query, new String[]{"id"});
                ps.setString(1, service.getTitle());
                return ps;
            }, keyHolder);
            service.setId((Long) keyHolder.getKey());
        } else {
            jdbcTemplate.update("UPDATE service SET title=? WHERE id=?", service.getTitle(), service.getId());
        }
    }

    @Override
    public List<Map<String, Object>> getServicesByTitle(String title) {
        return jdbcTemplate.queryForList("SELECT id,title FROM service WHERE UPPER(title) LIKE '"
                + SQLConverter.convertStringToLiker(title) + "' ORDER BY title");
    }
}
