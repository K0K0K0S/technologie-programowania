package com.allegro.maven.dao;

import java.sql.*;
import com.allegro.maven.model.Item;

public class OrderDao {

    public void createOrder(
            Connection conn,
            int buyerId,
            Item item,
            int quantity
    ) throws SQLException {

        String sql = """
            INSERT INTO Orders (item_id, buyer, seller, cost, date_of_order)
            VALUES (?, ?, ?, ?, NOW())
        """;

        Double totalCost = item.getPrice() * quantity;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, item.getId());
            ps.setInt(2, buyerId);
            ps.setInt(3, item.getSellerId());
            ps.setDouble(4, totalCost);
            ps.executeUpdate();
        }
    }
}
