package model;

public class Product {
    private final int id;
    private final String name;
    private final String manufacturer;
    private final double price;
    private double rating;

    public Product(int id, String name, String manufacturer, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.rating = 0.0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getManufacturer() { return manufacturer; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return id + ". " + name + " | " + manufacturer + " | $" + price + " | Рейтинг: " + rating;
    }
}