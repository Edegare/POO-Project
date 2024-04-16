import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        int choice;

        do {
            // Display the main menu
            System.out.println("=== Menu ===");

            System.out.println("1. Register (Create new account)");
            System.out.println("2. Login (Use your account already registered)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // User choice
            choice = scanner.nextInt();
            scanner.nextLine(); 

            // Options 
            switch (choice) {
                case 1:
                    OptionRegister();
                    break;
                case 2:
                    OptionLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println(); // Print a blank line for readability

        } while (choice != 3);
    }

    private void OptionRegister() {
        String newId;
        int valido = 0;
        do {
            // Display submenu for Option 1
            System.out.println("=== Register ===");

            System.out.print("Enter a new and unique user id: ");

            // User choice
            newId = scanner.nextLine();
            valido = 1;
            System.out.println();

        } while (valido != 1);
        System.out.println("Your username is " + newId);
    }

    private void OptionLogin() {
        
    }

}