package com.org.java_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogFileFilterUtil {

    public static void main(String[] args) {
        //scans the input file path
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the log file: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                //condition that checks the errors and exceptions in the log file
                if (line.contains("[Error]") || line.matches(".*\\b\\w*Error\\b.*") || line.matches(".*\\b\\w*Exception\\b.*")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
