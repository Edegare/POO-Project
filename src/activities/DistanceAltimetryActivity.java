package activities;

public class DistanceAltimetryActivity extends Activity {
    private int distance;

    public DistanceAltimetryActivity(String name, double durationHours, int distance) {
        super(name, durationHours);
        this.distance = distance;
    }

    public DistanceAltimetryActivity(DistanceAltimetryActivity activity) {
        super(activity);
        this.distance = activity.getDistance();
    }

    public DistanceAltimetryActivity() {
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
