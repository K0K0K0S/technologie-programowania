package com.allegro.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Login 
{
    public static TextMenus menus = new TextMenus();
    private static Scanner scanner = new Scanner(System.in);

    public static void MainMenu()
    {
        boolean flag1 = true;
        System.out.println(menus.welcomeText);
        while(flag1)
        {
            System.out.println(menus.mainMenu);
            int choice1 = scanner.nextInt();
            switch(choice1)
            {
                case 1:
                    UserMenu();
                    break;
                case 2:
                    CourierMenu();
                    break;
                case 3:
                    AdminLogin();
                    break;
                case 4:
                    flag1 = false;
                    System.out.println(menus.exitText);
                    break;
                default:
                    System.out.println(menus.errorInvalidChoice);
            }
        }

    }
    public static void UserMenu()
    {
        boolean flag2 = true;
        while(flag2)
        {
            System.out.println(menus.userMenu);
            int choice2 = scanner.nextInt();
            switch(choice2)
            {
                case 1:
                    RegisterUser();
                    break;
                case 2:
                    UserLogin();
                    break;
                case 3:
                    flag2 = false;
                    break;
                default:
                    System.out.println(menus.errorInvalidChoice);
            }
        }
    }
    public static void CourierMenu()
    {
        boolean flag3 = true;
        while(flag3)
        {
            System.out.println(menus.courierMenu);
            int choice3 = scanner.nextInt();
            switch(choice3)
            {
                case 1:
                    // Courier login
                    break;
                case 2:
                    flag3 = false;
                    break;
                default:
                    System.out.println(menus.errorInvalidChoice);
            }
        }
    }
    public static void AdminLogin()
    {
        System.out.println(menus.adminLoginPrompt);
        while(true)
        {
            String adminCode = scanner.nextLine();
            if(adminCode.equals("return"))
            {
                break;
            }
            else if(adminCode.equals("Pompki")) // przykładowy kod dostępu
            {
                System.out.println("Zalogowano jako administrator.");
                // Admin authentication code here
            }
        }
    }
    public static void RegisterUser()
    {
        scanner.nextLine(); // czyszczenie bufora
        String firstName, lastName, PESEL, username, password, address;
        System.out.println(menus.userRegistrationPrompt);
        System.out.print("Imię: ");
        firstName = scanner.nextLine();
        System.out.print("Nazwisko: ");
        lastName = scanner.nextLine();
        System.out.print("PESEL: ");
        while(true)
        {
            PESEL = scanner.nextLine();
            if(PESEL.length() != 11)
            {
                System.out.print("PESEL musi mieć 11 znaków. Podaj ponownie: ");
            }
            else
            {
                break;
            }
        }
        System.out.print("Nazwa użytkownika: ");
        while(true)
        {
            username = scanner.nextLine();
            boolean containsForbidden = false;
            for(String forbiddenWord : menus.forbiddenWords)
            {
                if(username.contains(forbiddenWord))
                {
                    containsForbidden = true;
                    break;
                }
            }
            if(containsForbidden)
            {
                System.out.print("Nazwa użytkownika zawiera niedozwolone słowa. Podaj ponownie: ");
            }
            else
            {
                break;
            }
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://root:oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK@hopper.proxy.rlwy.net:29959/railway","root","oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK");
            Statement stmt = conn.createStatement();)
        {
            System.out.print("Adres: ");
            address = scanner.nextLine();
            System.out.print("Hasło: ");
            password = scanner.nextLine();
            String request1 ="INSERT INTO Users (Username) VALUES ('" + username + "');";
            stmt.executeUpdate(request1);
            String request2 = "INSERT INTO User_info (PESEL, Imie, Nazwisko, Adress, Hasło) VALUES ('" + PESEL + "', '" + firstName + "', '" + lastName + "', '" + address + "', '" + password + "');";
            stmt.executeUpdate(request2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //tu tworzyc użytkownika w bazie danych
        // i zwróć jego id, chyba że logujemy się po nazwie użytkownika
    }
    public static void UserLogin()
    {
        scanner.nextLine();
        //zależy czy logujemy się po nazwie użytkownika czy po id
        System.out.println("Nazwa użytkownika: ");
        String username = scanner.nextLine();
        System.out.println("Hasło: ");
        String password = scanner.nextLine();
        // User login code here
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://root:oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK@hopper.proxy.rlwy.net:29959/railway","root","oEZEQyzBUNjknQOXuQNiJuUmwhyOLNRK");
            Statement stmt = conn.createStatement();)
        {
            String query = "SELECT * FROM Users u JOIN User_info ui ON u.UserID = ui.UserID WHERE u.Username = '" + username + "' AND ui.Hasło = '" + password + "';";
            var rs = stmt.executeQuery(query);
            if(rs.next())
            {
                int userID = rs.getInt("UserID");
                String firstName = rs.getString("Imie");
                System.out.println("Zalogowano jako " + firstName);
                //UserInterface.RunUser(userID, firstName);
            }
            else
            {
                System.out.println("Nieprawidłowa nazwa użytkownika lub hasło.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
       MainMenu();
    }
}
