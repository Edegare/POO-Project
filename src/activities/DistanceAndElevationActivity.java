package activities;

public class DistanceAndElevationActivity extends Activity {
    private int distance;
    private int elevation;

    public DistanceAndElevationActivity(String name, double durationHours, int distance, int elevation) {
        super(name, durationHours);
        this.distance = distance;
        this.elevation = elevation;
    }

    public DistanceAndElevationActivity(DistanceAndElevationActivity activity) {
        super(activity);
        this.distance = activity.getDistance();
        this.elevation = activity.getElevation();
    }

    public DistanceAndElevationActivity() {
        super();
        this.distance = 0;
        this. elevation = 0;
    }

    public int getElevation() {
        return this.elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
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
