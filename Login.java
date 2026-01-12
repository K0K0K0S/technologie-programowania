import java.util.Scanner;
public class Login 
{
    public static TextMenus menus = new TextMenus();
    private static Scanner scanner = new Scanner(System.in);

    public static void MainMenu()
    {
        Boolean Flag1 = true;
        System.out.println(menus.WelcomeText);
        while(Flag1)
        {
            System.out.println(menus.MainMenu);
            int choice1 = scanner.nextInt();
            switch(choice1)
            {
                case 1:
                    UserMenu();
                    break;
                case 2:
                    CourierMenu();
                    break;
                case 3:
                    AdminLogin();
                    break;
                case 4:
                    Flag1 = false;
                    System.out.println("Wyjście z programu");
                    break;
                default:
                    System.out.println(menus.ErrorInvalidChoice);
            }
        }

    }
    public static void UserMenu()
    {
        Boolean Flag2 = true;
        while(Flag2)
        {
            System.out.println(menus.UserMenu);
            int choice2 = scanner.nextInt();
            switch(choice2)
            {
                case 1:
                    RegisterUser();
                    break;
                case 2:
                    UserLogin();
                    break;
                case 3:
                    Flag2 = false;
                    break;
                default:
                    System.out.println(menus.ErrorInvalidChoice);
            }
        }
    }
    public static void CourierMenu()
    {
        Boolean Flag3 = true;
        while(Flag3)
        {
            System.out.println(menus.CourierMenu);
            int choice3 = scanner.nextInt();
            switch(choice3)
            {
                case 1:
                    // Courier login
                    break;
                case 2:
                    Flag3 = false;
                    break;
                default:
                    System.out.println(menus.ErrorInvalidChoice);
            }
        }
    }
    public static void AdminLogin()
    {
        System.out.println(menus.AdminLoginPrompt);
        while(true)
        {
            String adminCode = scanner.nextLine();
            if(adminCode.equals("return"))
            {
                break;
            }
            else
            {
                // Admin authentication code here
            }
        }
    }
    public static void RegisterUser()
    {
        scanner.nextLine(); // czyszczenie bufora
        String Imie, Nazwisko, Pesel, nazwaUzytkownika, Haslo;
        System.out.println(menus.UserRegistrationPrompt);
        System.out.print("Imię: ");
        Imie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        Nazwisko = scanner.nextLine();
        System.out.print("PESEL: ");
        while(true)
        {
            Pesel = scanner.nextLine();
            if(Pesel.length() != 11)
            {
                System.out.print("PESEL musi mieć 11 znaków. Podaj ponownie: ");
            }
            else
            {
                break;
            }
        }
        System.out.print("Nazwa użytkownika: ");
        while(true)
        {
            nazwaUzytkownika = scanner.nextLine();
            Boolean containsForbidden = false;
            for(String forbiddenWord : menus.ListaSlowZabronionych)
            {
                if(nazwaUzytkownika.contains(forbiddenWord))
                {
                    containsForbidden = true;
                    break;
                }
            }
            if(containsForbidden)
            {
                System.out.print("Nazwa użytkownika zawiera niedozwolone słowa. Podaj ponownie: ");
            }
            else
            {
                break;
            }
        }
        System.out.print("Hasło: ");
        Haslo = scanner.nextLine();
        //tu tworzyc użytkownika w bazie danych
        // i zwróć jego id, chyba że logujemy się po nazwie użytkownika
    }
    public static void UserLogin()
    {
        //zależy czy logujemy się po nazwie użytkownika czy po id
        System.out.print("Nazwa użytkownika: ");
        String nazwaUzytkownika = scanner.nextLine();
        System.out.print("Hasło: ");
        String haslo = scanner.nextLine();
        // User login code here
    }


    public static void main(String[] args) 
    {
       MainMenu();
    }
}