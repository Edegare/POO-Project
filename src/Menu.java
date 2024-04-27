import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import users.*;
import activities.*;


public class Menu {
    private Scanner scanner;
    private UserManager userManager;
    private String usersFile = "data/users.ser";
    private LocalDate date;
    private List<Activity> definedActivities;


    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.userManager = new UserManager();
        this.date = LocalDate.now();
        this.definedActivities = new ArrayList<>();

        definedActivities.add(new BenchPress(0, 0, 0, 0));     
        definedActivities.add(new Canoe(0, 0));              
        definedActivities.add(new LegExtension(0, 0, 0, 0));   
        definedActivities.add(new TrackRun(0, 0));            
        definedActivities.add(new TrailRun(0, 0, 0));        
        definedActivities.add(new SitUps(0, 0, 0));             
        definedActivities.add(new PushUps(0, 0, 0));             
        definedActivities.add(new MountainBike(0, 0, 0)); 
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
            System.out.println("4. Some Users Stats");
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
                case 4: 
                    System.out.println(); 
                    this.displayUserStatsMenu();
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
        List<TrainSession> newSessions = new ArrayList<>();
        
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
                    newUser = new ProfessionalUser(newId, newName, newAddress, newEmail, newHeartRate, newWeight, newSessions);
                    break;
                case 2:
                    newUser = new AmateurUser(newId, newName, newAddress, newEmail, newHeartRate, newWeight, newSessions);
                    break;
                case 3:
                    newUser = new OccasionalUser(newId, newName, newAddress, newEmail, newHeartRate, newWeight, newSessions);
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
            System.out.println("8. Exit to Menu");
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
                    this.userManager.updateUser(user);
                    break;
                case 7:
                    System.out.println("Do You really want to delete this account?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    delete = this.scanner.nextInt();
                    this.scanner.nextLine(); 
                    if (delete==1) {
                        this.userManager.removeUser(user.getId());
                        System.out.println("User deleted!");
                    }
                    else System.out.println("User not Deleted!");
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();

        } while (choice != 8 && delete != 1);
    }

    // ================= User My Train Sessions Menu =================
    private void userActivitiesMenu(User user) {
        int choice;
        
        do {
            // Display the Train Sessions menu
            System.out.println(); 
            System.out.println("===== My Train Sessions =====");
            System.out.println(user.toStringSessions());
            System.out.println("1. My User Training Stats");
            System.out.println("2. My Activities");
            System.out.println("3. Create new Train Session");
            System.out.println("4. Delete a Train Session");
            System.out.println("5. Exit to Menu");
            System.out.print("Enter your choice: ");

            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); 
            
            System.out.println();

            // Options 
            switch (choice) {
                case 1:
                    System.out.println("== My Stats ==");
                    System.out.println("Today's Date: " + this.date);
                    System.out.println("My most practiced Activity: " + user.getNameMostPracticedActivity(this.date));
                    System.out.println("My consumed Calories: " + user.calcUserTotalCalories(this.date));
                    System.out.println("My Total Traveled Km's: " + user.getTotalDistance(this.date));
                    System.out.println("My Total Meters of Altimetry: " + user.getTotalHeightMeters(this.date));
                    break;
                case 2:
                    System.out.println(user.toStringActivities());
                    break;   
                case 3:
                    createTrainSession(user);
                    break; 
                case 4:
                    int delete = 0;
                    int session = 0;
                    System.out.println(user.toStringSessions());
                    System.out.println("Choose a Session to Delete: ");
                    delete = this.scanner.nextInt();
                    this.scanner.nextLine();
                    if (session > 0 && session < user.countSessions()) { 
                        System.out.println("Do You really want to delete this session?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        delete = this.scanner.nextInt();
                        this.scanner.nextLine(); 
                        if (delete==1) {
                            user.removeSession(session-1);
                            System.out.println("Train Session Deleted!");
                        }
                        else System.out.println("Train Session not Deleted!");
                    }
                    else System.out.println("No modifications done!");

                    break; 
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();

        } while (choice != 5);
    }

    private void displayUserStatsMenu() {
        int choice;
    
        do {
            // Display the User Stats menu
            System.out.println();
            System.out.println("===== User Stats =====");
            System.out.println("1. User who expended the most calories in a period or ever");
            System.out.println("2. User who performed the most activities in a period or ever");
            System.out.println("3. Most performed activity type");
            System.out.println("4. Total kilometers a user has done in a period or ever");
            System.out.println("5. Total altitude meters a user has done in a period or ever");
            System.out.println("6. Most demanding training plan based on proposed calorie expenditure");
            System.out.println("7. List a user's activities");
            System.out.println("8. Return to Menu");
            System.out.print("Enter your choice: ");
    
            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine();
    
            System.out.println();
    
            // Options
            switch (choice) {
                case 1:
                    // Implement functionality for option 1
                    break;
                case 2:
                    User user = this.userManager.getUserWithMostActivities(date);
                    if(user != null){
                        System.out.println();  
                        System.out.println("The name of the user: " + user.getName());
                    }
                    break;
                case 3:
                    System.out.println();  
                    System.out.println("The name of the most popular activity: " + this.userManager.getMostPracticedActivity()); 
                    break;
                case 4:
                    // Implement functionality for option 4
                    break;
                case 5:
                    // Implement functionality for option 5
                    break;
                case 6:
                    TrainSession trainsession  = userManager.getMostDemandingTrainingPlan();
                    System.out.println();  
                    if(trainsession != null){
                        System.out.println(trainsession.toString());
                    }
                    break;
                case 7:
                    // Implement functionality for option 7
                    break;
                case 8:
                    System.out.println("Returning to menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
    
            System.out.println();
    
        } while (choice != 8);
    }

    // ================= Create train Session Menu =================
    private void createTrainSession(User u) {
        TrainSession newSession =  new TrainSession();

        int choice;
        int nActivities=0;

        System.out.println("== Create a new Train Session ==");

        System.out.println("Write a date with format yyyy-MM-dd: ");
        String input = this.scanner.nextLine();
        
        try {
            LocalDate sessionDate = LocalDate.parse(input);
            newSession.setSessionDate(sessionDate);
            System.out.println("Your Train Session Date: " + newSession.getDate());
        } catch (DateTimeParseException e) {
            System.out.println("Format incorrect. Use the format yyyy-MM-dd.");
            return;
        }

        System.out.println();
        do {
            int erro=0;
            System.out.println("== Create a new Train Session ==");
            System.out.println("1. Add new Activity to this Training! " + (nActivities) + " of 3 Activities in this Training");
            System.out.println("2. See Training Session Stats");
            System.out.println("3. Save and Exit");
            System.out.println("4. Exit without Saving");
            System.out.println("Enter your choice: ");
            // User choice
            choice = this.scanner.nextInt();
            this.scanner.nextLine(); 
            
            System.out.println();

            // Options 
            switch (choice) {
                case 1:
                    if (nActivities==3) System.out.println("Can't insert more Activities!");
                    else {
                        //List all activities
                        System.out.println("List of activities to add: ");
                        StringBuilder sb = new StringBuilder();
                        int i = 1;

                        for (Activity activity : this.definedActivities) {
                            sb.append(i + ". ").append(activity.getName());
                            if (activity.isHard()) {
                                sb.append(" - Hard\n");
                            }
                            else sb.append(" - Normal\n");
                            i++;
                        }

                        System.out.println(sb);
                        System.out.println("Enter your choice: ");
                        
                        // User choice
                        int choice2 = this.scanner.nextInt();
                        this.scanner.nextLine();

                        if (choice2>0 && choice2<i) {
                            double duration;
                            Activity activityToAdd = this.definedActivities.get(choice2-1).clone();

                            System.out.println("Write your activity duration in Hours: ");
                            duration = this.scanner.nextDouble();
                            this.scanner.nextLine();

                            // Create new activity based on type
                            if (activityToAdd.isDistanceActivity()) {
                                System.out.println("Write your activity distance in Km's: ");
                                double distance = this.scanner.nextDouble();
                                this.scanner.nextLine();

                                if (activityToAdd.getName().equals("Track Run")) activityToAdd = new TrackRun(duration, distance);
                                else if (activityToAdd.getName().equals("Canoe")) activityToAdd = new Canoe(duration, distance);
                                else {System.out.println("Error adding new Activity"); erro++;};
                            }
                            else if (activityToAdd.isRepetitionActivity()) {
                                System.out.println("Write your activity number of repetitions per set: ");
                                int reps= this.scanner.nextInt();
                                this.scanner.nextLine();
                                System.out.println("Write your activity number of sets: ");
                                int sets= this.scanner.nextInt();
                                this.scanner.nextLine();

                                if (activityToAdd.getName().equals("Sit Ups")) activityToAdd = new SitUps(duration, reps,sets);
                                else if (activityToAdd.getName().equals("Push Ups")) activityToAdd = new PushUps(duration, reps,sets);
                                else {System.out.println("Error adding new Activity"); erro++;};
                            }
                            else if (activityToAdd.isWeightActivity()) {
                                System.out.println("Write your activity number of repetitions per set: ");
                                int reps= this.scanner.nextInt();
                                this.scanner.nextLine();
                                System.out.println("Write your activity number of sets: ");
                                int sets= this.scanner.nextInt();
                                this.scanner.nextLine();
                                System.out.println("Write your activity total Weight in Kgs: ");
                                int wgt = this.scanner.nextInt();
                                this.scanner.nextLine();

                                if (activityToAdd.getName().equals("Leg Extension")) activityToAdd = new LegExtension(duration, reps,sets,wgt);
                                else if (activityToAdd.getName().equals("Bench Press")) activityToAdd = new BenchPress(duration, reps,sets,wgt);
                                else {System.out.println("Error adding new Activity");erro++;};
                            }
                            else if (activityToAdd.isDistanceAltimetryActivity()) {                                
                                System.out.println("Write your activity distance in Km's: ");
                                double distance = this.scanner.nextDouble();
                                this.scanner.nextLine();
                                System.out.println("Write your activity height in Km's: ");
                                double height = this.scanner.nextDouble();
                                this.scanner.nextLine();

                                if (activityToAdd.getName().equals("Trail Run")) activityToAdd = new TrailRun(duration, distance, height);
                                else if (activityToAdd.getName().equals("Mountain Bike")) activityToAdd = new MountainBike(duration, distance, height);
                                else {System.out.println("Error adding new Activity");erro++;};
                            }
                            if (erro==0) { 
                                newSession.addActivity(activityToAdd);
                                nActivities++;
                            }
                        }
                        else System.out.println("Invalid choice!");
                    }
                    break;
                
                case 2: 
                    System.out.println(newSession.toString());
                    double totalCalories = u.multiplierCaloriesTypeUser() * newSession.calcSessionCalories();
                    System.out.println("\nSession total Calories -> " + (int)totalCalories);
                    break;
                case 3:
                    if (newSession.getActivitiesCount()>0) {
                        u.addSession(newSession);
                    }
                    System.out.println("Saving and Exiting...");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();

        } while (choice != 4 && choice !=3);
        
    } 
}



