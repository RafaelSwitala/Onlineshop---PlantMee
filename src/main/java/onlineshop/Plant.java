package onlineshop;

public class Plant {
    private int id;
    private String category;
    private boolean seed;
    private String name;
    private double price;
    private String url;

    // Konstruktor, Getter und Setter

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", seed=" + seed +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSeed(boolean seed) {
        this.seed = seed;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
