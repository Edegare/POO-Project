package activities;

public class TrackRun extends DistanceActivity {

    private static String name = "Track Run";
    private static double kcal = 1.0;

    public TrackRun(double duration, int distance) {
        super(duration,distance);
    }

    public String getName() {
        return TrackRun.name;
    }

    public double standardCalories() {
        return TrackRun.kcal; //kcal per (km * weight)
    }

    //ToString
    public String toString() {
        return "Track Run {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", distance = " + getDistance() + " Km}";
    }

}

