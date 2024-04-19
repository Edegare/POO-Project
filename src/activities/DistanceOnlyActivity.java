package activities;

public class DistanceOnlyActivity extends Activity {
    private int distance;

    public DistanceOnlyActivity(String name, double durationHours, int averageHeartRate, User user) {
        super(name, durationHours, averageHeartRate, user);
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

    @Override
    public double calculateCalories(activity) {
        //total = MET x peso (kg) x duração (h).
        //MET = 10
        int total = 0;

        total = 10 * (activity.getDurationHours());
        //if (isHard) total = total * 1.5;
        return total;
    }
}