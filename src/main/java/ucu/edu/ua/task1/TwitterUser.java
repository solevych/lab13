package ucu.edu.ua.task1;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class TwitterUser {
    private String email;
    private String country;
    private String lastActiveTime; // Using timestamp (e.g., milliseconds since epoch)

    // public TwitterUser(String email, String country, long lastActiveTime) {
    //     this.email = email;
    //     this.country = country;
    //     this.lastActiveTime = lastActiveTime;
    // }

    public String getUserMail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getLastActiveTime() {
        return lastActiveTime;
    }
}

