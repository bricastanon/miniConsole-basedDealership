package com.pluralsight;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    // Constructor
    public UserInterface() {
        init();
    }

    // Initialize dealership data from file
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager("src/inventory.csv");
        dealership = fileManager.getDealership();
    }

    // Display menu
    public void display() {
        //Scanner scanner = new Scanner(System.in)
        System.out.println("Welcome to the Car Dealership App!");
        System.out.println("********************************************");
        System.out.println("Please select an option from the menu below:");
        int choice;
        do {
            System.out.println("1. Find vehicles by price range");
            System.out.println("2. Find vehicles by make / model");
            System.out.println("3. Find vehicles by year range");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage range");
            System.out.println("6. Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7. List ALL vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Quit");
            System.out.println("********************************************");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processFindVehiclesByPriceRange();
                    break;
                case 2:
                    processFindVehiclesByMakeModel();
                    break;
                case 3:
                    processFindVehiclesByYearRange();
                    break;
                case 4:
                    processFindVehiclesByColor();
                    break;
                case 5:
                    processFindVehiclesByMileageRange();
                    break;
                case 6:
                    processFindVehiclesByType();
                    break;
                case 7:
                    processGetAllVehicles();
                    break;
                case 8:
                    processAddVehicle();
                    break;
                case 9:
                    processRemoveVehicle();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);
    }

    // Display a list of vehicles
    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                    "ID", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price");
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%-10s %-10d %-10s %-10s %-10s %-10s %-10d %-10.2f\n",
                        vehicle.getId(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getType(), vehicle.getColor(), vehicle.getMileage(), vehicle.getPrice());
            }
        }
    }

    public void processFindVehiclesByPriceRange() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPriceRange(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByYearRange() {
        System.out.print("Enter start year: ");
        int startYear = scanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYearRange(startYear, endYear);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByColor() {
        System.out.print("Enter color: ");
        String color = scanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByMileageRange() {
        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileageRange(minMileage, maxMileage);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByType() {
        System.out.print("Enter type (car, truck, SUV, van): ");
        String type = scanner.next();
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicle() {
        System.out.print("Enter vehicle ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter vehicle make: ");
        String make = scanner.next();
        System.out.print("Enter vehicle model: ");
        String model = scanner.next();
        System.out.print("Enter vehicle year: ");
        int year = scanner.nextInt();
        System.out.print("Enter vehicle color: ");
        String color = scanner.next();
        System.out.print("Enter vehicle mileage: ");
        int mileage = scanner.nextInt();
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.next();
        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(id, make, model, year, color, mileage, type, price);

        dealership.addVehicle(newVehicle);

        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicle() {
        System.out.print("Enter vehicle ID to remove: ");
        int vehicleId = scanner.nextInt();
        dealership.removeVehicle(vehicleId);
    }

}

