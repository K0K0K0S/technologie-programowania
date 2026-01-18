package com.allegro.maven.dao;

import com.allegro.maven.model.Item;
import com.allegro.maven.db.Database;

import java.sql.*;
import java.util.*;

public class ItemDao {

    public List<Item> searchItems(String category, int minPrice, int maxPrice, String state) 
    {
        List<Item> items = new ArrayList<>();

        String sql = """
            SELECT * FROM Items
            WHERE type = ?
              AND price BETWEEN ? AND ?
              AND status = ?
        """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category);
            ps.setInt(2, minPrice);
            ps.setInt(3, maxPrice);
            ps.setString(4, state);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getInt("price"));
                item.setAmount(rs.getInt("amount"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public void addItem(Item item) {
        String sql = """
            INSERT INTO Items (seller_id, name, type, status, amount, price)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, item.getSellerId());
            ps.setString(2, item.getName());
            ps.setString(3, item.getType());
            ps.setString(4, item.getStatus());
            ps.setInt(5, item.getAmount());
            ps.setDouble(6, item.getPrice());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
