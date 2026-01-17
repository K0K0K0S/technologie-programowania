package com.allegro.maven;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

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
                    scanner.nextLine(); // Consume newline
                    try(Connection connection = DriverManager.getConnection("jdbc:mysql://root:oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK@hopper.proxy.rlwy.net:29959/railway","root","oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK");
                        Statement statement = connection.createStatement();)
                    {
                        System.out.println("Podaj imie i nazwisko nowego kuriera:");
                        String courierName = scanner.next();
                        String courierSurname = scanner.next();
                        System.out.println("Podaj id firmy go zatrudniającej:");
                        int companyID = scanner.nextInt();
                        System.out.println("Podaj jego placę miesięczną:");
                        double salary = scanner.nextDouble();
                        System.out.println("Podaj lub wygeneruj dla niego hasło dostępu:");
                        String password = scanner.next();
                        String insertQuery1 = "INSERT INTO Couriers (CompanyID, Password) VALUES ('" + companyID + "', '" + password + "')";
                        statement.executeUpdate(insertQuery1);
                        String insertQuery2 = "INSERT INTO Courier_info (Name, Surname, Salary) VALUES ('" + courierName + "', '" + courierSurname + "', '" + salary + "')";
                        statement.executeUpdate(insertQuery2);
                        System.out.println("Nowy kurier " + courierName + " został dodany pomyślnie.");
                    }
                    catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                case 4:
                {
                    //Zbanuj użytkownika
                }
                case 5:
                {
                    System.out.println("Podaj ID kuriera do zwolnienia:");
                    int courierID = scanner.nextInt();
                    System.out.println("Podaj powód zwolnienia:\n1)Niewłaściwe zachowanie\n2)Niska wydajność\n3)Kradzież lub utrata paczek\n4)Inne");
                    int reason = scanner.nextInt();
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
