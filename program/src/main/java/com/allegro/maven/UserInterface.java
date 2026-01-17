package com.allegro.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInterface
{
    private static Scanner scanner = new Scanner(System.in);
    public static int ID;
    public static String username;

    private static String menu = "1) Wyszukaj przedmiot\n2) Wystaw na sprzedaż\n3) Kup\n4) Przeglądaj moje zamowienia i oferty \n5) Wyloguj się";
    private static String[] categories = {"Elektronika", "Dom i Ogród", "Motoryzacja", "Sport i Turystyka", "Zdrowie i Uroda", "Kultura i Rozrywka", "Książki", "Inne"};
    private static String[] filters = {"Kategoria", "Cena minimalna", "Cena maksymalna", "Stan przedmiotu", "Podgląd", "Szukaj", "Powrót do menu głównego"};
    private static String[] states = {"Nowy", "Używany", "Uszkodzony"};

    private static void RunClient()
    {
        System.out.println("Witaj "+ username +"! Co chciałbyś dzisiaj zrobić?");
        boolean flag = true;
        while(flag)
        {
            System.out.println(menu);
            int in = scanner.nextInt();
            switch(in)
            {
                case 1:
                {
                    boolean flag2 = true;
                    int filter = 0, category = 8, minPrice = 0, maxPrice = 1000000, state = 1;
                    while(flag2)
                    {
                        System.out.println("Filtry wyszukiwania");
                        for (int i = 1; i <= filters.length; i++) 
                        {
                            System.out.println(i + ") " + filters[i-1]);
                        }
                        filter = scanner.nextInt();
                        switch(filter)
                        {
                            case 1:
                            {
                                System.out.println("Wybierz kategorię przedmiotu");
                                for (int i = 1; i <= categories.length; i++)
                                {
                                    System.out.println(i + ") " + categories[i-1]);
                                }
                                category = scanner.nextInt();
                                continue;
                            }
                            case 2:
                            {
                                System.out.println("Podaj minimalną cenę szukanego produktu");
                                minPrice = scanner.nextInt();
                                continue;
                            }
                            case 3:
                            {
                                System.out.println("Podaj maksymalną cenę szukanego produktu");
                                maxPrice = scanner.nextInt();
                                continue;
                            }
                            case 4:
                            {
                                System.out.println("Podaj stan szukanego przedmiotu:");
                                for (int i = 1; i <= states.length; i++)
                                {
                                    System.out.println(i + ") " + states[i-1]);
                                }
                                state = scanner.nextInt();
                                continue;
                            }
                            case 5:
                            {
                                System.out.println("Kategoria: " + categories[category-1] + "\nCena minimalna: " + minPrice + "\nCena maksymalna: " + maxPrice + "\nStan: " + states[state-1]);
                            }
                            case 6:
                            {
                                try (Connection conn = DriverManager.getConnection("jdbc:mysql://root:oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK@hopper.proxy.rlwy.net:29959/railway","root","oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK");
                                    Statement stmt = conn.createStatement();)
                                {
                                    String searchQuery = "SELECT * FROM Items i WHERE Type = " + categories[category-1] + "AND Price > " + minPrice + "AND Price < " + maxPrice + "AND Status = " + states[state-1];
                                    var rs = stmt.executeQuery(searchQuery);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                
                            }
                            case 7:
                            {
                                flag2 = false;
                                break;
                            }
                            default:
                            {
                                System.out.println("Wybierz jedną z podanych opcji\n");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2:
                {
                    scanner.nextLine();
                    int state = 0, number, price, category;
                    String name;
                    System.out.println("Podaj nazwę sprzedawanego przedmiotu\n");
                    name = scanner.nextLine();
                    System.out.println("Ile sztuk sprzedajesz?\n");
                    number = scanner.nextInt();
                    System.out.println("Podaj cenę (w zł)\n");
                    price = scanner.nextInt();
                    System.out.println("Stan przedmiotu\n1)Nowy\n2)Używany\n3)Uszkodzony\n");
                    while(state > 0)
                    {
                        state = scanner.nextInt();
                        if(state == 1 || state == 2 || state == 3)
                        {
                            
                        }
                        else
                        {
                            state = 0;
                            System.out.println("Wybierz jedną z 2 podanych opcji\n");
                        }
                    }
                    System.out.println("Wybierz kategorię przedmiotu\n1)Elektronika\n2)Moda\n3)Dom i Ogród\n4)Motoryzacja\n5)Dla Dzieci\n6)Sport i Turystyka\n7)Zdrowie i Uroda\n8)Kultura i Rozrywka\n9)Książki\n10)Inne\n");
                    category = scanner.nextInt();
                    switch(category)
                    {
                        case 1:
                        {

                        }
                        case 2:
                        {

                        }
                        case 3:
                        {

                        }
                        case 4:
                        {

                        }
                        case 5:
                        {

                        }
                        case 6:
                        {

                        }
                        case 7:
                        {

                        }
                        case 8:
                        {

                        }
                        case 9:
                        {

                        }
                        case 10:
                        {

                        }
                        default:
                        {
                            System.out.println("Wybierz jedną z podanych opcji\n");
                        }
                    }
                    System.out.println("Przedmiot wystawiony na sprzedaż!\n");

                }
                case 3:
                {
                    

                }
                case 4:
                {
                    
                }
                case 5:
                {
                    System.out.println(" Wylogowywanie, żegnaj " + username+"\n\n");
                    flag=false;

                }
            }
        }
    }
    public static void main(String[] args)
    {
        RunClient();
    }
}
