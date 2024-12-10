package ucu.edu.ua.task1;

public class FacebookUserAdapter implements User{

    private FacebookUser facebookUser;

    public FacebookUserAdapter(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    @Override
    public String getMail() {
        return facebookUser.getUserMmail();
    }

    @Override
    public String getCountry() {
        return facebookUser.getUserCountry();
        
    }

    @Override
    public String getActiveTime() {
        return facebookUser.getUserActiveTime();
    }

    @Override
    public String toString() {
        return facebookUser.toString();
    }

}
