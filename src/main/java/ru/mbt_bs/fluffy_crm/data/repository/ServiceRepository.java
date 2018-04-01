package ru.mbt_bs.fluffy_crm.data.repository;

import ru.mbt_bs.fluffy_crm.data.json.Service;

import java.util.List;
import java.util.Map;

public interface ServiceRepository {
    Map<String, Object> getTitleById(Long id);

    List<Map<String, Object>> getAllServices();

    void updateService(Service service);

    List<Map<String,Object>> getServicesByTitle(String title);
}
