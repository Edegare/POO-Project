package users;


public class OccasionalUser extends User {
    
    public OccasionalUser(String id, String name, String address, String email, int heartRate, int weight) {
        super(id, name, address, email, heartRate, weight);
    }

    public OccasionalUser(User u) {
        super(u);
    }

    public OccasionalUser() {
        super();
    }

    public OccasionalUser clone(){
        return new OccasionalUser(this);
    }

    public double multiplierCaloriesTypeUser() {
        return 1.0 * this.heartRateFactor() * this.getWeight(); 
    }
}
