package dev.fr13.customerdisplay.service;

import dev.fr13.customerdisplay.domain.Cashier;

import java.util.List;
import java.util.Optional;

public interface CashierService {

    Optional<Cashier> getByUuid(String uuid);

    Optional<List<Cashier>> findAll();

    void insert(Cashier cashier);

    void delete(String uuid);
}
