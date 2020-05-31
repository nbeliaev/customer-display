package dev.fr13.customerdisplay.repository;

import dev.fr13.customerdisplay.domain.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
