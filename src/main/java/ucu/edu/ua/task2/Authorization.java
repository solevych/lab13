package ucu.edu.ua.task2;


    
public class Authorization extends LegacyAuthorization {
    // Directly use the authenticate method from LegacyAuthorization
    public boolean login(DataBase db) {
        return authenticate(db);  // Calls the method from LegacyAuthorization without recursion
    }
}

