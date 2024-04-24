package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import activities.Activity;
import activities.TrainSession;

public abstract class User implements Serializable{
    private String id;
    private String name;
    private String address;
    private String email;
    private int heartRate; //BPM
    private int weight; //Kg
    private List<TrainSession> sessions; 

    public User(String id, String name, String address, String email, int heartRate, int weight, List<TrainSession> sessions) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.heartRate = heartRate;
        this.weight = weight;
        this.sessions = sessions.stream().map(t->t.clone()).toList();
    }

    public User(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.address = u.getAddress();
        this.email = u.getEmail();
        this.heartRate = u.getHeartRate();
        this.weight = u.getWeight();
        this.sessions = u.getSessions();
    }

    public User() {
        this.id = "";
        this.name = "";
        this.address = "";
        this.email = "";
        this.heartRate = 0;
        this.weight = 0;
        this.sessions = new ArrayList<>();
    }

    //Getters & Setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeartRate() {
        return this.heartRate;
    }
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getWeight() {
        return this.weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<TrainSession> getSessions() {
        return this.sessions.stream()
               .map(t->t.clone()).toList();
    }

    //Other methods
    //Calculate a heart rate factor to help calculate calories
    public double heartRateFactor() {
        return (1.0 + (double)heartRate * 0.01);
    }


    // Calculate total calories of an user till a date
    public double calcUserTotalCalories(LocalDate date) {
        double totalCalories = 0.0;


        for (TrainSession session : sessions) {
 
            LocalDate sessionDate = session.getDate();


            if (!sessionDate.isAfter(date)) {
                double sessionCalories = session.calcSessionCalories();
                totalCalories += sessionCalories;
            }
        }

        return totalCalories;
    }


    //Calculate a Train Session with index i expected Calories
    public double calcSessionCalories(int i) {
        if (i<0 || i>=this.countSessions()) return -1;

        TrainSession mySession = getSession(i);
        double userFactor = this.multiplierCaloriesTypeUser();
        double sessionFactor = mySession.calcSessionCalories();

        double total = userFactor * sessionFactor;

        return total;
    }
    
    //Calculate an Activity with index i expected Calories
    public double calcActivityCalories (TrainSession session, int i) {
        if (i>=session.getActivitiesCount()||i<0) return -1;

        double activityFactor = session.getActivityCaloriesFactor(i); 
        double userFactor = this.multiplierCaloriesTypeUser();
        

        double total = userFactor * activityFactor;

        return total;
    }

    // Add session
    public void addSession(TrainSession session) {
        this.sessions.add(session.clone());
    }

    // Remove Session in index i
    public void removeSession(int i) {
        if (i >= 0 && i < this.sessions.size()) {
            this.sessions.remove(i);
        }
    }

    //Get the session in index i
    public TrainSession getSession(int i) {
        if (i >= 0 && i < this.sessions.size()) {
            return this.sessions.get(i).clone();
        }
        else return null;
    }

    // Get number of sessions of an user
    public int countSessions () {
        return this.sessions.size();
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User u = (User) obj;
        return this.id.equals(u.id) &&
                this.name.equals(u.name) &&
                this.address.equals(u.address) &&
                this.email.equals(u.email) &&
                this.heartRate == u.heartRate &&
                this.weight == u.weight &&
                this.sessions.equals(u.sessions);
    }

    // ToString 
    public String toStringSessions() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train Sessions:\n");
        if (this.sessions.isEmpty()) {
            sb.append("No activities recorded.\n");
        }
        else {
            int i = 1;
            for (TrainSession session : this.sessions) {
                sb.append("Train Session ").append(i)
                .append(" - Realization Date: ").append(session.getDate()).append("- Expected Calories: ").append(this.calcSessionCalories(i-1)).append("\n");
                i++;
            }
        }
        
        return sb.toString();
    }

    public String toStringActivities() {
        StringBuilder sb = new StringBuilder();
        if (this.sessions.isEmpty()) {
            sb.append("No activities recorded.\n");
        }
        else {
            sb.append("All Activities:\n");
            
            int i = 1;
            for (TrainSession session : this.sessions) {
                sb.append("Train Session ").append(i).append(" - Realization Date: ").append(session.getDate()).append("\n");
                int j = 1;
                for (Activity activity : session.getActivitiesList()) {
                    double calories = calcActivityCalories(session, j - 1);
                    sb.append("\tActivity ").append(j).append(": ").append(activity.toString()).append(" - Expected Calories: ").append(calories).append("\n");
                    j++;
                }
                i++;
            }
        }
        return sb.toString();
    }

    public abstract String toString();
    public abstract String toStringProfile() ;
    //Clone
    public abstract User clone();
    //Multiplier based on each type of user
    public abstract double multiplierCaloriesTypeUser();
}
