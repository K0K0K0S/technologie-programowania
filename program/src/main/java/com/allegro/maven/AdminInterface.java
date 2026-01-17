package com.allegro.maven;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class AdminInterface 
{
    private static Scanner scanner = new Scanner(System.in);
    private static String menu = "1) Przeglądaj użytkowników\n2) Przeglądaj kurierów\n3) Dodaj kuriera\n4) Zbanuj użytkownika\n5) Zwolnij kuriera\n6) Wyloguj się";
    private static void RunAdmin()
    {
        System.out.println("Witaj w Panelu Administratora! co chciałbyś dzisiaj zrobić?");
        boolean flag = true;
        while(flag)
        {
            System.out.println(menu);
            // Implementacja funkcji administracyjnych tutaj
            int in = scanner.nextInt();
            switch(in)
            {
                case 1:
                {
                    //Przeglądaj użytkowników
                }
                case 2:
                {
                    //Przeglądaj kurierów
                }
                case 3:
                {
                    //Dodaj kuriera
                }
                case 4:
                {
                    //Zbanuj użytkownika
                }
                case 5:
                {
                    //Zwolnij kuriera
                }
                case 6:
                {
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
                }
            }
        }
    }    
}
