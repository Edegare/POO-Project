import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

import users.*;
import activities.*;


public class Menu {
    private Scanner scanner;
    private UserManager userManager;
    private String usersFile = "data/users.ser";
    private LocalDate date;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.userManager = new UserManager();
        this.date = LocalDate.now();
    }

    //================= Main Menu =================
    public void displayMainMenu() throws IOException {
        int choice;


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

            System.out.println("1. Register (Create new Account)");
            System.out.println("2. Login (Use an Account already registered)");
            System.out.println("3. View all Users registered");
            System.out.println("4. Users Best Stats");
            System.out.println("5. Change Date");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); 

            // Options 
            switch (choice) {
                case 1:
                    System.out.println();
                    this.menuRegister();
                    break;
                case 2:
                    System.out.println();
                    this.menuLogin();
                    break;   
                case 3:
                    System.out.println();
                    System.out.println(this.userManager.toString());
                    break; 
                case 6:
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

        } while (choice != 6);
    }
 
    // ================= Register =================
    private void menuRegister() {
        String newId;
        String newName;
        String newAddress;
        String newEmail;
        int newHeartRate=0;
        int newWeight=0;
        List<TrainSession> newSession = new ArrayList<>();
        
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
                System.out.println();
            }
            else valid=true;
 
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
        System.out.print("Enter your Average Heart Rate (BPM): ");
        newHeartRate = scanner.nextInt();
        scanner.nextLine();
        if (newHeartRate==0) return;
        System.out.println("Your Average Heart Rate is " + newHeartRate + " BPM");
        System.out.println();

        System.out.print("Enter your Weight (Kg): ");
        newWeight = scanner.nextInt();
        scanner.nextLine();
        if (newWeight==0) return;
        System.out.println("Your Weight is " + newWeight + " Kg");
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
                    newUser = new ProfessionalUser(newId, newName, newAddress, newEmail, newHeartRate, newWeight, newSession);
                    break;
                case 2:
                    newUser = new AmateurUser(newId, newName, newAddress, newEmail, newHeartRate, newWeight, newSession);
                    break;
                case 3:
                    newUser = new OccasionalUser(newId, newName, newAddress, newEmail, newHeartRate, newWeight, newSession);
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

    // ================= Login =================
    private void menuLogin() {
        String userId;
        boolean exists=false;

        //Display login menu
        System.out.println("===== Login =====");
        System.out.println("Enter an account");

        do {
            // Id scan
            System.out.print("Enter your id (Leave empty to return): ");

            userId= scanner.nextLine();
            if (userId.isEmpty()) {
                return;
            }

            if (userManager.containsUser(userId)==false) {
                System.out.println("This User doesn't exist!");
                System.out.println();
            }
            else exists=true;

        } while (exists==false);

        // Get the user if sucess login
        User user = this.userManager.getUser(userId);
        System.out.println();  
        System.out.println("You entered your account!");
        System.out.println();  
        userMenu(user);
    }

    // ================= User Menu after logging in =================
    private void userMenu(User user) {
        int choice;
        int delete=2;
        
        do {
            // Display the User menu
            System.out.println(); 
            System.out.println("===== User =====");
            System.out.println(user.toStringProfile());
            System.out.println("1. Change my Name");
            System.out.println("2. Change my Address");
            System.out.println("3. Change my Email");
            System.out.println("4. Change my Average Heart Rate");
            System.out.println("5. Change my Weight");
            System.out.println("6. My Train Sessions");
            System.out.println("7. Delete Account");
            System.out.println("10. Exit to Menu");
            System.out.print("Enter your choice: ");

            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); 
            
            System.out.println();

            // Options 
            switch (choice) {
                case 1:
                    System.out.println("Write your new Name: ");
                    String newName = this.scanner.nextLine();

                    // Update info
                    if (!(newName.isEmpty())) {
                        user.setName(newName);
                        System.out.println("You changed your Name!");
                        this.userManager.updateUser(user);
                    }
                    else System.out.println("No changes done!");

                    break;
                case 2:
                    System.out.println("Write your new Address: ");
                    String newAdrress = this.scanner.nextLine();

                    // Update info
                    if (!(newAdrress.isEmpty())) {
                        user.setAddress(newAdrress);
                        System.out.println("You changed your Address!");
                        this.userManager.updateUser(user);
                    }
                    else System.out.println("No changes done!");

                    break;   
                case 3:
                    System.out.println("Write your new Email: ");
                    String newEmail = this.scanner.nextLine();
                    
                    // Update info
                    if (!(newEmail.isEmpty())) {
                        user.setEmail(newEmail);
                        System.out.println("You changed your Email!");
                        this.userManager.updateUser(user);
                    }
                    else System.out.println("No changes done!");

                    break; 
                case 4:
                    System.out.println("Write your new Average Heart Rate: ");

                    int newHeartRate = this.scanner.nextInt();
                    this.scanner.nextLine(); 
                    
                    // Update info
                    user.setHeartRate(newHeartRate);
                    System.out.println("You changed your Average Heart Rate!");
                    this.userManager.updateUser(user);
                    break; 
                case 5:
                    System.out.println("Write your new Weight: ");

                    int newWeight = this.scanner.nextInt();
                    this.scanner.nextLine(); 
                    
                    // Update info
                    user.setWeight(newWeight);
                    System.out.println("You changed your Weight!");
                    this.userManager.updateUser(user);
                    break;   
                case 6:
                    userActivitiesMenu(user);
                    break;
                case 7:
                    System.out.println("Do You really want to delete this account?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    delete = this.scanner.nextInt();
                    this.scanner.nextLine(); 
                    if (delete==1) this.userManager.removeUser(user.getId());
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();

        } while (choice != 10 && delete !=1);
    }

    // ================= User My Train Sessions Menu =================
    private void userActivitiesMenu(User user) {
        int choice;
        
        do {
            // Display the User menu
            System.out.println(); 
            System.out.println("===== My Train Sessions =====");
            System.out.println(user.toStringSessions());
            System.out.println("1. Add Train Session");
            System.out.println("2. Choose a Session");
            System.out.println("3. All Activities");
            System.out.println("10. Exit to Menu");
            System.out.print("Enter your choice: ");

            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); 
            
            System.out.println();

            // Options 
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                   
                    break;   
                case 3:


                    break; 
                case 4:
                   
                    break; 
                case 5:
                    
                    break;   
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();

        } while (choice != 10);
    }
}
