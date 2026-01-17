package com.allegro.maven.dao;

import com.allegro.maven.db.Database;
import com.allegro.maven.model.Curier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurierDao {

    // Pobranie wszystkich kurierów
    public List<Curier> getAllCuriers() {
        List<Curier> curiers = new ArrayList<>();
        String sql = "SELECT Id, company_id, name, surname, salary FROM CurierInfo";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Curier c = new Curier();
                c.setId(rs.getInt("Id"));
                c.setCompanyId(rs.getInt("company_id"));
                c.setName(rs.getString("name"));
                c.setSurname(rs.getString("surname"));
                c.setSalary(rs.getDouble("salary"));
                curiers.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return curiers;
    }

    // Dodanie kuriera
    public void addCurier(String login, String password, int companyId, String name, String surname, double salary) {
        String sqlCurier = "INSERT INTO Curiers (Id, company_id, password) VALUES (NULL, ?, ?)";
        String sqlInfo = "INSERT INTO CurierInfo (curier_id, name, surname, salary, date_of_hairing) VALUES (?, ?, ?, ?, NOW())";

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            // Wstawienie do tabeli Curiers
            int curierId;
            try (PreparedStatement ps = conn.prepareStatement(sqlCurier, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, companyId);
                ps.setString(2, password);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) curierId = rs.getInt(1);
                else throw new SQLException("Nie udało się pobrać ID kuriera");
            }

            // Wstawienie do tabeli CurierInfo
            try (PreparedStatement ps2 = conn.prepareStatement(sqlInfo)) {
                ps2.setInt(1, curierId);
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
    public void fireCurier(int curierId) {
        String sql = "DELETE FROM Curiers WHERE Id = ?"; // lub dodatkowo UPDATE/USUN z CurierInfo
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, curierId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
