package dev.fr13.customerdisplay.controller;

import dev.fr13.customerdisplay.domain.Cashier;
import dev.fr13.customerdisplay.domain.Message;
import dev.fr13.customerdisplay.service.CashierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/cashiers")
public class CashierRestController {
    private static final Logger logger = LoggerFactory.getLogger(CashierRestController.class);

    @Autowired
    private CashierService cashierService;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cashier> registerCashier(@RequestBody Message message) {
        logger.info("retrieved message: {}", message);
        cashierService.add(message.getCashier());
        messagingTemplate.convertAndSend("/topic/message", message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cashier> deleteCashier(@RequestBody Message message) {
        logger.info("retrieved message: {}", message);
        cashierService.delete(message.getCashier().getUuid());
        messagingTemplate.convertAndSend("/topic/message", message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
