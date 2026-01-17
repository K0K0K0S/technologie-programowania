package com.allegro.maven.dao;

import com.allegro.maven.db.Database;
import com.allegro.maven.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // Pobranie wszystkich użytkowników
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT Id, username FROM Users";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("Id"));
                u.setUsername(rs.getString("username"));
                users.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Zbanowanie użytkownika (przykładowo usuwa lub ustawia flagę)
    public void banUser(int userId) {
        String sql = "DELETE FROM Users WHERE Id = ?"; // lub UPDATE Users SET banned=1
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Pobranie użytkownika po ID
    public User getUserById(int userId) {
        String sql = "SELECT Id, username FROM Users WHERE Id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("Id"));
                u.setUsername(rs.getString("username"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}