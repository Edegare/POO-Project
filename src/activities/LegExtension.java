package activities;

public class LegExtension extends WeightActivity{

    private final String name = "Leg Extension";
    private final double cal = 0.002;

    //Constructors
    public LegExtension(double duration, int repetitions, int sets, int weight) {
        super(duration,repetitions,sets,weight);
    }
    
    public LegExtension() {
        super();
    }

    public LegExtension(LegExtension a) {
        super(a);
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
        if (!(obj instanceof LegExtension)) return false;
        LegExtension u = (LegExtension) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getRepetitions()==u.getRepetitions() &&
               this.getSets()==u.getSets() &&
               this.getWeight()==u.getWeight();
    }

    //tostring
    public String toString() {
        return "Leg Extensions {" +
                "duration = " + getDuration() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() +
                ", weight = " + getWeight() + " Kg}";
    }

    //clone
    public LegExtension clone(){
        return new LegExtension(this);
    }
}
