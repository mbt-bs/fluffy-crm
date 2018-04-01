package ru.mbt_bs.fluffy_crm.services;

import ru.mbt_bs.fluffy_crm.data.json.Service;
import ru.mbt_bs.fluffy_crm.data.json.Work;

import java.util.List;

public interface ServiceService {

    List<Service> getServices();

    void fillServiceInWorkList(List<Work> result);

    void updateService(Service service);
}
