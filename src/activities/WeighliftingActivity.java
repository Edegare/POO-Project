package activities;

public class WeightliftingActivity extends Activity {
    private int repetitionsPerSet;
    private int sets;
    private int weight; //weight ou weightKg

    public WeightliftingActivity(String name, double durationHours, int averageHeartRate, User user, int repetitionsPerSet, int sets, int weight) {
        super(name, durationHours, averageHeartRate, user);
        this.repetitionsPerSet = repetitionsPerSet;
        this.sets = sets;
        this.weightKg = weight;
    }

    public WeightliftingActivity(WeightliftingActivity activity) {
        super(activity);
        this.repetitionsPerSet = activity.getRepetitionsPerSet();
        this.sets = activity.getSets();
        this.weightKg = activity.getWeightKg();
    }
    
    public WeightliftingActivity() {
        super();
        this.repetitionsPerSet = 0;
        this.sets = 0;
        this.weightKg = 0;
    }

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

    public void setWeightKg(int weight) {
        this.weightKg = weight;
    }

    @Override
    public double calculateCalories() {
        int total = 0;


        //if (isHard) total = total * 1.5;
        return total;
    }
}
