package ru.mbt_bs.fluffy_crm.data.repository;

import java.util.Map;

public interface ServiceRepository {
    Map<String, Object> getTitleById(Long id);
}
