package dev.fr13.customerdisplay.service;

import dev.fr13.customerdisplay.domain.Cashier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CashierServiceInMemory implements CashierService {
    private final Map<String, Cashier> storage = new ConcurrentHashMap<>();

    @Override
    public Cashier getByUuid(String uuid) {
        return storage.get(uuid);
    }

    @Override
    public void add(Cashier cashier) {
        storage.put(cashier.getUuid(), cashier);
    }

    @Override
    public void delete(String uuid) {
        storage.remove(uuid);
    }
}
