package com.org.java_project;

import java.util.Scanner;

// Abstract class
abstract class Shape {
    // Abstract method (no body)
    public abstract double calculateArea();

    // Concrete method
    public void display() {
        System.out.println("Calculating area of the shape...");
    }
}

// Subclass 1: Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement abstract method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass 2: Rectangle
class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implement abstract method
    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Main class
public class AbstractionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose shape (circle/rectangle): ");
        String shapeType = scanner.nextLine().toLowerCase();

        Shape shape;

        if (shapeType.equals("circle")) {
            System.out.print("Enter radius: ");
            double radius = scanner.nextDouble();
            shape = new Circle(radius);
        } else if (shapeType.equals("rectangle")) {
            System.out.print("Enter length: ");
            double length = scanner.nextDouble();
            System.out.print("Enter width: ");
            double width = scanner.nextDouble();
            shape = new Rectangle(length, width);
        } else {
            System.out.println("Invalid shape type.");
            return;
        }

        shape.display(); // Call concrete method
        System.out.println("Area: " + shape.calculateArea()); // Call abstract method
    }
}
