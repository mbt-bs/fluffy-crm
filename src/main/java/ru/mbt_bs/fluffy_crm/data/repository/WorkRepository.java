package ru.mbt_bs.fluffy_crm.data.repository;

import java.util.List;
import java.util.Map;

public interface WorkRepository {
    List<Map<String, Object>> getWorkListByCustomerId(Long id);
}
