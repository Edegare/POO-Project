package activities;

public abstract class RepetitionActivity extends Activity {
    private int repetitions; // per set
    private int sets;
    
    //Constructors
    public RepetitionActivity(double duration, int repetitions, int sets) {
        super(duration);
        this.repetitions = repetitions;
        this.sets = sets;
    }

    public RepetitionActivity(RepetitionActivity activity) {
        super(activity);
        this.repetitions = activity.getRepetitions();
        this.sets = activity.getSets();
    }

    public RepetitionActivity() {
        super();
        this.repetitions = 0;
        this.sets = 0;
    }

    //Getters and Setters
    public int getRepetitions() {
        return this.repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getSets() {
        return this.sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    // Calculate calories method (per kg of bodyweight)
    public double calculateCalories() {

        double total = this.caloriesFactor() * ((double) (this.getRepetitions() * this.getSets()));

        return total;
    }

}
