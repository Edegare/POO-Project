package activities;

public class RepetitionActivity extends Activity {
    private int repetitions;

    public RepetitionActivity(String name, double durationHours, int averageHeartRate, User user, int repetitions) {
        super(name, durationHours, averageHeartRate, user);
        this.repetitions = repetitions;
    }

    public RepetitiveActivity(RepetitiveActivity activity) {
        super(activity);
        this.repetitions = activity.getRepetitions();
    }

    public RepetitiveActivity() {
        super();
        this.repetitions = 0;
    }

    public int getRepetitions() {
        return this.repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    @Override
    public double calculateCalories() {
        int total = 0;


        //if (isHard) total = total * 1.5;
        return total;
    }
}
