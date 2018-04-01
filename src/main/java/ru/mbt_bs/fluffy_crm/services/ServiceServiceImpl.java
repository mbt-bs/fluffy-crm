package ru.mbt_bs.fluffy_crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mbt_bs.fluffy_crm.converters.ServiceConverter;
import ru.mbt_bs.fluffy_crm.data.json.Work;
import ru.mbt_bs.fluffy_crm.data.repository.ServiceRepository;

import java.util.List;
import java.util.Map;

@Service
public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ru.mbt_bs.fluffy_crm.data.json.Service> getServices(String title) {
        List<Map<String, Object>> data = title == null ? serviceRepository.getAllServices()
                : serviceRepository.getServicesByTitle(title);
        return ServiceConverter.convertServiceList(data);
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

    @Override
    public void updateService(ru.mbt_bs.fluffy_crm.data.json.Service service) {
        serviceRepository.updateService(service);
    }
}
