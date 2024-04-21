package activities;


public abstract class DistanceActivity extends Activity {
    private double distance; //Kms

    //Constructors
    public DistanceActivity(double duration, double distance) {
        super(duration);
        this.distance = distance;
    }

    public DistanceActivity(DistanceActivity activity) {
        super(activity);
        this.distance = activity.getDistance();
    }

    public DistanceActivity() {
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

    // Calculate calories method
    public double calculateCalories() {

        double total = this.caloriesFactor() * this.getDistance();

        return total;
    }

}