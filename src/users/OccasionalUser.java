package users;

import java.util.List;

import activities.TrainSession;

public class OccasionalUser extends User {
    
    public OccasionalUser(String id, String name, String address, String email, int heartRate, int weight, List<TrainSession> sessions) {
        super(id, name, address, email, heartRate, weight, sessions);
    }

    public OccasionalUser(User u) {
        super(u);
    }

    public OccasionalUser() {
        super();
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OccasionalUser)) return false;
        OccasionalUser u = (OccasionalUser) obj;
        return this.getId().equals(u.getId()) &&
                this.getName().equals(u.getName()) &&
                this.getAddress().equals(u.getAddress()) &&
                this.getEmail().equals(u.getEmail()) &&
                this.getHeartRate() == u.getHeartRate() &&
                this.getWeight() == u.getWeight();
    }

    // ToString 
    public String toString() {
        return "Occasional User with id '" + this.getId() + "\' {" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", heartRate= " + this.getHeartRate() + " BPM" + 
                ", weight= " + this.getWeight() + " Kg}";
    }

    public String toStringProfile() {
        return "User Profile:\n" +
                "Type: 'Occasional'\n" + 
                "ID = '" + this.getId() + "\'\n" +
                "Name = '" + this.getName() + "\'\n" +
                "Address = '" + this.getAddress() + "\'\n" +
                "Email = '" + this.getEmail() + "\'\n" +
                "Average Heart Rate= " + this.getHeartRate() + " BPM\n" +
                "Weight= " + this.getWeight() + " Kg";
    }
    
    //clone
    public OccasionalUser clone(){
        return new OccasionalUser(this);
    }

    public double multiplierCaloriesTypeUser() {
        return 1.0 * this.heartRateFactor() * this.getWeight(); 
    }
}
