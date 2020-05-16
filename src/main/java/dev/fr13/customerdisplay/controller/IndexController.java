package dev.fr13.customerdisplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "cashiers"})
    public String getIndex() {
        return "index";
    }
}
