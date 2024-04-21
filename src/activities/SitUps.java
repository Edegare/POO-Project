package activities;

public class SitUps extends RepetitionActivity{

    private static String name = "Sit Ups";
    private static double kcal = 0.2;

    public StreetRun(double duration, int repetitions, int set) {
        super(duration,repetitions, set);
    }

    public String getName() {
        return SitUps.name;
    }

    public double standardCalories() {
        return SitUps.kcal; //kcal per (repetitions * sets)
    }

    public String toString() {
        return "Sit Ups {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() + '}';
    }
}