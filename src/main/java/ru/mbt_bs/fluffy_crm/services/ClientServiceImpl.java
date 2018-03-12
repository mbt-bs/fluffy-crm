package ru.mbt_bs.fluffy_crm.services;

import org.springframework.stereotype.Service;
import ru.mbt_bs.fluffy_crm.data.json.Client;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public Client getClient() {
        return new Client();
    }
}
