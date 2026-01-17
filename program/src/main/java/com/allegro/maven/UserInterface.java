package com.allegro.maven;
import java.util.Scanner;

public class UserInterface
{
    private static Scanner scanner = new Scanner(System.in);
    public static int ID;
    public static String username;

    private static String menu = "1) Wyszukaj przedmiot\n2) Wystaw na sprzedaż\n3) Kup\n4) Przeglądaj moje zamowienia i oferty \n5) Wyloguj się";
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
                    while(flag2)
                    {
                        System.out.println("Filtry wyszukiwania:\n1)Kategoria\n2)Cena minimalna\n3)Cena maksymalna\n4)Stan przedmiotu\n5)Szukaj\n6)Powrót do menu głównego");
                        int filter = scanner.nextInt();
                        switch(filter)
                        {
                            case 1:
                            {
                                System.out.println("Wybierz kategorię przedmiotu\n1)Elektronika\n2)Dom i Ogród\n3)Motoryzacja\n4)Sport i Turystyka\n5)Zdrowie i Uroda\n6)Kultura i Rozrywka\n7)Inne");
                                int category = scanner.nextInt();
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
                                    default:
                                    {
                                        System.out.println("Wybierz jedną z podanych opcji");
                                    }

                                }
                            }
                            case 2:
                            {
                                System.out.println("Podaj minimalną cenę szukanego produktu");
                                int minPrice = scanner.nextInt();
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Podaj maksymalną cenę szukanego produktu");
                                int maxPrice = scanner.nextInt();
                                break;
                            }
                            case 4:
                            {
                                System.out.println("Podaj stan szukanego przedmiotu:\n1)Nowy\n2)Używany\n3)Uszkodzony");
                                int state = scanner.nextInt();
                                switch(state)
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
                                    default:
                                    {
                                        System.out.println("Wybierz jedną z podanych opcji");
                                    }
                                }
                                break;
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
                        if(state == 1 || state == 2)
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
