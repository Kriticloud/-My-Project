package com.org.java_project;

import java.util.Scanner;

// Interface
interface GeometricalShape {
    double calculateArea(); // Abstract method
    void display();         // Abstract method
}

// Implementing class: Circle
class Circles implements GeometricalShape {
    private double radius;

    public Circles(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Calculating area of a circle...");
    }
}

// Implementing class: Rectangle
class Rectangles implements GeometricalShape {
    private double length, width;

    public Rectangles(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("Calculating area of a rectangle...");
    }
}

// Main class
public class InterfaceExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose shape (circles/rectangles): ");
        String shapeType = scanner.nextLine().toLowerCase();

        Shape shape;

        if (shapeType.equals("circles")) {
            System.out.print("Enter radius: ");
            double radius = scanner.nextDouble();
            shape = new Circle(radius);
        } else if (shapeType.equals("rectangles")) {
            System.out.print("Enter length: ");
            double length = scanner.nextDouble();
            System.out.print("Enter width: ");
            double width = scanner.nextDouble();
            shape = new Rectangle(length, width);
        } else {
            System.out.println("Invalid shape type.");
            return;
        }

        shape.display(); // Call method from interface
        System.out.println("Area: " + shape.calculateArea()); // Call method from interface
    }
}
