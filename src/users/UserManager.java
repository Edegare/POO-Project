package users;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import activities.TrainSession;

public class UserManager implements Serializable{
    private Map<String, User> usersMap;
    
    // Constructors
    public UserManager() {
        this.usersMap = new HashMap<>();
    }

    public UserManager(Map<String, User> users) {
        this.usersMap = users.entrySet().stream()
                        .collect(HashMap::new, 
                        (map, entry) -> map.put(entry.getKey(), entry.getValue().clone()), 
                        HashMap::putAll);
    }

    //Setters & Getters
    public void setUsersMap(Map<String, User> users) {
        this.usersMap = users.entrySet().stream()
                        .collect(HashMap::new, 
                        (map, entry) -> map.put(entry.getKey(), entry.getValue().clone()), 
                        HashMap::putAll);
    }

    public Map<String, User> getUsersMap() {
        return (this.usersMap.entrySet().stream()
                .collect(Collectors
                .toMap(e->e.getKey(), e->e.getValue().clone())));
    }

    // Other methods
    // Add a user to the map
    public void addUser(User user) {
        this.usersMap.put(user.getId(), user.clone());
    }

    // Get a user from the map
    public User getUser(String userId) {
        return this.usersMap.get(userId).clone();
    }

    // Remove a user from the map
    public void removeUser(String userId) {
        this.usersMap.remove(userId);
    }

    // Check if a user exists in the map
    public boolean containsUser(String userId) {
        return this.usersMap.containsKey(userId);
    }

    // Get the number of users
    public int getUserCount() {
        return this.usersMap.size();
    }

    // Update user info
    public void updateUser(User userUpdated) {
        String userId = userUpdated.getId();

        if (this.usersMap.containsKey(userId)) {
            this.usersMap.put(userId, userUpdated);
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    // Get user with most calories consumed till a date
    public User mostCaloriesUser(LocalDate date) {
        User mostCaloriesUser = null;
        double maxCalories = Double.MIN_VALUE;


        for (User user : usersMap.values()) {
            double totalCalories = user.calcUserTotalCalories(date);

            if (totalCalories > maxCalories) {
                maxCalories = totalCalories;
                mostCaloriesUser = user;
            }
        }
        return mostCaloriesUser;
    }

    //Get a user with the most activities till a date
    public User getUserWithMostActivities(LocalDate date) {
        User userWithMostActivities = null;
        int maxActivities = 0;

        for (User user : usersMap.values()) {
            int activityCount = user.countTotalActivities(date);
            
            if (activityCount > maxActivities) {
                maxActivities = activityCount;
                userWithMostActivities = user;
            }
        }

        return userWithMostActivities; // may return null if the map is empty
    }

    //Get the most practiced activity type
    public String getMostPracticedActivity(LocalDate date) {
        Map<String, Integer> activityCountMap = new HashMap<>();

        for (User user : usersMap.values()) {
            String mostPracticedActivity = user.getNameMostPracticedActivity(date);
            activityCountMap.put(mostPracticedActivity, activityCountMap.getOrDefault(mostPracticedActivity, 0) + 1);
        }

        return activityCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null); // In case there are no activities.
    }

    //Get the most demanding training plan
    public TrainSession getMostDemandingTrainingPlan() {
        TrainSession mostDemandingPlan = null;
        double highestCalories = 0;

        for (User user : usersMap.values()) {
            for (TrainSession session : user.getSessions()) {
                double sessionCalories = user.calcSessionCalories(user.getSessions().indexOf(session));
                if (sessionCalories > highestCalories) {
                    highestCalories = sessionCalories;
                    mostDemandingPlan = session;
                }
            }
        }

        return mostDemandingPlan; // Can be null if no sessions are found.
    } 
    
    // Serialization (Save and load users)
    public void saveUsers(String path) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);){
            out.writeObject(this.usersMap);
            fileOut.close();
        }
    }   

    @SuppressWarnings("unchecked")
    public void loadUsers(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);) {
            this.usersMap = (Map<String,User>) in.readObject();
        }
    }

    //toString
    public String toString() {
        String allUsers = this.usersMap.values().stream()
                .map(user->user.toString())
                .collect(Collectors.joining("\n"));
    
        return "All Users Registered:\n" + allUsers;
    }
    

    //Clone
    public UserManager clone() {
        UserManager managerClone = new UserManager();

        
        managerClone.usersMap = this.usersMap.entrySet().stream()
                                .collect(Collectors
                                .toMap(e->e.getKey(), e->e.getValue().clone()));

        return managerClone;
    }

}
