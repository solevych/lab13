import org.junit.jupiter.api.Test;

import ucu.edu.ua.task2.Authorization;
import ucu.edu.ua.task2.DataBase;
import ucu.edu.ua.task2.LegacyAuthorization;

import static org.junit.jupiter.api.Assertions.*;

public class testTask2 {

    // Test the LegacyAuthorization class
    @Test
    public void testAuthenticateLegacyAuthorization() {
        LegacyAuthorization legacyAuth = new LegacyAuthorization();
        DataBase db = new DataBase();

        // Test with valid user data
        assertTrue(legacyAuth.authenticate(db), "Authentication should succeed with valid user data");

        // Test with no user data (simulate empty data)
        DataBase emptyDb = new DataBase() {
            @Override
            public String getUserData() {
                return ""; // Simulating empty user data
            }
        };
        assertFalse(legacyAuth.authenticate(emptyDb), "Authentication should fail with empty user data");
    }

    // Test the Authorization class
    @Test
    public void testAuthenticateAuthorization() {
        Authorization auth = new Authorization();
        DataBase db = new DataBase();

        // Test with valid user data
        assertTrue(auth.authenticate(db), "Authentication should succeed with valid user data");

        // Test with no user data (simulate empty data)
        DataBase emptyDb = new DataBase() {
            @Override
            public String getUserData() {
                return ""; // Simulating empty user data
            }
        };
        assertFalse(auth.authenticate(emptyDb), "Authentication should fail with empty user data");
    }

    @Test
    public void testLoginAuthorization() {
        Authorization auth = new Authorization();
        DataBase db = new DataBase();

        // Test login with valid user data
        assertTrue(auth.login(db), "Login should succeed with valid user data");

        // Test login with no user data (simulate empty data)
        DataBase emptyDb = new DataBase() {
            @Override
            public String getUserData() {
                return ""; // Simulating empty user data
            }
        };
        assertFalse(auth.login(emptyDb), "Login should fail with empty user data");
    }

    // Test the Database class
    @Test
    public void testGetUserData() {
        DataBase db = new DataBase();

        // Ensure that the getUserData method returns the correct data
        assertEquals("Sample User Data", db.getUserData(), "getUserData should return the correct data");
    }

    @Test
    public void testGetStaticData() {
        DataBase db = new DataBase();

        // Ensure that the getStaticData method returns the correct data
        assertEquals("Sample Static Data", db.getStaticData(), "getStaticData should return the correct data");
    }

    @Test
    public void testDatabaseWithEmptyData() {
        // Create a mock Database where getUserData returns empty string
        DataBase emptyDb = new DataBase() {
            @Override
            public String getUserData() {
                return ""; // Simulating empty user data
            }
        };

        // Test that getUserData returns an empty string
        assertEquals("", emptyDb.getUserData(), "getUserData should return an empty string when no data exists");

        // Test that getStaticData still returns the static string
        assertEquals("Sample Static Data", emptyDb.getStaticData(), "getStaticData should still return correct static data even with empty user data");
    }
}
