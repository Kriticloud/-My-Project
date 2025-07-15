package com.org.java_project;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class PhoneSearch {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search phones:");
        String query = scanner.nextLine().toLowerCase();

        File file = new File("C:\\Users\\KRAGNIHO\\Downloads\\phone_brands_and_models.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        String currentBrand = "";
        List<String> results = new ArrayList<>();

        Pattern pricePattern = Pattern.compile("\\$(\\d+)");
        Integer priceLimit = null;
        boolean isUnder = query.contains("under");
        boolean isAbove = query.contains("above");

        if (isUnder || isAbove) {
            Matcher matcher = pricePattern.matcher(query);
            if (matcher.find()) {
                priceLimit = Integer.parseInt(matcher.group(1));
            }
        }

        Set<String> brandSet = new HashSet<>();
        Map<String, List<String>> brandModels = new LinkedHashMap<>();

        // First pass: build brand and models map
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            if (!line.startsWith("  -")) {
                currentBrand = line.replace(":", "").trim();
                brandSet.add(currentBrand.toLowerCase());
                brandModels.put(currentBrand, new ArrayList<>());
            } else {
                brandModels.get(currentBrand).add(line.trim());
            }
        }
        reader.close();

        // Determine brand from query
        String matchedBrand = null;
        for (String brand : brandSet) {
            if (query.contains(brand.toLowerCase())) {
                matchedBrand = brand;
                break;
            }
        }

        // Filter and collect results
        for (Map.Entry<String, List<String>> entry : brandModels.entrySet()) {
            String brand = entry.getKey();
            if (matchedBrand != null && !brand.equalsIgnoreCase(matchedBrand)) continue;

            for (String modelLine : entry.getValue()) {
                Matcher matcher = pricePattern.matcher(modelLine);
                if (matcher.find()) {
                    int price = Integer.parseInt(matcher.group(1));
                    boolean priceMatch = (isUnder && price < priceLimit) || (isAbove && price > priceLimit) || (!isUnder && !isAbove);
                    if (priceMatch) {
                        results.add(brand + ": " + modelLine);
                    }
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println("No matching phones found.");
        } else {
            System.out.println("Matching phones:");
            for (String res : results) {
                System.out.println(res);
            }
        }
    }
}
