package Service;


import DataAccess.*;
import Model.User;
import Result.LoginResult;
import Request.LoginRequest;

public class LoginService {
    /**
     *     Logs the user in
     *     Returns an authtoken.
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
     * @return a login request object the tells if it was a failure or a success
     */
    public LoginResult login(LoginRequest r) throws DataAccessException{
        Database db = new Database();
        try {
            db.openConnection();
            if (r.getUsername().equals(null) || r.getPassword().equals(null) || r.getUsername().equals("") || r.getPassword().equals("")) {
                LoginResult result = new LoginResult(false, "Error: Request property missing or has invalid value");
                return result;
            }
            if (r.getUsername().equals(null) || r.getPassword().equals(null) || r.getUsername().equals("") || r.getPassword().equals("")) {
                LoginResult result = new LoginResult(false, "Error: Request property missing or has invalid value");
                return result;
            }
            User user = new UserDao(db.getConnection()).find(r.getUsername());
            db.closeConnection(true);
            LoginResult result = new LoginResult(true,null, r.getPassword(), r.getUsername());
            return result;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            LoginResult result= new LoginResult(false, "Error: Internal Server Error", r.getPassword(), r.getUsername());
            return result;
        }
    }
}
