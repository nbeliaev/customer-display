package dev.fr13.customerdisplay.service;

import dev.fr13.customerdisplay.domain.Ad;
import dev.fr13.customerdisplay.repository.AdRepository;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {
    private final AdRepository repository;

    public AdServiceImpl(AdRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ad save(Ad ad) {
        return repository.save(ad);
    }
}
