package org.example;

import org.example.config.ConfigApi;
import org.example.model.Location;
import org.example.utils.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        ConfigApi config = new ConfigApi();

        String linha = "-----------------------------------------------------------------";

//        System.out.println("Digite o nome da localização que queira achar: ");
        int optionUser = 0;
        System.out.println("Bem vindo! :D");
        do {
            System.out.println(linha);
            System.out.println("Escolha uma opção");
            System.out.println(linha);
            System.out.println("1 - Pesquisar Localidade por nome");
            System.out.println(linha);
            System.out.println("2 - Sair");
            System.out.println(linha);
            System.out.println("Digite: ");
            optionUser = scannerInt.nextInt();

            switch (optionUser) {
                case 1:
                    System.out.println("Digite o nome da localidade: ");
                    String name = scanner.nextLine();
                    Location locationName = new Location(config.searchName(name));
                    if (locationName.getName().equals("indefinido")) {
                        System.out.println("Cidade não encontrada!!");
                    }else {
                        System.out.println("\n"+locationName);
                        try {
                            Thread.sleep(5000);
                            Utils.generateTxt(locationName);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opção válida!!");
            }

        }while (optionUser != 2);
    }
}