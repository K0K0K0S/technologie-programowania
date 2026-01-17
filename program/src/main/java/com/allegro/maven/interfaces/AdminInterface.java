package com.allegro.maven.interfaces;
//import java.lang.foreign.SymbolLookup;
import java.util.Scanner;
import com.allegro.maven.dao.UserDao;
import com.allegro.maven.dao.CurierDao;
//import java.sql.DriverManager;
//import java.sql.Connection;

public class AdminInterface 
{
    private static Scanner scanner = new Scanner(System.in);

    private static final UserDao userDao = new UserDao();
    private static final CurierDao curierDao = new CurierDao();

    private static String menu = "1) Przeglądaj użytkowników\n2) Zbanuj użytkownika\n 3) Przeglądaj kurierów\n4) Dodaj kuriera\n5) Zwolnij kuriera\n6) Wyloguj się";

    private static void RunAdmin()
    {
        System.out.println("Witaj w Panelu Administratora! Co chciałbyś dzisiaj zrobić?");
        boolean flag = true;
        while(flag)
        {
            System.out.println(menu);
            // Implementacja funkcji administracyjnych tutaj
            int in = scanner.nextInt();
            switch (in)
            {
                case 1 -> showUsers();
                case 2 -> banUser();
                case 3 -> addCurier();
                case 4 -> showCuriers();
                case 5 -> fireCurier();
                case 6-> flag = false;
                default -> System.out.println("Nieprawidłowy wybór");
            }
            /*switch(in)
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
            }*/
        }
    }
    
    private static void showUsers()
    {
        userDao.getAllUsers().forEach(System.out::println);
    }

    private static void banUser()
    {
        System.out.println("ID użytkownika do zbanowania: ");
        int id = scanner.nextInt();
        userDao.banUser(id);
    }

    private static void showCuriers()
    {
        curierDao.getAllCuriers.forEach(System.out::println);
    }

    private static void addCurier() 
    {
        System.out.println("Login kuriera: ");
        scanner.nextLine();
        String login = scanner.nextLine();

        System.out.println("Hasło: ");
        String password = scanner.nextLine();

        curierDao.addCurier(login, password);
    }

    private static void fireCurier()
    {
        System.out.println("ID kuriera do zwolnienia: ");
        int id = scanner.nextInt();
        curierDao.fireCurier(id);
    }
}
