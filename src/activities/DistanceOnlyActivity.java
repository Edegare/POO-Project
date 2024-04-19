package activities;

public class DistanceOnlyActivity extends Activity {
    private int distance;

    public DistanceOnlyActivity(String name, double durationHours, int distance) {
        super(name, durationHours);
        this.distance = distance;
    }

    public DistanceOnlyActivity(DistanceOnlyActivity activity) {
        super(activity);
        this.distance = activity.getDistance();
    }

    public DistanceOnlyActivity() {
        super();
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double calculateCalories() {
        int total = 0;

        return total;
    }
}