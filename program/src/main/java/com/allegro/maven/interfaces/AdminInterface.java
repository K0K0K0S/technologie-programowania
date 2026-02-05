package com.allegro.maven.interfaces;

import java.util.Scanner;

import com.allegro.maven.dao.CourierDao;
import com.allegro.maven.dao.UserDao;

public class AdminInterface 
{
    private static Scanner scanner = new Scanner(System.in);

    private static final UserDao userDao = new UserDao();
    private static final CourierDao courierDao = new CourierDao();

    private static String menu = "1) Przeglądaj użytkowników\n2) Zbanuj użytkownika\n 3) Przeglądaj kurierów\n4) Dodaj kuriera\n5) Zwolnij kuriera\n6) Wyloguj się";

    public static void RunAdmin()
    {
        System.out.println("Witaj w Panelu Administratora! Co chciałbyś dzisiaj zrobić?");
        boolean running = true;
        while(running)
        {
            System.out.println(menu);
            int in = scanner.nextInt();
            switch (in)
            {
                case 1 -> showUsers();
                case 2 -> banUser();
                case 3 -> addCourier();
                case 4 -> showCouriers();
                case 5 -> fireCourier();
                case 6-> running = false;
                default -> System.out.println("Nieprawidłowy wybór");
            }
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

    private static void showCouriers()
    {
        courierDao.getAllCouriers().forEach(System.out::println);
    }

    private static void addCourier() 
    {
        System.out.println("Login kuriera: ");
        String login = scanner.nextLine();

        System.out.println("Hasło: ");
        String password = scanner.nextLine();

        System.out.println("ID firmy kuriera: ");
        int companyId = scanner.nextInt();

        System.out.println("Imię kuriera: ");
        String name = scanner.nextLine();

        System.out.println("Nazwisko kuriera: ");
        String surname = scanner.nextLine();

        System.out.println("Pensja: ");
        double salary = scanner.nextDouble();

        courierDao.addCourier(login, password, companyId, name, surname, salary);
    }

    private static void fireCourier()
    {
        System.out.println("ID kuriera do zwolnienia: ");
        int id = scanner.nextInt();
        courierDao.fireCourier(id);
    }
}
