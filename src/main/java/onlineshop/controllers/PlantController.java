package onlineshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import onlineshop.Plant;

import java.util.List;

@Controller
public class PlantController {

    private final CSVController csvController;

    public PlantController(CSVController csvController) {
        this.csvController = csvController;
    }

    @GetMapping("/plants")
    public String index(Model model) {
        List<Plant> plants = csvController.getPlants();
        model.addAttribute("plants", plants);
        return "index";
    }
}
