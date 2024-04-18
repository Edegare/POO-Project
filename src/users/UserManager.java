package users;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UserManager implements Serializable{
    private Map<String, User> usersMap;
    
    // Constructors
    public UserManager() {
        this.usersMap = new HashMap<>();
    }

    public UserManager(Map<String, User> users) {
        this.usersMap = users.entrySet().stream()
                        .collect(HashMap::new, 
                        (map, entry) -> map.put(entry.getKey(), entry.getValue().clone()), 
                        HashMap::putAll);
    }

    //Setters & Getters
    public void setUsersMap(Map<String, User> users) {
        this.usersMap = users.entrySet().stream()
                        .collect(HashMap::new, 
                        (map, entry) -> map.put(entry.getKey(), entry.getValue().clone()), 
                        HashMap::putAll);
    }

    public Map<String, User> getUsersMap() {
        return (this.usersMap.entrySet().stream()
                .collect(Collectors
                .toMap(e->e.getKey(), e->e.getValue().clone())));
    }

    // Other methods
    // Add a user to the map
    public void addUser(User user) {
        this.usersMap.put(user.getId(), user.clone());
    }

    // Get a user from the map
    public User getUser(String userId) {
        return this.usersMap.get(userId).clone();
    }

    // Remove a user from the map
    public void removeUser(String userId) {
        this.usersMap.remove(userId);
    }

    // Check if a user exists in the map
    public boolean containsUser(String userId) {
        return this.usersMap.containsKey(userId);
    }

    // Get the number of users in the map
    public int getUserCount() {
        return this.usersMap.size();
    }

    // Serialization (Save and load users)
    public void saveUsers(String path) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);){
            out.writeObject(this.usersMap);
            fileOut.close();
        }
    }   

    @SuppressWarnings("unchecked")
    public void loadUsers(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);) {
            this.usersMap = (Map<String,User>) in.readObject();
        }
    }

    //toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserManager{");
        sb.append("users=").append(this.usersMap.toString());
        sb.append('}');
        return sb.toString();
    }

    //Clone
    public UserManager clone() {
        UserManager managerClone = new UserManager();

        
        managerClone.usersMap = this.usersMap.entrySet().stream()
                                .collect(Collectors
                                .toMap(e->e.getKey(), e->e.getValue().clone()));

        return managerClone;
    }

}
