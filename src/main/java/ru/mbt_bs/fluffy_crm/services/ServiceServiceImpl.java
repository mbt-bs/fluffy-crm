package ru.mbt_bs.fluffy_crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mbt_bs.fluffy_crm.converters.ServiceConverter;
import ru.mbt_bs.fluffy_crm.data.json.Work;
import ru.mbt_bs.fluffy_crm.data.repository.ServiceRepository;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void fillServiceInWorkList(List<Work> workList) {
        for (Work work : workList) {
            work.getService().setTitle(
                    ServiceConverter.convertTitle(
                            serviceRepository.getTitleById(work.getService().getId())
                    )
            );
        }
    }
}
