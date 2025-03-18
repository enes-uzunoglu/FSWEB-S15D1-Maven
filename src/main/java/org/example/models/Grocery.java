package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }

    public static void startGrocery(){
        System.out.println("Grocery List Programı");
        System.out.println("0 - Çık");
        System.out.println("1 - Ürün ekle");
        System.out.println("2 - Ürün çıkar");
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz giriş! Lütfen 0, 1 veya 2 giriniz.");
            startGrocery();
            return;
        }
        
        switch (choice) {
            case 0:
                scanner.close();
                break;
            case 1:
                System.out.println("Eklenmesini istediğiniz elemanı giriniz.");
                String itemToAdd = scanner.nextLine();
                addItems(itemToAdd);
                break;
            case 2:
                System.out.println("Çıkarılmasını istediğiniz elemanı giriniz.");
                String itemToRemove = scanner.nextLine();
                removeItems(itemToRemove);
                break;
            default:
                System.out.println("Geçersiz giriş!");
                break;
        }
        startGrocery();
    }

    public static boolean checkItemIsInList(String product){

        return groceryList.contains(product);
    }

    public static void addItems(String input){
        String[] items = input.split(","); // Virgülden ayır
        for (String item : items) {
            item = item.trim(); // Gereksiz boşlukları temizle
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        printSorted();
    }
    public static void removeItems(String input){
        String[] items =input.split(",");
        for (String item:items){
            item=item.trim();
            if (checkItemIsInList(item)){
                groceryList.remove(item);
            }
        }
        printSorted();
    }



    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
