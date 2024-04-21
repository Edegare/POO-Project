package activities;

public class PushUps extends RepetitionActivity{

    private final String name = "Push Ups";
    private final double cal = 0.1;

    //Constructors
    public PushUps(double duration, int repetitions, int set) {
        super(duration,repetitions, set);
    }

    public PushUps() {
        super();
    }

    public PushUps(PushUps a) {
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
        if (!(obj instanceof PushUps)) return false;
        PushUps u = (PushUps) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getRepetitions()==u.getRepetitions();
    }

    //Tostring
    public String toString() {
        return "Push Ups {" +
                "duration = " + getDuration() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() + '}';
    }

    //clone
    public PushUps clone() {
        return new PushUps(this);
    }
}