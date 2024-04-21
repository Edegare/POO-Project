package activities;

public class TrackRun extends DistanceActivity {

    private final String name = "Track Run";
    private final double cal = 1.0;

    //Constructors
    public TrackRun(double duration, double distance) {
        super(duration,distance);
    }

    public TrackRun() {
        super();
    }

    public TrackRun(TrackRun a) {
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
        if (!(obj instanceof TrackRun)) return false;
        TrackRun u = (TrackRun) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getDistance()==u.getDistance();
    }

    //ToString
    public String toString() {
        return "Track Run {" +
                "duration = " + getDuration() +
                ", distance = " + getDistance() + " Km}";
    }

    //clone
    public TrackRun clone() {
        return new TrackRun(this);
    }
}

