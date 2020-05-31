package dev.fr13.customerdisplay.controller;

import dev.fr13.customerdisplay.domain.Ad;
import dev.fr13.customerdisplay.service.AdService;
import dev.fr13.customerdisplay.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ads")
public class AdController {
    private static final Logger logger = LoggerFactory.getLogger(AdController.class);

    @Autowired
    AdService adService;
    @Autowired
    ShopService shopService;

    @PostMapping
    public ResponseEntity<Ad> postAd(@RequestBody Ad ad) {
        logger.debug("received new ad {}", ad);
        // TODO use custom exception
        var shop = shopService.findById(ad.getShopId()).orElseThrow(() -> new RuntimeException("no such shop"));
        ad.setShop(shop);
        var savedAd = adService.save(ad);
        logger.debug("saved ad {}", savedAd);
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedAd);
    }
}
