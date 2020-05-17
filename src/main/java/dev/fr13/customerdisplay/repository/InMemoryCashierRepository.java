package dev.fr13.customerdisplay.repository;

import dev.fr13.customerdisplay.domain.Cashier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCashierRepository implements CashierRepository {
    private final Map<String, Cashier> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<Cashier> getByUuid(String uuid) {
        return Optional.of(storage.get(uuid));
    }

    @Override
    public Optional<List<Cashier>> findAll() {
        return Optional.of(new ArrayList<>(storage.values()));
    }

    @Override
    public void insert(Cashier cashier) {
        storage.put(cashier.getUuid(), cashier);
    }

    @Override
    public void delete(String uuid) {
        storage.remove(uuid);
    }
}
