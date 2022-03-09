package Service;


import DataAccess.*;
import Model.AuthToken;
import Model.User;
import Request.ClearRequest;
import Request.RegisterRequest;
import Result.ClearResult;
import Result.RegisterResult;

import java.util.UUID;

public class RegisterService {
    /**
     *     Creates a new user account (user row in the database)
     *     Generates 4 generations of ancestor data for the new user (just like the /fill endpoint if called with a generations value of 4 and this new user’s username as parameters)
     *     Logs the user in
     *     Returns an authtoken
     */
    /**
     * stores a fail or a success message
     */
    private String message;
    /**
     * stores whether it was a fail or a success of the operation
     */
    private boolean success;

    /**
     *  takes in a login request, and then loads the program and returns the result of the login
     * @param r login request object
     * @return a register request object the tells if it was a failure or a success
     */
    public RegisterResult register(RegisterRequest r) throws DataAccessException { //Should be finished
        Database db = new Database();
        try {
            db.openConnection();
            UUID uuid = UUID.randomUUID();
            String personID = uuid.toString();
            if (r.getUsername().equals(null) || !(r.getGender().equals("f") || r.getGender().equals("m"))|| r.getPassword().equals(null) || r.getEmail().equals(null) || r.getFirstName().equals(null) || r.getLastName().equals(null)) {
                db.closeConnection(false);
                RegisterResult result = new RegisterResult(false, "Error: Request property missing or has invalid value");
                return result;
            }
            if (new UserDao((db.getConnection())).find(r.getUsername()) != null) {
                db.closeConnection(false);
                RegisterResult result = new RegisterResult(false, "Error: Username already taken by another user");
                return result;
            }
            User user = new User(r.getUsername(), r.getPassword(), r.getEmail(), r.getFirstName(), r.getLastName(), r.getGender(), personID);
            new UserDao(db.getConnection()).insert(user);
            RegisterResult result = new RegisterResult(true,null, r.getUsername(), r.getPassword(), r.getEmail(), r.getFirstName(), r.getLastName(), r.getGender(), personID);
            AuthToken authtoken = new AuthToken(result.getAuthToken(), result.getUsername());
            new AuthTokenDao(authtoken, db.getConnection()).insert(authtoken); //might not need to pass in the authtoken. Might need to change authtokendao constructor
            db.closeConnection(true);
            return result;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            RegisterResult result= new RegisterResult(false, "Error: Internal Server Error");
            return result;
        }
    }
}
