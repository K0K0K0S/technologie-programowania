package com.allegro.maven.interfaces;

import com.allegro.maven.dao.DeliveryDao;
import com.allegro.maven.model.Delivery;

import java.util.List;
import java.util.Scanner;

public class CourierInterface 
{
    private static Scanner scanner = new Scanner(System.in);
    public static String location;
    public static int courierID;
    public static String courierName;

    private static final DeliveryDao deliveryDao = new DeliveryDao();
    
    private static String MENU = "1) Zaktualizuj swoją lokalizację\n2) Przeglądaj przypisane dostawy\n3) Pokaż paczki w okolicy\n4) Dostarcz paczkę\n5) Wyloguj się";    
    
    private static void RunCourier()
    {
        System.out.println("Witaj "+ courierName +"! Co chciałbyś dzisiaj zrobić?");
        boolean flag = true;
        while(flag)
        {
            System.out.println(MENU);
            int in = scanner.nextInt();
            scanner.nextLine();

            switch(in)
            {
                case 1:
                {
                    System.out.println("Podaj swoją aktualną lokalizację (miasto):");
                    location = scanner.nextLine();
                    System.out.println("Lokalizacja zaktualizowana na: " + location + " Utrzymuj dobrą pracę!");
                }
                case 2:
                {
                    List<Delivery> deliveries = deliveryDao.getDeliveriesByCourier(courierID);
                    System.out.println("Twoje dostawy:");
                    for (Delivery d : deliveries)
                    {
                        System.out.println("ID Zamówienia: " + d.getOrderId() + ", Status: " + d.getStatus() + ", Data dostawy: " + d.getDateOfDelivery());
                    }
                    break;
                }
                case 3:
                {
                    if (location == null || location.isEmpty())
                    {
                        System.out.println("Najpierw ustaw swoją lokalizację!");
                    }
                    else
                    {
                        List<Delivery> nearby = deliveryDao.getDeliveriesByLocation(location);
                        System.out.println("Paczki w Twojej okolicy:");
                        for (Delivery d : nearby)
                        {
                            System.out.println("ID Zamówienia: " + d.getOrderId() + ", Status: " + d.getStatus());
                        }
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("Podaj ID paczki do dostarczenia:");
                    int packageID = scanner.nextInt();
                    deliveryDao.updateDeliveryStatus(packageID, "Dostarczono");
                    System.out.println("Paczka oznaczona jako dostarczona");
                    break;
                }
                case 5:
                {
                    System.out.println("Wylogowywanie...");
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
                }
            }
        }
    }
}
