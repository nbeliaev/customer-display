package dev.fr13.customerdisplay.service;

import dev.fr13.customerdisplay.domain.Cashier;

public interface CashierService {

    Cashier getByUuid(String uuid);

    void add(Cashier cashier);

    void delete(String uuid);
}
