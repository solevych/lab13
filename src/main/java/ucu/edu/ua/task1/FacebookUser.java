package ucu.edu.ua.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class FacebookUser {
    private String email;
    private String country;
    private String activeTime; 

    // public FacebookUser(String email, String country, long activeTime) {
    //     this.email = email;
    //     this.country = country;
    //     this.activeTime = activeTime;
    // }

    public String getUserMmail() {
        return email;
    }

    public String getUserCountry() {
        return country;
    }

    public String getUserActiveTime() {
        return activeTime;
    }
}