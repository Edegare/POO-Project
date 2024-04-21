package activities;

public class Canoe extends DistanceActivity {

    private static String name = "Canoe";
    private static double kcal = 4.0;

    public StreetRun(double duration, int distance) {
        super(duration,distance);
    }

    public String getName() {
        return Canoe.name;
    }

    public double standardCalories() {
        return Canoe.kcal; //kcal per (km * weight)
    }

    //ToString
    public String toString() {
        return "Canoeing {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", distance = " + getDistance() + " Km}";
    }

}
