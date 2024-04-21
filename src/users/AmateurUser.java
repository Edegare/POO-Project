package users;

import java.util.List;

import activities.TrainSession;

public class AmateurUser extends User{
    public AmateurUser(String id, String name, String address, String email, int heartRate, int weight, List<TrainSession> sessions) {
        super(id, name, address, email, heartRate, weight, sessions);
    }

    public AmateurUser(User u) {
        super(u);
    }

    public AmateurUser() {
        super();
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmateurUser)) return false;
        AmateurUser u = (AmateurUser) obj;
        return this.getId().equals(u.getId()) &&
                this.getName().equals(u.getName()) &&
                this.getAddress().equals(u.getAddress()) &&
                this.getEmail().equals(u.getEmail()) &&
                this.getHeartRate() == u.getHeartRate() &&
                this.getWeight() == u.getWeight();
    }

    // ToString 
    public String toString() {
        return "Amateur User with id '" + this.getId() + "\' {" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", heartRate= " + this.getHeartRate() + " BPM" + 
                ", weight= " + this.getWeight() + " Kg}";
    }

    public String toStringProfile() {
        return "User Profile:\n" +
                "Type: 'Amateur'\n" + 
                "ID = '" + this.getId() + "\'\n" +
                "Name = '" + this.getName() + "\'\n" +
                "Address = '" + this.getAddress() + "\'\n" +
                "Email = '" + this.getEmail() + "\'\n" +
                "Average Heart Rate= " + this.getHeartRate() + " BPM\n" +
                "Weight= " + this.getWeight() + " Kg";
    }
    
    //clone
    public AmateurUser clone(){
        return new AmateurUser(this);
    }

    public double multiplierCaloriesTypeUser() {
        return 1.1 * this.heartRateFactor() * this.getWeight(); 
    }
}