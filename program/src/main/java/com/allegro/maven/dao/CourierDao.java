package com.allegro.maven.dao;

import com.allegro.maven.db.Database;
import com.allegro.maven.model.Courier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourierDao {

    // Pobranie wszystkich kurierów
    public List<Courier> getAllCouriers() {
        List<Courier> couriers = new ArrayList<>();
        String sql = "SELECT Id, company_id, name, surname, salary FROM CourierInfo";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Courier c = new Courier();
                c.setId(rs.getInt("Id"));
                c.setCompanyId(rs.getInt("company_id"));
                //niewiem czy chcesz tworzyć CourierInfo czy osoby plik java
               // c.setName(rs.getString("name"));
               // c.setSurname(rs.getString("surname"));
                //c.setSalary(rs.getDouble("salary"));
                couriers.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return couriers;
    }

    // Dodanie kuriera
    public void addCourier(String login, String password, int companyId, String name, String surname, double salary) {
        String sqlCourier = "INSERT INTO Couriers (Id, company_id, password) VALUES (NULL, ?, ?)";
        String sqlInfo = "INSERT INTO CourierInfo (courier_id, name, surname, salary, date_of_hairing) VALUES (?, ?, ?, ?, NOW())";

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            // Wstawienie do tabeli Couriers
            int courierId;
            try (PreparedStatement ps = conn.prepareStatement(sqlCourier, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, companyId);
                ps.setString(2, password);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) courierId = rs.getInt(1);
                else throw new SQLException("Nie udało się pobrać ID kuriera");
            }

            // Wstawienie do tabeli CourierInfo
            try (PreparedStatement ps2 = conn.prepareStatement(sqlInfo)) {
                ps2.setInt(1, courierId);
                ps2.setString(2, name);
                ps2.setString(3, surname);
                ps2.setDouble(4, salary);
                ps2.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Zwolnienie kuriera
    public void fireCourier(int courierId) {
        String sql = "DELETE FROM Couriers WHERE Id = ?"; // lub dodatkowo UPDATE/USUN z CourierInfo
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, courierId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
