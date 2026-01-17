package com.allegro.maven.dao;

import com.allegro.maven.db.Database;
import com.allegro.maven.model.Delivery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDao {

    // Pobranie wszystkich dostaw przypisanych do kuriera
    public List<Delivery> getDeliveriesByCurier(int curierId) {
        List<Delivery> deliveries = new ArrayList<>();
        String sql = "SELECT * FROM Deliveries WHERE curier_id = ? ORDER BY date_of_delivery DESC";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, curierId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                deliveries.add(mapDelivery(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    // Pobranie wszystkich dostaw w określonej lokalizacji
    // Zakładamy, że masz tabelę Orders z kolumną location lub UserInfo.location powiązaną z order
    public List<Delivery> getDeliveriesByLocation(String location) {
        List<Delivery> deliveries = new ArrayList<>();
        String sql = "SELECT d.* FROM Deliveries d " +
                     "JOIN Orders o ON d.order_id = o.Id " +
                     "JOIN UserInfo u ON o.buyer = u.user_id " +
                     "WHERE u.location = ? AND d.status != 'Dostarczono'";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                deliveries.add(mapDelivery(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    // Aktualizacja statusu dostawy (np. "W drodze" -> "Dostarczono")
    public void updateDeliveryStatus(int orderId, String status) {
        String sql = "UPDATE Deliveries SET status = ? WHERE order_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Pomocnicza metoda mapująca ResultSet -> Delivery
    private Delivery mapDelivery(ResultSet rs) throws SQLException {
        Delivery d = new Delivery();
        d.setOrderId(rs.getInt("order_id"));
        d.setCurierId(rs.getInt("curier_id"));
        d.setStatus(rs.getString("status"));
        Timestamp ts = rs.getTimestamp("date_of_delivery");
        if (ts != null) d.setDateOfDelivery(ts.toLocalDateTime());
        return d;
    }
}