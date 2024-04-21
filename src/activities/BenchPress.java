package activities;

public class BenchPress extends WeightActivity{

    private final String name = "Bench Press";
    private final double cal = 0.005;

    //Constructors
    public BenchPress(double duration, int repetitions, int sets, int weight) {
        super(duration,repetitions,sets,weight);
    }

    public BenchPress(BenchPress a) {
        super(a);
    }
    
    public BenchPress() {
        super();
    }

    //getters
    public String getName() {
        return this.name;
    }

    public double caloriesFactor() {
        return this.cal; 
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BenchPress)) return false;
        BenchPress u = (BenchPress) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getRepetitions()==u.getRepetitions() &&
               this.getSets()==u.getSets() &&
               this.getWeight()==u.getWeight();
    }

    //tostring
    public String toString() {
        return "Bench Press {" +
                "duration = " + getDuration() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() +
                ", weight = " + getWeight() + " Kg}";
    }

    //clone
    public BenchPress clone() {
        return new BenchPress(this);
    }
}