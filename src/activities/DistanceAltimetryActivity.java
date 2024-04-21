package activities;

public abstract class DistanceAltimetryActivity extends Activity {
    private double distance; //Kms
    private double height; //kms

    //Constructors
    public DistanceAltimetryActivity(double duration, double distance, double height) {
        super(duration);
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
    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Calculate calories method
    public double calculateCalories() {
        
        double total = this.caloriesFactor() * (this.distance + this.height);

        return total;
    }

}
