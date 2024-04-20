package users;

import java.io.Serializable;

public abstract class User implements Serializable{
    private String id;
    private String name;
    private String address;
    private String email;
    private int heartRate; //BPM
    private int weight; //Kg
    //private List<Activity> activities;
    //private List<TrainSession> sessions; 

    public User(String id, String name, String address, String email, int heartRate, int weight) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.heartRate = heartRate;
        this.weight = weight;
    }

    public User(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.address = u.getAddress();
        this.email = u.getEmail();
        this.heartRate = u.getHeartRate();
        this.weight = u.getWeight();
    }

    public User() {
        this.id = "";
        this.name = "";
        this.address = "";
        this.email = "";
        this.heartRate = 0;
        this.weight = 0;
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

    //Other methods
    //Calculate a heart rate factor to help calculate calories
    public double heartRateFactor() {
        return (1.0 + (double)heartRate * 0.01);
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
                this.weight == u.weight;
    }

    // ToString 
    public String toString() {
        return "User with id '" + this.id + "\' {" +
                "name='" + this.name + '\'' +
                ", address='" + this.address + '\'' +
                ", email='" + this.email + '\'' +
                ", heartRate= " + this.heartRate + " BPM" + 
                ", weight= " + this.weight + " Kg}";
    }

    public String toStringProfile() {
        return "User Profile:\n" + 
                "ID = '" + this.id + "\'\n" +
                "Name = '" + this.name + "\'\n" +
                "Address = '" + this.address + "\'\n" +
                "Email = '" + this.email + "\'\n" +
                "Average Heart Rate= " + this.heartRate + " BPM\n" +
                "Weight= " + this.weight + " Kg";
    }

    //Clone
    public abstract User clone();
    //Multiplier based on each type of user
    public abstract double multiplierCaloriesTypeUser();
}
