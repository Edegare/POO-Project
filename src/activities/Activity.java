package activities;

public abstract class Activity {
    private String name;
    private double duration; //Seconds


    public Activity(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public Activity(Activity a) {
        this.name = a.getName();
        this.duration = a.getDuration();
    }

    public Activity() {
        this.name = "";
        this.duration = 0;

    }

    //Getters & Setters
    public String getName() {
        return this.name;
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
    //public abstract Activity clone();

    //ToString
    //public abstract toString clone();

    //public abstract void calculateCalories();
}