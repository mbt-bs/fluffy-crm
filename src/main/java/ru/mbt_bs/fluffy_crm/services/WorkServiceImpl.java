package ru.mbt_bs.fluffy_crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mbt_bs.fluffy_crm.converters.WorkConverter;
import ru.mbt_bs.fluffy_crm.data.json.Work;
import ru.mbt_bs.fluffy_crm.data.repository.WorkRepository;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    private WorkRepository workRepository;
    private ServiceService serviceService;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository, ServiceService serviceService) {
        this.workRepository = workRepository;
        this.serviceService = serviceService;
    }

    @Override
    public List<Work> getWorkAndServiceList(Long id) {
        List<Work> result = WorkConverter.convertWorkList(workRepository.getWorkListByCustomerId(id));
        serviceService.fillServiceInWorkList(result);
        return result;
    }
}
