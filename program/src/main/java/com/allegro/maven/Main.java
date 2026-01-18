package com.allegro.maven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.allegro.maven.db.Database;
import com.allegro.maven.interfaces.AdminInterface;
import com.allegro.maven.interfaces.CourierInterface;
import com.allegro.maven.interfaces.UserInterface;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Witaj w systemie sklepu internetowego ===");
        System.out.print("Podaj nazwę użytkownika: ");
        String username = scanner.nextLine();

        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();

        UserData user = authenticateUser(username, password);

        if (user == null)
        {
            System.out.println("Niepoprawny login lub hasło. Koniec programu");
            return;
        }

        switch(user.role)
        {
            case "USER":
                UserInterface.ID = user.id;
                UserInterface.username = user.username;
                UserInterface.RunUser();
                break;
            case "COURIER":
                CourierInterface.courierID = user.id;
                CourierInterface.courierName = user.username;
                CourierInterface.RunCourier();
                break;
            case "ADMIN":
                AdminInterface.RunAdmin();
                break;
            default:
                System.out.println("Nieznana rola użytkownika. Koniec programu");
                break;
        }
        scanner.close();
    }

    private static UserData authenticateUser(String username, String password)
    {
        String sql = "SELECT Id, username, role FROM Users WHERE username = ? AND password = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                UserData user = new UserData();
                user.id = rs.getInt("Id");
                user.username = rs.getString("username");
                user.role = rs.getString("role");
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static class UserData
    {
        int id;
        String username;
        String role;
    }
}