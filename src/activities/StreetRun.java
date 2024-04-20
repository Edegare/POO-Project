package activities;

public class StreetRun extends DistanceAltimetryActivity {

    private static String name = "Street Run";
    private static double kcal = 1;  

    public StreetRun(double duration, int distance, int height) {
        super(duration,distance,height);
    }

    public String getName() {
        return StreetRun.name;
    }

    public double standartCalories() {
        return StreetRun.kcal; //kcal per (km * weight)
    }

    
    
}
