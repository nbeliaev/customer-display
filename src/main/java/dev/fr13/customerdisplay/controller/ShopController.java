package dev.fr13.customerdisplay.controller;

import dev.fr13.customerdisplay.domain.Shop;
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
@RequestMapping("/api/v1/shops")
public class ShopController {
    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    ShopService shopService;

    @PostMapping
    public ResponseEntity<Shop> postShop(@RequestBody Shop shop) {
        logger.debug("received new shop {}", shop);
        var savedShop = shopService.save(shop);
        logger.debug("saved shop {}", savedShop);
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedShop);
    }
}
