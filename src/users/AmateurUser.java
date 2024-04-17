package users;
public class AmateurUser extends User {
    public AmateurUser(String id, String name, String address, String email, int heartRate) {
        super(id, name, address, email, heartRate);
    }

    public AmateurUser(User u) {
        super(u);
    }

    public AmateurUser() {
        super();
    }

    public AmateurUser clone(){
        return new AmateurUser(this);
    }

    public double multiplierCaloriesTypeUser() {
        return 1.2; 
    }
}