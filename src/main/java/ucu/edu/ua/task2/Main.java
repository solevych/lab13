package ucu.edu.ua.task2;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        Authorization auth = new Authorization();

        // Simulate user login
        if (auth.login(db)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}
