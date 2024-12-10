package ucu.edu.ua.task2;

public class LegacyDatabase {
    // Renamed methods
    public String getUserData() {
        return "Sample User Data"; // Simulate returning user data
    }

    public String getStaticData() {
        return "Sample Static Data"; // Simulate returning static data
    }
    public String fetchUserData() {
            return getUserData(); // Maps to the legacy method
        }
    
    public String fetchStaticData() {
            return getStaticData(); // Maps to the legacy method
        }
} 

