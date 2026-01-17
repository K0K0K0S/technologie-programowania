package com.allegro.maven;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
public class CourierInterface 
{
    private static Scanner scanner = new Scanner(System.in);
    public static String Location;
    public static int CourierID;
    public static String CourierName;
    private static String menu = "1) Zaaktualizuj swja lokalizacje\n2) Przegladaj przypisane dostawy\n3) Pokaz paczki w okolicy\n4) Dostarcz paczke\n5) Wyloguj sie";    
    private static void RunCourier()
    {
        System.out.println("Witaj "+ CourierName +"! co chciałbyś dzisiaj zrobić?");
        boolean flag = true;
        while(flag)
        {
            System.out.println(menu);
            int in = scanner.nextInt();
            switch(in)
            {
                case 1:
                {
                    System.out.println("Podaj swoją aktualną lokalizację (miasto):");
                    Location = scanner.next();
                    System.out.println("Lokalizacja zaktualizowana na: " + Location + "Utrzymuj dobrą pracę!");
                }
                case 2:
                {
                    //Przegladanie przypisanych dostaw
                }
                case 3:
                {
                    //Pokaz paczki w okolicy
                }
                case 4:
                {
                    System.out.println("Podaj ID paczki do dostarczenia:");
                    int packageID = scanner.nextInt();
                }
                case 5:
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
