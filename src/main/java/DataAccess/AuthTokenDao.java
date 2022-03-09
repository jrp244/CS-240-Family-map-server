package DataAccess;

import Model.AuthToken;
import Model.Event;

import java.sql.*;

public class AuthTokenDao {
    /**
     * interacts with the authtoken database after being called from the service classes
     */
    /**
     *AuthToken object created to be used by the class, so the original passed in by the model isn't changed on accident
     */
    private AuthToken userAuthToken;

    /**
     * Testing constructor for only one param
     * @param conn
     */
    public AuthTokenDao(Connection conn) {
        this.conn = conn;
    }

    /**
     * gets the authToken being used right now
     * @return userAuthToken
     */
    public AuthToken getUserAuthToken() {
        return userAuthToken;
    }

    /**
     * establishes a connection with the database
     */
    private final Connection conn;
    /**
     * constructor that initializes userauthtoken object, so it doesn't modify the original on accident. Also initializes the connection
     * @param userAuthToken
     * @param conn
     */
    public AuthTokenDao(AuthToken userAuthToken, Connection conn) {
        this.userAuthToken = userAuthToken;
        this.conn = conn;
    }

    /**
     *Calls an authtoken object and adds that object to the authtoken database
     */
    public void insert(AuthToken authToken) throws DataAccessException{
        //We can structure our string to be similar to a sql command, but if we insert question
        //marks we can change them later with help from the statement
        String sql = "INSERT INTO Authtoken (authtoken, username) VALUES(?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //Using the statements built-in set(type) functions we can pick the question mark we want
            //to fill in and give it a proper value. The first argument corresponds to the first
            //question mark found in our sql String
            stmt.setString(1, authToken.getAuthtoken());
            stmt.setString(2, authToken.getUsername());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while inserting an event into the database");
        }
    }

    /**
     * takes the authToken string object and finds it in the database, returning the object found
     * @param authToken
     * @return authtoken object
     */
    public AuthToken find(String authToken) throws DataAccessException {
        AuthToken event;
        ResultSet rs = null;
        String sql = "SELECT * FROM AuthToken WHERE authtoken = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, authToken);
            rs = stmt.executeQuery();
            if (rs.next()) {
                event = new AuthToken(rs.getString("authtoken"), rs.getString("username"));
                return event;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while finding event");
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    /**
     * called on object. clears the authtoken database
     */
    public void clear () throws DataAccessException{
        try (Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM Authtoken";
            stmt.executeUpdate(sql);
        }catch (SQLException e) {
            throw new DataAccessException("SQL Error encountered while clearing tables");
        }
    }

    /**
     * called on object. deletes authtoken that method is called on
     */
    public void delete() {

    }
}
