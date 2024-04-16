package users;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> usersMap;
    
    // Constructor
    public UserManager() {
        this.usersMap = new HashMap<>();
    }

    // Other methods
    // Add a user to the map
    public void addUser(User user) {
        this.usersMap.put(user.getId(), user);
    }

    // Get a user the map
    public User getUserById(String userId) {
        return this.usersMap.get(userId);
    }

    // Remove a user from the map
    public void removeUserById(String userId) {
        this.usersMap.remove(userId);
    }

    // Check if a user exists in the map
    public boolean userExists(String userId) {
        return this.usersMap.containsKey(userId);
    }

    // Get the number of users in the map
    public int getUserCount() {
        return this.usersMap.size();
    }
    //TO DO
}
