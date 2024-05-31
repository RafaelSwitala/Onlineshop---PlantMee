package onlineshop.controllers;

import org.springframework.stereotype.Service;
import java.util.List;
import onlineshop.Plant;
import onlineshop.CSVReader;

@Service
public class CSVController {
    public List<Plant> getPlants() {
        String filePath = "../../../resources/static/data/plants.csv";
        List<Plant> plants = CSVReader.readPlantsFromCSV(filePath);
        return plants;
    }
}
