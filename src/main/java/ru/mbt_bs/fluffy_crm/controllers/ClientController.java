package ru.mbt_bs.fluffy_crm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mbt_bs.fluffy_crm.data.json.Client;
import ru.mbt_bs.fluffy_crm.services.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/client")
    public Client getClient() {
        return clientService.getClient();
    }
}
