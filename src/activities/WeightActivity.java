package activities;

public abstract class WeightActivity extends Activity {
    private int repetitions; //per set
    private int sets;
    private int weight;

    //Constructors
    public WeightActivity(String name, double duration, int repetitions, int sets, int weight) {
        super(name, duration);
        this.repetitions = repetitions;
        this.sets = sets;
        this.weight = weight;
    }

    public WeightActivity(WeightActivity activity) {
        super(activity);
        this.repetitions = activity.getRepetitions();
        this.sets = activity.getSets();
        this.weight = activity.getWeight();
    }
    
    public WeightActivity() {
        super();
        this.repetitions = 0;
        this.sets = 0;
        this.weight = 0;
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

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    // Calculate calories method
    public double calculateCalories() {

        double total = this.caloriesFactor() * ((double) (this.repetitions * this.sets * this.weight)); 
        return total;
    }

}