package com.allegro.maven;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class UserInterface
{
    private static Scanner scanner = new Scanner(System.in);
    public static int ID;
    public static String Username;

    private static String menu = "1) Wyszukaj przedmiot\n2) Wystaw na Sprzedaż\n3) Kup\n4) Przedlądaj moja zamowienia i ofetry \n5) Wyloguj sie";
    private static void RunClient()
    {
        System.out.println("Witaj "+ Username +"! co chciałbyś dzisiaj zrobić?");
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
                    while(flag2)
                    {
                        System.out.println("Filtry wyszukiwania:\n1)Kategoria\n2)Cena minimalna\n3)Cena maksymalna\n4)Stan przedmiotu\n5)Szukaj\n6)Powrót do menu głównego\n");
                        int filter = scanner.nextInt();
                        switch(filter)
                        {
                            case 1:
                            {
                                System.out.println("Wybierz kategorie przedmiotu\n1)Elektronika\n2)Moda\n3)Dom i Ogród\n4)Motoryzacja\n5)Dla Dzieci\n6)Sport i Turystyka\n7)Zdrowie i Uroda\n8)Kultura i Rozrywka\n9)Inne\n");
                                int kategoria = scanner.nextInt();
                                switch(kategoria)
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
                                    default:
                                    {
                                        System.out.println("Wybierz jedną z podanych opcji\n");
                                    }

                                }
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
                                flag2 = false;
                                break;
                            }
                            default:
                            {
                                System.out.println("Wybierz jedną z podanych opcji\n");
                            }
                        }
                    }
                }
                case 2:
                {
                    scanner.nextLine();
                    int stan = 0, cena, ilosc, kategoria;
                    String Nazwa;
                    System.out.println("Podaj nazwe sprzedawanego przedmiotu\n");
                    Nazwa = scanner.nextLine();
                    System.out.println("Ile sztuk sprzedajesz?\n");
                    ilosc = scanner.nextInt();
                    System.out.println("Podaj cene (w zł)\n");
                    cena = scanner.nextInt();
                    System.out.println(" Stan przedmiotu\n1)Nowe\n2)Używane\n");
                    while(stan > 0)
                    {
                        stan = scanner.nextInt();
                        if(stan == 1 || stan == 2)
                        {
                            
                        }
                        else
                        {
                            stan = 0;
                            System.out.println("Wybierz jedną z 2 podanychopcji\n");
                        }
                    }
                    System.out.println("Wybierz kategorie przedmiotu\n1)Elektronika\n2)Moda\n3)Dom i Ogród\n4)Motoryzacja\n5)Dla Dzieci\n6)Sport i Turystyka\n7)Zdrowie i Uroda\n8)Kultura i Rozrywka\n9)Inne\n");
                    kategoria = scanner.nextInt();
                    switch(kategoria)
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
                    System.out.println(" Wylogowywanie, żegnaj " + Username+"\n\n");
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
