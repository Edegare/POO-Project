package activities;

public class Canoe extends DistanceActivity {

    private final static String DEFAULT_NAME = "Canoe";
    private final double cal = 0.9;

    //Constructors
    public Canoe(double duration, double distance) {
        super(DEFAULT_NAME, duration,distance);
    }

    public Canoe() {
        super();
    }

    public Canoe(Canoe a) {
        super(a);
    }

    //getters

    public double caloriesFactor() {
        return this.cal; 
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Canoe)) return false;
        Canoe u = (Canoe) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getDistance()==u.getDistance();
    }

    //ToString
    public String toString() {
        return "Canoeing {" +
                "duration = " + getDuration() +
                ", distance = " + getDistance() + " Km}";
    }

    //Clone
    public Canoe clone() {
        return new Canoe(this);
    }
}
