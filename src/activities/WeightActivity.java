package activities;

public abstract class WeightActivity extends Activity {
    private int repetitionsPerSet;
    private int sets;
    private int weight;

    //Constructors
    public WeightActivity(String name, double durationHours, int repetitionsPerSet, int sets, int weight) {
        super(name, durationHours);
        this.repetitionsPerSet = repetitionsPerSet;
        this.sets = sets;
        this.weight = weight;
    }

    public WeightActivity(WeightActivity activity) {
        super(activity);
        this.repetitionsPerSet = activity.getRepetitionsPerSet();
        this.sets = activity.getSets();
        this.weight = activity.getWeight();
    }
    
    public WeightActivity() {
        super();
        this.repetitionsPerSet = 0;
        this.sets = 0;
        this.weight = 0;
    }

    //Getters and Setters
    public int getRepetitionsPerSet() {
        return this.repetitionsPerSet;
    }
    
    public void setRepetitionsPerSet(int repetitionsPerSet) {
        this.repetitionsPerSet = repetitionsPerSet;
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
        double total = 0;



        return total;
    }

    public abstract double standartCalories();
}
