package onlineshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/warenkorb")
    public String warenkorb() {
        return "warenkorb";
    }

    @GetMapping("/impressum")
    public String impressum() {
        return "impressum";
    }
}
