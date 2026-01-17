package com.allegro.maven.interfaces;

import java.util.List;
import java.util.Scanner;

import com.allegro.maven.dao.ItemDao;
import com.allegro.maven.model.Item;
import com.allegro.maven.service.OrderService;

public class UserInterface
{
    private static Scanner scanner = new Scanner(System.in);
    public static int ID;
    public static String username;

    private static final ItemDao itemDao = new ItemDao();
    private static final OrderService orderService = new OrderService();

    private static String MENU = "1) Wyszukaj przedmiot\n2) Wystaw na sprzedaż\n3) Kup\n4) Przeglądaj moje zamowienia i oferty \n5) Wyloguj się";

    private static String[] CATEGORIES = {"Elektronika", "Dom i Ogród", "Motoryzacja", "Sport i Turystyka", "Zdrowie i Uroda", "Kultura i Rozrywka", "Książki", "Inne"};
    //private static String[] filters = {"Kategoria", "Cena minimalna", "Cena maksymalna", "Stan przedmiotu", "Podgląd", "Szukaj", "Powrót do menu głównego"};
    private static String[] STATES = {"Nowy", "Używany", "Uszkodzony"};

    private static void RunClient()
    {
        System.out.println("Witaj "+ username +"! Co chciałbyś dzisiaj zrobić?");
        boolean running = true;
        while(running)
        {
            System.out.println(MENU);
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1 -> searchItems();
                case 2 -> sellItem();
                case 3 -> buyItem();
                case 4 -> showMyOrders();
                case 5 -> {
                    System.out.println("Wylogowywanie, żegnaj");
                    running = false;
                }
                default -> System.out.println("Nieprawidłowy wybór");
            }
        }
    }

    private static void searchItems()
    {
        scanner.nextLine();

        System.out.println("Wybierz kategorię:");
        for (int i = 0; i < CATEGORIES.length; i++)
        {
            System.out.println((i+1) + ") " + CATEGORIES[i]);
        }
        int category = scanner.nextInt();
        System.out.print("Cena minimalna: ");
        int minPrice = scanner.nextInt();

        System.out.print("Cena maksymalna: ");
        int maxPrice = scanner.nextInt();

        System.out.println("Stan:");
        for (int i = 0; i < STATES.length; i++)
        {
            System.out.println((i+1) + ") " + STATES[i]);
        }
        int state = scanner.nextInt();

        List<Item> items = itemDao.searchItems(CATEGORIES[category - 1], minPrice, maxPrice, STATES[state - 1]);

        if (items.isEmpty()) 
        {
            System.out.println("Brak wyników.");
            return;
        }

        System.out.println("\nWyniki:");
        for (Item item : items)
        {
            System.out.println(item.getId() + " | " + item.getName() + " | " + item.getPrice() + " zł | ilość: " + item.getAmount());
        }
    }

    private static void sellItem()
    {
        scanner.nextLine();

        Item item = new Item();
        item.setSellerId(ID);

        System.out.print("Nazwa przedmiotu: ");
        item.setName(scanner.nextLine());

        System.out.print("Ilość: ");
        item.setAmount(scanner.nextInt());

        System.out.print("Cena (zł): ");
        item.setPrice(scanner.nextInt());

        System.out.println("Stan:");
        for (int i = 0; i < STATES.length; i++)
        {
            System.out.println((i + 1) + ") " + STATES[i]);
        }
        item.setStatus(STATES[scanner.nextInt() - 1]);

        System.out.println("Kategoria:");
        for (int i = 0; i < CATEGORIES.length; i++)
        {
            System.out.println((i + 1) + ") " + CATEGORIES[i]);
        }
        item.setType(CATEGORIES[scanner.nextInt() - 1]);

        itemDao.addItem(item);

        System.out.println("Przedmiot wystawiony na sprzedaż!");
    }

    private static void buyItem()
    {
        System.out.print("Podaj ID przedmiotu: ");
        int itemId = scanner.nextInt();

        System.out.print("Ile sztuk chcesz kupić: ");
        int quantity = scanner.nextInt();

        orderService.buyItem(ID, itemId, quantity);
    }

    private static void showMyOrders() {
        System.out.println("Wyświetlanie zamówień (do zrobienia)");
    }
    
    public static void main(String[] args)
    {
        RunClient();
    }
}