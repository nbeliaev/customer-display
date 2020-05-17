package dev.fr13.customerdisplay.service;

import dev.fr13.customerdisplay.domain.Cashier;
import dev.fr13.customerdisplay.repository.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashierServiceImpl implements CashierService {
    @Autowired
    CashierRepository repository;

    @Override
    public Optional<Cashier> getByUuid(String uuid) {
        return repository.getByUuid(uuid);
    }

    @Override
    public Optional<List<Cashier>> findAll() {
        return repository.findAll();
    }

    @Override
    public void insert(Cashier cashier) {
        repository.insert(cashier);
    }

    @Override
    public void delete(String uuid) {
        repository.delete(uuid);
    }
}
