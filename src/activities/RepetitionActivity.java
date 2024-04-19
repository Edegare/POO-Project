package activities;

public abstract class RepetitionActivity extends Activity {
    private int repetitions;

    //Constructors
    public RepetitionActivity(String name, double durationHours, int repetitions) {
        super(name, durationHours);
        this.repetitions = repetitions;
    }

    public RepetitionActivity(RepetitionActivity activity) {
        super(activity);
        this.repetitions = activity.getRepetitions();
    }

    public RepetitionActivity() {
        super();
        this.repetitions = 0;
    }

    //Getters and Setters
    public int getRepetitions() {
        return this.repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    // Calculate calories method
    public double calculateCalories() {
        double total = 0;

        return total;
    }

    public abstract double standartCalories();
}
