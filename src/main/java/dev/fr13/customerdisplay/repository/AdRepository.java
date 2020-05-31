package dev.fr13.customerdisplay.repository;

import dev.fr13.customerdisplay.domain.Ad;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository<Ad, Long> {
}
