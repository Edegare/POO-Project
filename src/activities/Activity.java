package activities;

public abstract class Activity {
    private double duration; //Hours


    public Activity(double duration) {
        this.duration = duration;
    }

    public Activity(Activity a) {
        this.duration = a.getDuration();
    }

    public Activity() {
        this.duration = 0;
    }

    //Getters & Setters

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

    // Calculate calories method based on activity attributes
    public abstract double calculateCalories();

    // Standart calories per hour fo activity
    public abstract double standartCalories();
}