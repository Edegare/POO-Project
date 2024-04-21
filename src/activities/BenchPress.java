package activities;

public class BenchPress extends WeightActivity{

    private static String name = "Bench Press";
    private static double kcal = 1.0;

    public BenchPress(double duration, int repetitions, int sets, int weight) {
        super(duration,repetitions,sets,weight);
    }

    public String getName() {
        return BenchPress.name;
    }

    public double standardCalories() {
        return BenchPress.kcal; //kcal per (repetitions * sets * weight)
    }

    public String toString() {
        return "Bench Press {" +
                "duration = " + getDuration() +
                ", average heart rate = " + getHeartRate() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() +
                ", weight = " + getWeight() + " Kg}";
    }
}