package activities;

public class TrailRun extends DistanceAltimetryActivity {

    private static String name = "Trail Run";
    private static double kcal = 1.3;

    public TrailRun(double duration, int distance, int height) {
        super(duration,distance,height);
    }

    public String getName() {
        return TrailRun.name;
    }

    public double standardCalories() {
        return TrailRun.kcal; //kcal per (km * weight)
    }

    //ToString
    public String toString() {
        return "Trail Run {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", distance = " + getDistance() + " Km" +
                ", height = " + getHeight() + " Km}";
    }
}
