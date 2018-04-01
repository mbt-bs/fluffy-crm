package ru.mbt_bs.fluffy_crm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mbt_bs.fluffy_crm.data.json.Service;
import ru.mbt_bs.fluffy_crm.services.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping("/services")
    public List<Service> getServices() {
        return serviceService.getServices();
    }

    @RequestMapping(value = "/service", method = RequestMethod.PUT)
    public ResponseEntity<Service> updateCustomer(@RequestBody Service service) {
        serviceService.updateService(service);
        return service.getId() != null
                ? ResponseEntity.status(HttpStatus.OK).body(service)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
