package activities;

public abstract class DistanceAltimetryActivity extends Activity {
    private int distance;
    private int height; 

    //Constructors
    public DistanceAltimetryActivity(String name, double durationHours, int distance, int height) {
        super(name, durationHours);
        this.distance = distance;
        this.height = height;
    }

    public DistanceAltimetryActivity(DistanceAltimetryActivity activity) {
        super(activity);
        this.distance = activity.getDistance();
        this.height = activity.getHeight();
    }

    public DistanceAltimetryActivity() {
        super();
        this.distance = 0;
    }

    //Getters and Setters
    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    // Calculate calories method
    public double calculateCalories() {

        double mediumSpeed = (this.getDistance() + this.getHeight())/this.getDuration();
        
        double total = this.standartCalories() * this.getDuration() * (mediumSpeed);

        return total;
    }

    public abstract double standartCalories();
}
