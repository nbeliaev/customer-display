package dev.fr13.customerdisplay.controller;

import dev.fr13.customerdisplay.domain.Message;
import dev.fr13.customerdisplay.service.CashierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessagesRestController {
    private static final Logger logger = LoggerFactory.getLogger(MessagesRestController.class);

    @Autowired
    CashierService cashierService;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> postProduct(@RequestBody Message message) {
        logger.info("retrieved message: {}", message);
        if (message == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var opCashier = cashierService.getByUuid(message.getCashier().getUuid());
        if (opCashier.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        messagingTemplate.convertAndSend("/topic/message." + opCashier.get().getUuid(), message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
