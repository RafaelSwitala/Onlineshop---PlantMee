package onlineshop;

public class HTMLBuilder {
    public static String buildCardItem(Plant plant) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"card-item\">")
          .append("<div class=\"card-item__name\">").append(plant.getName()).append("</div>")
          .append("<div class=\"card-item__image\"><img src=\"").append(plant.getUrl()).append("\" alt=\"").append(plant.getName()).append("\"></div>")
          .append("<div class=\"card-item__price\">").append(plant.getPrice()).append("€</div>")
          .append("<button class=\"card-item__warenkorb-button\">Zum Warenkorb hinzufügen</button>")
          .append("</div>");
        System.out.println(sb);
        
        return sb.toString();
    }
}
