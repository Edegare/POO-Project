package activities;

public abstract class DistanceActivity extends Activity {
    private int distance;

    //Constructors
    public DistanceActivity(String name, double durationHours, int distance) {
        super(name, durationHours);
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
    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    // Calculate calories method
    public double calculateCalories() {
        double total = 0;

        return total;
    }

    public abstract double standartCalories();
}