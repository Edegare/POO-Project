package users;

import java.util.List;

import activities.TrainSession;

public class ProfessionalUser extends User{

    public ProfessionalUser(String id, String name, String address, String email, int heartRate, int weight, List<TrainSession> sessions) {
        super(id, name, address, email, heartRate, weight, sessions);
    }


    public ProfessionalUser(User u) {
        super(u);
    }
    
    public ProfessionalUser() {
        super();
    }


    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProfessionalUser)) return false;
        ProfessionalUser u = (ProfessionalUser) obj;
        return this.getId().equals(u.getId()) &&
                this.getName().equals(u.getName()) &&
                this.getAddress().equals(u.getAddress()) &&
                this.getEmail().equals(u.getEmail()) &&
                this.getHeartRate() == u.getHeartRate() &&
                this.getWeight() == u.getWeight();
    }

    // ToString 
    public String toString() {
        return "Professional User with id '" + this.getId() + "\' {" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", heartRate= " + this.getHeartRate() + " BPM" + 
                ", weight= " + this.getWeight() + " Kg}";
    }

    public String toStringProfile() {
        return "User Profile:\n" +
                "Type: 'Professional'\n" + 
                "ID = '" + this.getId() + "\'\n" +
                "Name = '" + this.getName() + "\'\n" +
                "Address = '" + this.getAddress() + "\'\n" +
                "Email = '" + this.getEmail() + "\'\n" +
                "Average Heart Rate= " + this.getHeartRate() + " BPM\n" +
                "Weight= " + this.getWeight() + " Kg";
    }
    
    //clone
    public ProfessionalUser clone(){
        return new ProfessionalUser(this);
    }

    public double multiplierCaloriesTypeUser() {
        
        return 1.2 * this.heartRateFactor() * this.getWeight();
    }
    
}
