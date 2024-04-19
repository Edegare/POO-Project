package activities;

public abstract class Activity {
    private String name;
    private double durationHours;


    public Activity(String name, double durationHours) {
        this.name = name;
        this.durationHours = durationHours;
    }

    public Activity(Activity a) {
        this.name = a.getName();
        this.durationHours = a.getDurationHours();
    }

    public Activity() {
        this.name = "";
        this.durationHours = 0;

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

    //Equals 
    //public abstract boolean equals(Object obj);

    //Clone 
    //public abstract Activity clone();

    //ToString
    //public abstract toString clone();

    //public abstract void calculateCalories();
}