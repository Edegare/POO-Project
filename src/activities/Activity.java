package activities;

public class Activity {
    private String name;
    private double durationHours;
    private double averageHeartRate;
    private User user;
    private Boolean isHard;

    public Activity(String name, double durationHours, int averageHeartRate, User user, Boolean isHard) {
        this.name = name;
        this.durationHours = durationHours;
        this.averageHeartRate = averageHeartRate;
        this.user = user;
        this.isHard = isHard;
    }

    public Activity(Activity a) {
        this.name = a.getName();
        this.durationHours = a.getDurationHours();
        this.averageHeartRate = a.getAverageHeartRate();
        this.user = a.getUser();
        this.isHard = a.getIsHard();
    }

    public Activity() {
        this.name = "";
        this.durationHours = 0;
        this.averageHeartRate = 0;
        this.user = "";
        this.isHard = null;
    }

    //Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDurationHours() {
        return this.durationHours;
    }

    public void setDurationHours(double durationHours) {
        this.durationHours = durationHours;
    }

    public double getAverageHeartRate() {
        return this.averageHeartRate;
    }

    public void setAverageHeartRate(int averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getIsHard() {
        return this.isHard;
    }

    public void setIsHard(boolean isHard) {
        this.isHard = isHard;
    }

    //public double calculateCalories() {
    //    // Implementação do cálculo de calorias genérico para uma atividade
    //    
    //    return 0;
    //}
}

public class DistanceAndElevationActivity extends Activity {
    private int distance;
    private int elevation;

    public DistanceAndElevationActivity(String name, double durationHours, int averageHeartRate, User user, boolean isHard) {
        super(name, durationHours, averageHeartRate, user, isHard);
        this.distance = distance;
        this.elevation = elevation;
    }

    public DistanceAndElevationActivity(DistanceAndElevationActivity activity) {
        super(activity);
        this.distance = activity.getDistance();
        this.elevation = activity.getElevation();
    }

    public DistanceAndElevationActivity() {
        super();
        this.distance = 0;
        this. elevation = 0;
    }

    public int getElevation() {
        return this.elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public double calculateCalories() {
        int total = 0;

        

        if (isHard) total = total * 1.5;

        return total;
    }
}

public class DistanceOnlyActivity extends Activity {
    private int distance;

    public DistanceOnlyActivity(String name, double durationHours, int averageHeartRate, User user, Boolean isHard) {
        super(name, durationHours, averageHeartRate, user, isHard);
        this.distance = distance;
    }

    public DistanceOnlyActivity(DistanceOnlyActivity activity) {
        super(activity);
        this.distance = activity.getDistance();
    }

    public DistanceOnlyActivity() {
        super();
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public double calculateCalories() {
        int total = 0;


        if (isHard) total = total * 1.5;

        return total;
    }
}

public class RepetitionActivity extends Activity {
    private int repetitions;

    public RepetitionActivity(String name, double durationHours, int averageHeartRate, User user, Boolean isHard, int repetitions) {
        super(name, durationHours, averageHeartRate, user, isHard);
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


        if (isHard) total = total * 1.5;

        return total;
    }
}

public class WeightliftingActivity extends Activity {
    private int repetitionsPerSet;
    private int sets;
    private int weight; //weight ou weightKg

    public WeightliftingActivity(String name, double durationHours, int averageHeartRate, User user, Boolean isHard , int repetitionsPerSet, int sets, int weight) {
        super(name, durationHours, averageHeartRate, user, isHard);
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


        if (isHard) total = total * 1.5;

        return total;
    }
}
