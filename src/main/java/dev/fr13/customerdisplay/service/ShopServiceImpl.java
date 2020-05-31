package dev.fr13.customerdisplay.service;

import dev.fr13.customerdisplay.domain.Shop;
import dev.fr13.customerdisplay.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository repository;

    public ShopServiceImpl(ShopRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shop save(Shop shop) {
        return repository.save(shop);
    }

    @Override
    public Optional<Shop> findById(long id) {
        return repository.findById(id);
    }
}
