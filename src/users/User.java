package users;
public abstract class User {
    private String id;
    private String name;
    private String address;
    private String email;
    private int heartRate;
    //private List<Activity> activities;
    //private List<TrainSession> sessions; 

    public User(String id, String name, String address, String email, int heartRate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.heartRate = heartRate;
    }

    public User(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.address = u.getAddress();
        this.email = u.getEmail();
        this.heartRate = u.getHeartRate();
    }

    public User() {
        this.id = "";
        this.name = "";
        this.address = "";
        this.email = "";
        this.heartRate = 0;
    }

    //Getters & Setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeartRate() {
        return this.heartRate;
    }
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    // Compare objects
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User u = (User) obj;
        return this.id.equals(u.id) &&
                this.name.equals(u.name) &&
                this.address.equals(u.address) &&
                this.email.equals(u.email) &&
                this.heartRate == u.heartRate;
    }

    // ToString 
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", heartRate=" + heartRate + "}";
    }

    //Clone
    public abstract User clone();
    //Multiplier based on each type of user
    public abstract double multiplierCaloriesTypeUser();
}
