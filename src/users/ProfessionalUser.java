package users;


public class ProfessionalUser extends User{

    public ProfessionalUser(String id, String name, String address, String email, int heartRate) {
        super(id, name, address, email, heartRate);
    }

    public ProfessionalUser(User u) {
        super(u);
    }
    
    public ProfessionalUser() {
        super();
    }

    public ProfessionalUser clone(){
        return new ProfessionalUser(this);
    }

    public double multiplierCaloriesTypeUser() {
        
        return 1.3 * this.heartRateFactor();
    }
}
