package activities;

public class MountainBike extends DistanceAltimetryActivity {

    private final static String DEFAULT_NAME = "Mountain Bike";
    private final double cal = 1.2;

    //Constructors
    public MountainBike(double duration, double distance, double height) {
        super(DEFAULT_NAME, duration,distance,height);
    }

    public MountainBike() {
        super();
    }

    public MountainBike(MountainBike a) {
        super(a);
    }

    //getters
    public double caloriesFactor() {
        return this.cal; 
    }
    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MountainBike)) return false;
        MountainBike u = (MountainBike) obj;
        return this.getName().equals(u.getName()) &&
               this.getDuration()==u.getDuration() &&
               this.getDistance()==u.getDistance() &&
               this.getHeight()==u.getHeight();
    }
    
    //ToString
    public String toString() {
        return "Mountain Biking {" +
                "duration = " + getDuration() +
                ", distance = " + getDistance() + " Km" +
                ", height = " + getHeight() + " Km}";
    }

    //Clone
    public MountainBike clone() {
        return new MountainBike(this);
    }
}
