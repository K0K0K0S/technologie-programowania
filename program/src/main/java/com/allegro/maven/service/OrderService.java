package com.allegro.maven.service;

import java.sql.Connection;
import com.allegro.maven.dao.ItemDao;
import com.allegro.maven.dao.OrderDao;
import com.allegro.maven.db.Database;
import com.allegro.maven.model.Item;

public class OrderService {

    private final ItemDao itemDao = new ItemDao();
    private final OrderDao orderDao = new OrderDao();

    public void buyItem(int buyerId, int itemId, int quantity) {

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            Item item = itemDao.getItemForUpdate(conn, itemId);

            if (item == null) {
                throw new IllegalStateException("Przedmiot nie istnieje");
            }

            if (item.getAmount() < quantity) {
                throw new IllegalStateException("Za mało sztuk na stanie");
            }

            itemDao.decreaseAmount(conn, itemId, quantity);
            orderDao.createOrder(conn, buyerId, item, quantity);

            conn.commit();
            System.out.println("Zakup zakończony sukcesem!");

        } catch (Exception e) {
            System.out.println("Błąd zakupu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
