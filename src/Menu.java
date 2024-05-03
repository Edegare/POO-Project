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

    // ================= Main Menu =================
    public void displayMainMenu() throws IOException {
        loadUserData();

        String[] options = {
                "Register (Create new Account)",
                "Login (Use an Account already registered)",
                "View all Users registered",
                "Stats",
                "Change Date",
                "Exit and Save"
        };

        ListMenu menu = new ListMenu(options, false);
        menu.setHandler(1, this::menuRegister);
        menu.setHandler(2, this::menuLogin);
        menu.setHandler(3, this::viewAllUsers);
        menu.setHandler(4, this::displayStatsMenu);
        menu.setHandler(5, this::changeDate);
        menu.setHandler(6, this::exitAndSave);
        menu.setTitle("Main Menu");

        menu.run();
    }

    // ================= Register =================
    private void menuRegister() {
        class UserData {
            String id;
            String name;
            String address;
            String email;
            int heartRate;
            int weight;
            List<TrainSession> sessions = new ArrayList<>();
        }

        UserData userData = new UserData();

        boolean valid = false;

        // Display register menu
        System.out.println("===== Register =====");
        System.out.println("Create a new account");

        do {
            System.out.print("Enter a new and unique User Id (Leave empty to return): ");
            userData.id = scanner.nextLine();
            if (userData.id.isEmpty()) {
                return;
            }

            if (userManager.containsUser(userData.id)) {
                System.out.println("This User already exists!");
                System.out.println();
            } else {
                valid = true;
            }

        } while (!valid);

        System.out.print("Enter your Name: ");
        userData.name = scanner.nextLine();
        if (userData.name.isEmpty())
            return;
        System.out.print("Enter your Address: ");
        userData.address = scanner.nextLine();
        if (userData.address.isEmpty())
            return;
        System.out.print("Enter your Email: ");
        userData.email = scanner.nextLine();
        if (userData.email.isEmpty())
            return;
        System.out.print("Enter your Average Heart Rate (BPM): ");
        userData.heartRate = scanner.nextInt();
        scanner.nextLine();
        if (userData.heartRate == 0)
            return;
        System.out.print("Enter your Weight (Kg): ");
        userData.weight = scanner.nextInt();
        scanner.nextLine();
        if (userData.weight == 0)
            return;

        final User[] newUser = new User[1]; // Array to hold the user object
        String[] options = { "Professional", "Amateur", "Occasional", "Return to Main Menu" };
        ListMenu userMenu = new ListMenu(options, true);

        // Handlers for each user type
        userMenu.setHandler(1, () -> {
            newUser[0] = new ProfessionalUser(userData.id, userData.name, userData.address, userData.email,
                    userData.heartRate, userData.weight, userData.sessions);
            userManager.addUser(newUser[0]);
            System.out.println("New Professional User created successfully!");
        });
        userMenu.setHandler(2, () -> {
            newUser[0] = new AmateurUser(userData.id, userData.name, userData.address, userData.email,
                    userData.heartRate, userData.weight, userData.sessions);
            userManager.addUser(newUser[0]);
            System.out.println("New Amateur User created successfully!");
        });
        userMenu.setHandler(3, () -> {
            newUser[0] = new OccasionalUser(userData.id, userData.name, userData.address, userData.email,
                    userData.heartRate, userData.weight, userData.sessions);
            userManager.addUser(newUser[0]);
            System.out.println("New Occasional User created successfully!");
        });
        userMenu.setHandler(4, () -> System.out.println("Exiting..."));

        userMenu.setTitle("Registration Menu");

        // Run the menu
        userMenu.run();
    }

    // ================= Login =================
    private void menuLogin() {
        String userId;
        boolean exists = false;

        // Display login menu
        System.out.println("===== Login =====");
        System.out.println("Enter an account");

        do {
            // Id scan
            System.out.print("Enter your id (Leave empty to return): ");

            userId = scanner.nextLine();
            if (userId.isEmpty()) {
                return;
            }

            if (userManager.containsUser(userId) == false) {
                System.out.println("This User doesn't exist!");
                System.out.println();
            } else
                exists = true;

        } while (exists == false);

        // Get the user if sucess login
        User user = this.userManager.getUser(userId);
        System.out.println();
        System.out.println("You entered your account!");
        System.out.println();
        userMenu(user);
    }

    // ================= User Menu after logging in =================
    private void userMenu(User user) {
        String[] options = {
                "Change my Name",
                "Change my Address",
                "Change my Email",
                "Change my Average Heart Rate",
                "Change my Weight",
                "My Train Sessions",
                "Delete Account",
                "Exit to Menu"
        };

        ListMenu userMenu = new ListMenu(options, false);
        userMenu.setTitle("User Profile Menu");

        // Set up the handlers for each menu option
        userMenu.setHandler(1, () -> {
            System.out.println("Write your new Name: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                user.setName(newName);
                userManager.updateUser(user);
                System.out.println("You changed your Name!");
            } else {
                System.out.println("No changes done!");
            }
        });

        userMenu.setHandler(2, () -> {
            System.out.println("Write your new Address: ");
            String newAddress = scanner.nextLine();
            if (!newAddress.isEmpty()) {
                user.setAddress(newAddress);
                userManager.updateUser(user);
                System.out.println("You changed your Address!");
            } else {
                System.out.println("No changes done!");
            }
        });

        userMenu.setHandler(3, () -> {
            System.out.println("Write your new Email: ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                user.setEmail(newEmail);
                userManager.updateUser(user);
                System.out.println("You changed your Email!");
            } else {
                System.out.println("No changes done!");
            }
        });

        userMenu.setHandler(4, () -> {
            System.out.println("Write your new Average Heart Rate: ");
            int newHeartRate = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            user.setHeartRate(newHeartRate);
            userManager.updateUser(user);
            System.out.println("You changed your Average Heart Rate!");
        });

        userMenu.setHandler(5, () -> {
            System.out.println("Write your new Weight: ");
            int newWeight = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            user.setWeight(newWeight);
            userManager.updateUser(user);
            System.out.println("You changed your Weight!");
        });

        userMenu.setHandler(6, () -> {
            userActivitiesMenu(user);
            userManager.updateUser(user);
        });

        userMenu.setHandler(7, () -> {
            System.out.println("Do You really want to delete this account? 1. Yes 2. No");
            int delete = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (delete == 1) {
                userManager.removeUser(user.getId());
                System.out.println("User deleted!");
            } else {
                System.out.println("User not Deleted!");
            }
        });

        userMenu.setHandler(8, () -> {
            System.out.println("Exiting...");
        });

        // Setting options to end after running
        userMenu.setEndOptions(7, 8);

        userMenu.setTitle("User Menu");

        // Run the menu
        userMenu.run();
    }

    // ================= User My Train Sessions Menu =================
    private void userActivitiesMenu(User user) {
        String[] options = {
                "My User Training Stats",
                "My Activities",
                "Create new Train Session",
                "Delete a Train Session",
                "Exit to Menu"
        };

        ListMenu trainSessionMenu = new ListMenu(options, false);
        trainSessionMenu.setTitle("My Train Sessions");

        trainSessionMenu.setHandler(1, () -> {
            System.out.println("== My Stats ==");
            System.out.println("Today's Date: " + this.date);
            System.out.println("My most practiced Activity: " + user.getNameMostPracticedActivity(this.date));
            System.out.println("My consumed Calories: " + user.calcUserTotalCalories(this.date));
            System.out.println("My Total Traveled Km's: " + user.getTotalDistance(this.date));
            System.out.println("My Total Meters of Altimetry: " + user.getTotalHeightMeters(this.date));
        });

        trainSessionMenu.setHandler(2, () -> {
            System.out.println(user.toStringActivities());
        });

        trainSessionMenu.setHandler(3, () -> {
            createTrainSession(user);
        });

        trainSessionMenu.setHandler(4, () -> {
            System.out.println(user.toStringSessions());
            System.out.println("Choose a Session to Delete: ");
            int session = this.scanner.nextInt();
            this.scanner.nextLine();
            if (session > 0 && session <= user.countSessions()) {
                System.out.println("Do You really want to delete Train Session " + session + "?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int delete = this.scanner.nextInt();
                this.scanner.nextLine();
                if (delete == 1) {
                    user.removeSession(session - 1);
                    System.out.println("Train Session Deleted!");
                } else {
                    System.out.println("Train Session not Deleted!");
                }
            } else {
                System.out.println("No modifications done!");
            }
        });

        trainSessionMenu.setHandler(5, () -> {
            System.out.println("Exiting...");
        });

        // Setting options to end after running
        trainSessionMenu.setEndOptions(5); // Exit after option 5

        // Run the menu
        trainSessionMenu.run();
    }

    // ================= Stats Main Menu =================
    private void displayStatsMenu() {
        String[] options = {
                "User who expended the most calories till now",
                "User who performed the most activities till now",
                "Most performed activity",
                "Most demanding training plan based on proposed calorie expenditure",
                "Return to Menu"
        };

        ListMenu statsMenu = new ListMenu(options, false);
        statsMenu.setTitle("Stats Menu");

        // Set up the handlers for each menu option
        statsMenu.setHandler(1, () -> {
            User userMostCalories = userManager.mostCaloriesUser(date);
            if (userMostCalories != null) {
                System.out.println("The user who expended the most calories is: " + userMostCalories.getId() + " - "
                        + userMostCalories.getName());
            } else {
                System.out.println("No data available.");
            }
        });

        statsMenu.setHandler(2, () -> {
            User user = userManager.getUserWithMostActivities(date);
            if (user != null) {
                System.out.println(
                        "The user who performed the most activities is: " + user.getId() + " - " + user.getName());
            } else {
                System.out.println("No data available.");
            }
        });

        statsMenu.setHandler(3, () -> {
            System.out.println("The name of the most popular activity: " + userManager.getMostPracticedActivity());
        });

        statsMenu.setHandler(4, () -> {
            TrainSession trainsession = userManager.getMostDemandingTrainingPlan();
            if (trainsession != null) {
                System.out.println(trainsession.toString());
            } else {
                System.out.println("No training sessions available.");
            }
        });

        statsMenu.setHandler(5, () -> {
            System.out.println("Returning to menu...");
        });

        // Setting options to end after running
        statsMenu.setEndOptions(5); // Return to menu should end the menu

        // Run the menu
        statsMenu.run();
    }

    // ================= Create train Session Menu =================
    private void createTrainSession(User u) {
        TrainSession newSession = new TrainSession();

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

        String[] options = {
                "Add new Activity to this Training",
                "See Training Session Stats",
                "Save and Exit",
                "Exit without Saving"
        };

        ListMenu sessionMenu = new ListMenu(options, false);

        sessionMenu.setTitle("Create a new Train Session");

        final int[] nActivities = { 0 };

        sessionMenu.setHandler(1, () -> {
            int erro = 0;
            if (nActivities[0] == 3)
                System.out.println("Can't insert more Activities!");
            else {
                // List all activities
                System.out.println("List of activities to add: ");
                StringBuilder sb = new StringBuilder();
                int i = 1;

                for (Activity activity : this.definedActivities) {
                    sb.append(i + ". ").append(activity.getName());
                    if (activity.isHard()) {
                        sb.append(" - Hard\n");
                    } else
                        sb.append(" - Normal\n");
                    i++;
                }

                System.out.println(sb);
                System.out.println("Enter your choice: ");

                // User choice
                int choice2 = this.scanner.nextInt();
                this.scanner.nextLine();

                if (choice2 > 0 && choice2 < i) {
                    double duration;
                    Activity activityToAdd = this.definedActivities.get(choice2 - 1).clone();

                    System.out.println("Write your activity duration in Hours: ");
                    duration = this.scanner.nextDouble();
                    this.scanner.nextLine();

                    // Create new activity based on type
                    if (activityToAdd.isDistanceActivity()) {
                        System.out.println("Write your activity distance in Km's: ");
                        double distance = this.scanner.nextDouble();
                        this.scanner.nextLine();

                        if (activityToAdd.getName().equals("Track Run"))
                            activityToAdd = new TrackRun(duration, distance);
                        else if (activityToAdd.getName().equals("Canoe"))
                            activityToAdd = new Canoe(duration, distance);
                        else {
                            System.out.println("Error adding new Activity");
                            erro++;
                        }
                        ;
                    } else if (activityToAdd.isRepetitionActivity()) {
                        System.out.println("Write your activity number of repetitions per set: ");
                        int reps = this.scanner.nextInt();
                        this.scanner.nextLine();
                        System.out.println("Write your activity number of sets: ");
                        int sets = this.scanner.nextInt();
                        this.scanner.nextLine();

                        if (activityToAdd.getName().equals("Sit Ups"))
                            activityToAdd = new SitUps(duration, reps, sets);
                        else if (activityToAdd.getName().equals("Push Ups"))
                            activityToAdd = new PushUps(duration, reps, sets);
                        else {
                            System.out.println("Error adding new Activity");
                            erro++;
                        }
                        ;
                    } else if (activityToAdd.isWeightActivity()) {
                        System.out.println("Write your activity number of repetitions per set: ");
                        int reps = this.scanner.nextInt();
                        this.scanner.nextLine();
                        System.out.println("Write your activity number of sets: ");
                        int sets = this.scanner.nextInt();
                        this.scanner.nextLine();
                        System.out.println("Write your activity total Weight in Kgs: ");
                        int wgt = this.scanner.nextInt();
                        this.scanner.nextLine();

                        if (activityToAdd.getName().equals("Leg Extension"))
                            activityToAdd = new LegExtension(duration, reps, sets, wgt);
                        else if (activityToAdd.getName().equals("Bench Press"))
                            activityToAdd = new BenchPress(duration, reps, sets, wgt);
                        else {
                            System.out.println("Error adding new Activity");
                            erro++;
                        }
                        ;
                    } else if (activityToAdd.isDistanceAltimetryActivity()) {
                        System.out.println("Write your activity distance in Km's: ");
                        double distance = this.scanner.nextDouble();
                        this.scanner.nextLine();
                        System.out.println("Write your activity height in Km's: ");
                        double height = this.scanner.nextDouble();
                        this.scanner.nextLine();

                        if (activityToAdd.getName().equals("Trail Run"))
                            activityToAdd = new TrailRun(duration, distance, height);
                        else if (activityToAdd.getName().equals("Mountain Bike"))
                            activityToAdd = new MountainBike(duration, distance, height);
                        else {
                            System.out.println("Error adding new Activity");
                            erro++;
                        }
                        ;
                    }
                    if (erro == 0) {
                        newSession.addActivity(activityToAdd);
                        nActivities[0]++;
                    }
                } else
                    System.out.println("Invalid choice!");
            }
        });
        sessionMenu.setHandler(2, () -> {
            System.out.println(newSession.toString());
            double totalCalories = u.multiplierCaloriesTypeUser() * newSession.calcSessionCalories();
            System.out.println("\nSession total Calories -> " + (int) totalCalories);
        });
        sessionMenu.setHandler(3, () -> {
            if (newSession.getActivitiesCount() > 0) {
                u.addSession(newSession);
            }
            System.out.println("Saving and Exiting...");
        });
        sessionMenu.setHandler(4, () -> {
            System.out.println("Exiting...");
        });

        sessionMenu.setEndOptions(3, 4);

        sessionMenu.run();
    }

    private void loadUserData() {
        File file = new File(usersFile);
        if (file.exists()) {
            try {
                userManager.loadUsers(usersFile);
                System.out.println("Users data loaded successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading users: " + e.getMessage());
            }
        } else {
            System.out.println("Users data file does not exist: " + usersFile);
        }
    }

    private void exitAndSave() {
        try {
            userManager.saveUsers(usersFile);
            System.out.println("Users data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
        System.out.println("Exiting...");
        System.exit(0);
    }

    private void viewAllUsers() {
        System.out.println();
        System.out.println(this.userManager.toString());
    }

    private void changeDate() {
        System.out.println("Program Actual Date: " + this.date);
        System.out.println("Write a date with format yyyy-MM-dd: ");
        String input = this.scanner.nextLine();

        try {
            this.date = LocalDate.parse(input);
            System.out.println("New Program Date: " + this.date);
        } catch (DateTimeParseException e) {
            System.out.println("Format incorrect. Use the format yyyy-MM-dd.");
            return;
        }
    }
}
