package onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Plant> readPlantsFromCSV(String filePath) {
        List<Plant> plants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Plant plant = new Plant();
                plant.setId(Integer.parseInt(data[0]));
                plant.setCategory(data[1]);
                plant.setSeed(Boolean.parseBoolean(data[2]));
                plant.setName(data[3]);
                plant.setPrice(Double.parseDouble(data[4]));
                plant.setUrl(data[5]);
                plants.add(plant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plants;
    }
    
}
