package activities;

public class DistanceActivity extends Activity {
    private int distance;

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