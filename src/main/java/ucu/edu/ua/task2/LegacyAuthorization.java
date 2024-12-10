package ucu.edu.ua.task2;

public class LegacyAuthorization {
    // Renamed method
    public boolean authenticate(DataBase db) {
        // Simulate legacy authentication logic
        String userData = db.getUserData();
        return userData != null && !userData.isEmpty();
    }
}