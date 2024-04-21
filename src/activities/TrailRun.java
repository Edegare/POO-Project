package activities;

public class TrailRun extends DistanceAltimetryActivity {

    private final String name = "Trail Run";
    private final double cal = 1.3;

    //Constructors
    public TrailRun(double duration, double distance, double height) {
        super(duration,distance, height);
    }

    public TrailRun() {
        super();
    }

    public TrailRun(TrailRun a) {
        super(a);
    }

    //getters
    public String getName() {
        return this.name;
    }

    public double caloriesFactor() {
        return this.cal; //cal per (km * weight)
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TrailRun)) return false;
        TrailRun u = (TrailRun) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getDistance()==u.getDistance() &&
               this.getHeight()==u.getHeight();
    }

    //ToString
    public String toString() {
        return "Track Run {" +
                "duration = " + getDuration() +
                ", distance = " + getDistance() + " Km" +
                ", height = " + getHeight() + " Km";
    }

    //clone
    public TrailRun clone() {
        return new TrailRun(this);
    }
}
