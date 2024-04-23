package activities;

public class SitUps extends RepetitionActivity{

    private final static String DEFAULT_NAME = "Sit Ups";
    private final double cal = 0.09;

    //Constructors
    public SitUps(double duration, int repetitions, int set) {
        super(DEFAULT_NAME,duration,repetitions, set);
    }

    public SitUps() {
        super();
    }

    public SitUps(SitUps a) {
        super(a);
    }
    
    //getters

    public double caloriesFactor() {
        return this.cal; 
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SitUps)) return false;
        SitUps u = (SitUps) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getRepetitions()==u.getRepetitions();
    }

    //tostring
    public String toString() {
        return "Sit Ups {" +
                "duration = " + getDuration() +
                ", repetitions = " + getRepetitions() +
                ", sets = " + getSets() + '}';
    }

    //clone
    public SitUps clone() {
        return new SitUps(this);
    }
}