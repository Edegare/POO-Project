package users;


public class ProfessionalUser extends User{

    public ProfessionalUser(String id, String name, String address, String email, int heartRate, int weight) {
        super(id, name, address, email, heartRate ,weight);
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
        
        return 1.2 * this.heartRateFactor() * this.getWeight();
    }
}
