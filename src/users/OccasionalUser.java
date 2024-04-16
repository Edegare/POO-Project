package users;
public class OccasionalUser extends User{
    
    public OccasionalUser(String id, String name, String address, String email, int heartRate) {
        super(id, name, address, email, heartRate);
    }

    public OccasionalUser(User u) {
        super(u);
    }

    public OccasionalUser clone(){
        return new OccasionalUser(this);
    }

    public double multiplierCaloriesTypeUser() {
        return 1.0; 
    }
}
