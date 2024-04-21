package activities;

public class PushUps extends RepetitionActivity{

    private static String name = "Push Ups";
    private static double kcal = 0.4;

    public StreetRun(double duration, int repetitions, int set) {
        super(duration,repetitions, set);
    }

    public String getName() {
        return PushUps.name;
    }

    public double standardCalories() {
        return PushUps.kcal; //kcal per (repetitions * sets)
    }

    public String toString() {
        return "Push Ups {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() + '}';
    }
}