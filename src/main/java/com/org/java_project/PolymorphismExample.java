package com.org.java_project;

import java.util.Scanner;

// Superclass
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass 1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Subclass 2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

// Main class
public class PolymorphismExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter animal type (dog/cat): ");
        String type = scanner.nextLine().toLowerCase();

        Animal animal; // Polymorphic reference

        // Create object based on input
        if (type.equals("dog")) {
            animal = new Dog();
        } else if (type.equals("cat")) {
            animal = new Cat();
        } else {
            animal = new Animal();
        }

        // Call the method - actual method depends on object type
        animal.makeSound();
    }
}

