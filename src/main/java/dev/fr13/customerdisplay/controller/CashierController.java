package dev.fr13.customerdisplay.controller;

import dev.fr13.customerdisplay.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("cashiers")
public class CashierController {
    @Autowired
    CashierService cashierService;

    @GetMapping({""})
    public String getIndex(Model model) {
        var cashiers = cashierService.findAll().orElse(Collections.emptyList());
        model.addAttribute("cashiers", cashiers);
        return "cashiers";
    }

    @GetMapping({"/{uuid}"})
    public String getCashier(@PathVariable String uuid, Model model) {
        model.addAttribute("uuid", uuid);
        return "cashier";
    }
}
