package Service;

import DataAccess.*;
import Model.AuthToken;
import Model.Person;
import Request.ClearRequest;
import Request.PersonIDRequest;
import Result.ClearResult;
import Result.PersonIDResult;
import Result.PersonResult;

public class PersonIDService {
    /**
     *     Returns the single Person object with the specified ID (if the person is associated with the current user).
     *     The current user is determined by the provided authtoken.
     */

    /**
     *  takes in a personID, and then loads the program and returns the result of the load
     * @param authToken, personID request object
     * @return a personID request object the tells if it was a failure or a success
     */
    public PersonIDResult doService(String authToken, String personID) throws DataAccessException {
        Database db = new Database();
        // Verify that the auth token is the one we're looking for
        //if (authToken.equals(AuthTokenDao.find(authToken)) {
        //Invalid authToken
        //}
        if (personID.equals(null)) {
            PersonIDResult result = new PersonIDResult(false, "Error: Invalid personID parameter");
            return result;
        }
        String username; //TODO Does this bring it into scope?
        try {
            db.openConnection();
            AuthToken r = new AuthTokenDao(db.getConnection()).find(authToken);
            username = r.getUsername();
            db.closeConnection(true);
        } catch (DataAccessException ex) {
            PersonIDResult result = new PersonIDResult(false, "Error: Invalid auth token");
            return result;
        }
        try {
            db.openConnection();
            Person p = new PersonDao(db.getConnection()).find(personID);
            db.closeConnection(true);
            if (!(username.equals(p.getAssociatedUsername()))) {
                PersonIDResult result = new PersonIDResult(false, "Error: Requested person does not belong to this user");
                return result;
            }
            PersonIDResult result = new PersonIDResult(true, null, p.getAssociatedUsername(), personID, p.getFirstName(), p.getLastName(), p.getGender());
            return result;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            PersonIDResult result = new PersonIDResult(false, "Error: Internal Server Error");
            return result;
        }
    }
}
