package com.pluralsight;

public class Vehicle {

    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private String type;  // e.g., car, truck, SUV, van
    private double price;

    // Constructor to initialize the vehicle
    public Vehicle(int id, String make, String model, int year, String color, int mileage, String type, double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.type = type;
        this.price = price;
    }

    // Getter methods for the fields

    public int getId() { return id;
    }

    public String getMake() { return make;
    }

    public String getModel() { return model;
    }

    public int getYear() { return year;
    }

    public String getColor() { return color;
    }

    public int getMileage() { return mileage;
    }

    public String getType() { return type;
    }

    public double getPrice() { return price;
    }

    // Optionally, you can override toString() for better display of vehicle details
    @Override
    public String toString() {
        return "ID: " + id +
                ", Year: " + year +
                ", Make: " + make +
                ", Model: " + model +
                ", Type: " + type +
                ", Color: " + color +
                ", Mileage: " + mileage +
                ", Price: $" + price;
    }
}
