package DataAccess;

import Model.Event;
import Model.User;

import java.sql.*;

public class UserDao {
    /**
     * interacts with the user database after being called from the service classes
     */
    /**
     * user object created to be used by the class
     */
    private User user;

    /**
     * called on object. deletes user that method is called on
     */
    public void delete() {
    }

    /**
     * takes username and finds all the people from that username
     * @param username that stores the username
     * @return and array of person objects associated with username
     */
    public User[] getUsers(String username) {return null;}

    /**
     * Whenever we want to make a change to our database we will have to open a connection and use
     */
    private final Connection conn;

    /**
     * Constructor
     * @param conn
     */
    public UserDao(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * called on object. clears the person database
     */
    public void clear () throws DataAccessException {
        try (Statement stmt = conn.createStatement()){
            String sql = "DELETE FROM User";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException("SQL Error encountered while clearing tables");
        }
    }
    /**
     *Calls a user object and adds that user to the event database
     */
    public void insert(User event) throws DataAccessException {
        //We can structure our string to be similar to a sql command, but if we insert question
        //marks we can change them later with help from the statement
        String sql = "INSERT INTO User (username, password, email, firstName, lastName, " +
                "gender, personID) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //Using the statements built-in set(type) functions we can pick the question mark we want
            //to fill in and give it a proper value. The first argument corresponds to the first
            //question mark found in our sql String
            stmt.setString(1, event.getUsername());
            stmt.setString(2, event.getPassword());
            stmt.setString(3, event.getEmail());
            stmt.setString(4, event.getFirstName());
            stmt.setString(5, event.getLastName());
            stmt.setString(6, event.getGender());
            stmt.setString(7, event.getPersonID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while inserting into the database");
        }
    }
    /**
     * takes the username string object and finds it in the database, returning the object found
     * @param username
     * @return user object
     */
    public User find(String username) throws DataAccessException {
        User event;
        ResultSet rs = null;
        String sql = "SELECT * FROM User WHERE username = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                event = new User(rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("gender"), rs.getString("personID"));
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
}
