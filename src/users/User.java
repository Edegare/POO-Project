package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        else return new TrainSession();
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
        
        int i = 1;
        for (TrainSession session : this.sessions) {
            sb.append("Train Session ").append(i)
              .append(" - Realization Date: ").append(session.getDate()).append("\n");
            i++;
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
