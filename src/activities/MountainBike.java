package activities;

public class MountainBike extends DistanceAltimetryActivity {

    private static String name = "Mountain Bike";
    private static double kcal = 1.5;

    public MountainBike(double duration, int distance, int height) {
        super(duration,distance,height);
    }

    public String getName() {
        return MountainBike.name;
    }

    public double standardCalories() {
        return MountainBike.kcal; //kcal per (km * weight)
    }

    //ToString
    public String toString() {
        return "Mountain Biking {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", distance = " + getDistance() + " Km" +
                ", height = " + getHeight() + " Km}";
    }
}
