package Model;

public class AuthToken {
    /**
     * base class for authToken. stores info for a single authtoken object
     */
    /**
     * stores unique AuthToken
     */
    private String authtoken;
    /**
     * stores username of the authtoken object
     */
    private String username;

    /**
     * Constructor
     * @param authtoken
     * @param username
     */
    public AuthToken(String authtoken, String username) {
        this.authtoken = authtoken;
        this.username = username;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public String getUsername() {
        return username;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Check to see if this instance equals another authtoken object
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof AuthToken) {
            AuthToken oEvent = (AuthToken) o;
            return oEvent.getAuthtoken().equals(getAuthtoken()) &&
                    oEvent.getUsername().equals(getUsername());
        } else {
            return false;
        }
    }
}
