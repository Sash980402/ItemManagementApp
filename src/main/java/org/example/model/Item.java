package org.example.model;

public class Item {
    private final int id;
    private final String name;
    private final int quantity;
    private final double price;
    private final String description;

    public Item(int id, String name, int quantity, double price, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
}