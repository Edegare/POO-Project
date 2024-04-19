package activities;

public class Activity {
    private String name;
    private double durationHours;
    private double averageHeartRate;
    private User user;
    //private Boolean isHard;

    public Activity(String name, double durationHours, int averageHeartRate, User user) {
        this.name = name;
        this.durationHours = durationHours;
        this.averageHeartRate = averageHeartRate;
        this.user = user;
        //this.isHard = isHard;
    }

    public Activity(Activity a) {
        this.name = a.getName();
        this.durationHours = a.getDurationHours();
        this.averageHeartRate = a.getAverageHeartRate();
        this.user = a.getUser();
        //this.isHard = a.getIsHard();
    }

    public Activity() {
        this.name = "";
        this.durationHours = 0;
        this.averageHeartRate = 0;
        this.user = "";
        //this.isHard = null;
    }

    //Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDurationHours() {
        return this.durationHours;
    }

    public void setDurationHours(double durationHours) {
        this.durationHours = durationHours;
    }

    public double getAverageHeartRate() {
        return this.averageHeartRate;
    }

    public void setAverageHeartRate(int averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //public boolean getIsHard() {
    //    return this.isHard;
    //}
    //public void setIsHard(boolean isHard) {
    //    this.isHard = isHard;
    //}
}