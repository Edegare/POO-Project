package activities;

public class RepetitionActivity extends Activity {
    private int repetitions;

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

    public int getRepetitions() {
        return this.repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }


    public double calculateCalories() {
        int total = 0;

        return total;
    }
}
