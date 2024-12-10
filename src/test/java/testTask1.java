import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import ucu.edu.ua.task1.*;

class testTask1 {

    private MessageSender messageSender;

    @BeforeEach
    void setUp() {
        messageSender = new MessageSender();
    }

    // Testing FacebookUser and its adapter
    @Test
    void testFacebookUserAdapter() {
        FacebookUser facebookUser = new FacebookUser("facebook_email", "Ukraine", LocalDateTime.now().toString());
        User user = new FacebookUserAdapter(facebookUser);

        assertNotNull(user, "User should not be null after FacebookUserAdapter creation");
        assertEquals("facebook_email", user.getMail(), "Email should match the provided email");
        assertEquals("Ukraine", user.getCountry(), "Country should match the provided country");
        assertNotNull(user.getActiveTime(), "Active time should not be null");
    }

    // Testing TwitterUser and its adapter
    @Test
    void testTwitterUserAdapter() {
        TwitterUser twitterUser = new TwitterUser("twitter_email", "USA", LocalDateTime.now().minusDays(1).toString());
        User user = new TwitterUserAdapter(twitterUser);

        assertNotNull(user, "User should not be null after TwitterUserAdapter creation");
        assertEquals("twitter_email", user.getMail(), "Email should match the provided email");
        assertEquals("USA", user.getCountry(), "Country should match the provided country");
        assertNotNull(user.getActiveTime(), "Last active time should not be null");
    }

    // Testing message sending functionality
    @Test
    void testMessageSendingToFacebookUser() {
        FacebookUser facebookUser = new FacebookUser("facebook_email", "Ukraine", LocalDateTime.now().toString());
        User user = new FacebookUserAdapter(facebookUser);

        messageSender.send(user, "Hello, Facebook!");
    }

    @Test
    void testMessageSendingToTwitterUser() {
        TwitterUser twitterUser = new TwitterUser("twitter_email", "USA", LocalDateTime.now().minusDays(1).toString());
        User user = new TwitterUserAdapter(twitterUser);

        messageSender.send(user, "Hello, Twitter!");
    }

    // Testing Main class logic
    @Test
    void testMainLogicWithFacebook() {
        AuthMethod authMethod = AuthMethod.FACEBOOK;
        User user = null;

        switch (authMethod) {
            case FACEBOOK:
                FacebookUser facebookUser = new FacebookUser("Facebook_email", "Ukraine", LocalDateTime.now().toString());
                user = new FacebookUserAdapter(facebookUser);
                break;

            case TWITTER:
                TwitterUser twitterUser = new TwitterUser("Twitter_email", "USA", LocalDateTime.now().minusDays(1).toString());
                user = new TwitterUserAdapter(twitterUser);
                break;

            default:
                fail("Unexpected auth method");
        }

        assertNotNull(user, "User should not be null after adapter creation");
        assertEquals("Facebook_email", user.getMail(), "Email should match Facebook email");
        assertEquals("Ukraine", user.getCountry(), "Country should match Ukraine");
    }

    @Test
    void testMainLogicWithTwitter() {
        AuthMethod authMethod = AuthMethod.TWITTER;
        User user = null;

        switch (authMethod) {
            case FACEBOOK:
                FacebookUser facebookUser = new FacebookUser("Facebook_email", "Ukraine", LocalDateTime.now().toString());
                user = new FacebookUserAdapter(facebookUser);
                break;

            case TWITTER:
                TwitterUser twitterUser = new TwitterUser("Twitter_email", "USA", LocalDateTime.now().minusDays(1).toString());
                user = new TwitterUserAdapter(twitterUser);
                break;

            default:
                fail("Unexpected auth method");
        }

        assertNotNull(user, "User should not be null after adapter creation");
        assertEquals("Twitter_email", user.getMail(), "Email should match Twitter email");
        assertEquals("USA", user.getCountry(), "Country should match USA");
    }
}


