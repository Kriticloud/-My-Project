package com.org.java_project;

import java.util.Scanner;

// Superclass
class Vehicle {
    protected String brand;

    // Constructor
    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Method to display brand
    public void displayBrand() {
        System.out.println("Brand: " + brand);
    }

}

// Subclass
class Car extends Vehicle {
    private final String model;

    // Constructor
    public Car(String brand, String model) {
        super(brand); // Call Vehicle constructor
        this.model = model;
    }

    // Method to display model
    public void displayModel() {
        System.out.println("Model: " + model);
    }

    // Overriding the start method
    public void start() {
        System.out.println("Car is starting with keyless ignition...");
    }
}

// Main class
class InheritanceInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        // Create Car object using input
        Car myCar = new Car(brand, model);

        // Output using inherited and overridden methods
        myCar.displayBrand();   // From Vehicle
        myCar.displayModel();   // From Car
        myCar.start();          // Overridden in Car
    }
}
