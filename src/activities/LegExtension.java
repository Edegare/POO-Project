package activities;

public class LegExtension extends WeightActivity{

    private static String name = "Leg Extension";
    private static double kcal = 1.0;

    public LegExtension(double duration, int repetitions, int sets, int weight) {
        super(duration,repetitions,sets,weight);
    }

    public String getName() {
        return LegExtension.name;
    }

    public double standardCalories() {
        return LegExtension.kcal; //kcal per (repetitions * sets * weight)
    }

    public String toString() {
        return "Leg Extensions {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() +
                ", weight = " + getWeight() + " Kg}";
    }
}
