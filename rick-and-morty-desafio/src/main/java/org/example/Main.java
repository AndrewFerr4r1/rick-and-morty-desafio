package org.example;

import org.example.config.ConfigApi;
import org.example.model.Location;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConfigApi config = new ConfigApi();

//        System.out.println("Digite o nome da localização que queira achar: ");
//        config.searchName("Citadel of Ricks");
        Location location = new Location(config.searchName(scanner.nextLine()));
        System.out.println(location);
    }
}