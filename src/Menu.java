import java.util.Scanner;
import java.io.*;

import users.AmateurUser;
import users.OccasionalUser;
import users.ProfessionalUser;
import users.User;
import users.UserManager;


public class Menu {
    private Scanner scanner;
    private UserManager userManager;
    private String usersFile = "data/users.ser";
    //String activitiesFile = "data/activities.ser";

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() throws IOException {
        int choice;
        userManager = new UserManager();

        //load users
        File file = new File(usersFile);
        if (file.exists()) {
            try {
                userManager.loadUsers(usersFile); 
                System.out.println("Users data loaded successfully.");
            } catch (IOException | ClassNotFoundException e) {
                if (e.getMessage() != null) {
                    System.out.println("Error loading users: " + e.getMessage());
                } 
            }
        } 
        else {
            System.out.println("Users data file does not exist: " + usersFile);
        }


        do {
            // Display the main menu
            System.out.println("=== Menu ===");

            System.out.println("1. Register (Create new account)");
            System.out.println("2. Login (Use your account already registered)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); 

            // Options 
            switch (choice) {
                case 1:
                    this.menuRegister();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;    
                case 5:
                    //save users
                    try {
                        userManager.saveUsers(usersFile);
                        System.out.println("Users data saved successfully.");
                    } catch (IOException e) {
                            System.out.println("Error saving users: " + e.getMessage());
                    }
                    
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();

        } while (choice != 5);
    }

    private void menuRegister() {
        String newId;
        String newName;
        String newAddress;
        String newEmail;
        int newHeartRate=0;
        int choice;

        boolean valid = false;

        //Display register menu
        System.out.println("===== Register =====");
        System.out.println("Create a new account");

        
        do {
            // Id scan
            System.out.print("Enter a new and unique User Id (Leave empty to return): ");

            newId = scanner.nextLine();
            if (newId.isEmpty()) {
                return;
            }

            if (userManager.containsUser(newId)==true) {
                System.out.println("This User already exists!");
            }
            else valid=true;

            System.out.println();
            
        } while (valid==false);
        
        System.out.println("Your User Id is " + newId);
        System.out.println();

        // Name scan
        System.out.print("Enter your Name: ");
        newName = scanner.nextLine();
        if (newName.isEmpty()) return;
        System.out.println("Your User Name is " + newName);
        System.out.println();

        // Address scan
        System.out.print("Enter your Address: ");
        newAddress = scanner.nextLine();
        if (newAddress.isEmpty()) return;
        System.out.println("Your Address is " + newAddress);
        System.out.println();

        // Email scan
        System.out.print("Enter your Email: ");
        newEmail = scanner.nextLine();
        if (newEmail.isEmpty()) return;
        System.out.println("Your Email is " + newEmail);
        System.out.println();

        // Heart rate scan
        System.out.print("Enter your Average Heart Rate: ");
        newHeartRate = scanner.nextInt();
        scanner.nextLine();
        if (newHeartRate==0) return;
        System.out.println("Your Average Heart Rate is " + newHeartRate);
        System.out.println();


        User newUser = null;

        do {
            System.out.println("Choose your type of user:");
            System.out.println("1. Professional");
            System.out.println("2. Amateur");
            System.out.println("3. Occasional");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine();

        
            switch (choice) {
                case 1:
                    newUser = new ProfessionalUser(newId, newName, newAddress, newEmail, newHeartRate);
                    break;
                case 2:
                    newUser = new AmateurUser(newId, newName, newAddress, newEmail, newHeartRate);
                    break;
                case 3:
                    newUser = new OccasionalUser(newId, newName, newAddress, newEmail, newHeartRate);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
            
        } while (choice<1 || choice>4);
        if (choice!=4 && newUser!=null) {
            userManager.addUser(newUser);
            System.out.println("New User created successfully!");
        }
    }

    /* private void menuLogin() {
        
    } */

}