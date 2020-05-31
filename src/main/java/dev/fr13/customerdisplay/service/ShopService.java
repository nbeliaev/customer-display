package dev.fr13.customerdisplay.service;

import dev.fr13.customerdisplay.domain.Shop;

import java.util.Optional;

public interface ShopService {

    Shop save(Shop shop);

    Optional<Shop> findById(long id);
}
