package ru.mbt_bs.fluffy_crm.services;

import ru.mbt_bs.fluffy_crm.data.json.Work;

import java.util.List;

public interface WorkService {
    List<Work> getWorkAndServiceList(Long id);

    void updateWork(Work work);
}
