package com.org.java_project;
// This class demonstrates encapsulation by hiding the account balance

    // This program demonstrates encapsulation using a BankAccount class

import java.util.Scanner;



    class BankAccount {
        // Private variable - cannot be accessed directly from outside
        private double balance;

        // Constructor to initialize balance
        public BankAccount(double initialBalance) {
            if (initialBalance >= 0) {
                this.balance = initialBalance;
            } else {
                this.balance = 0;
            }
        }

        // Public method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Public method to withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Invalid or insufficient funds.");
            }
        }

        // Public getter method to access the balance
        public double getBalance() {
            return balance;
        }
    }

    public class EncapsulationExample {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Create a bank account with an initial balance
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            BankAccount account = new BankAccount(initialBalance);

            // Perform some operations
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);

            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);

            // Show final balance
            System.out.println("Final Balance: $" + account.getBalance());
        }
    }

