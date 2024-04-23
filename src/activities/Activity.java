package activities;

import java.io.Serializable;

public abstract class Activity implements Serializable{
    private String name;
    private double duration; //Hours

    public Activity(String name, double duration) {
        this.duration = duration;
    }

    public Activity(Activity a) {
        this.name = a.getName();
        this.duration = a.getDuration();
    }

    public Activity() {
        this.duration = 0;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    //Equals 
    //public abstract boolean equals(Object obj);

    //Clone 
    public abstract Activity clone();

    //ToString
    public abstract String toString();

    // Calculate calories method based on activity attributes
    public abstract double calculateCalories();

    // Standart calories per hour of activity
    public abstract double caloriesFactor();
}