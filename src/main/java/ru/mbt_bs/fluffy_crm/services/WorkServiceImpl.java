package ru.mbt_bs.fluffy_crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.mbt_bs.fluffy_crm.converters.WorkConverter;
import ru.mbt_bs.fluffy_crm.data.json.Work;
import ru.mbt_bs.fluffy_crm.data.repository.WorkRepository;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    private WorkRepository workRepository;
    private CustomerService customerService;
    private ServiceService serviceService;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository,
                           @Lazy CustomerService customerService, @Lazy ServiceService serviceService) {
        this.workRepository = workRepository;
        this.customerService = customerService;
        this.serviceService = serviceService;
    }

    @Override
    public List<Work> getWorkAndServiceList(Long id) {
        List<Work> result = WorkConverter.convertWorkList(workRepository.getWorkListByCustomerId(id));
        customerService.fillCustomerLinksInWorkList(result);
        serviceService.fillServiceInWorkList(result);
        return result;
    }
}
