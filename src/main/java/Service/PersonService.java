package Service;

import DataAccess.*;
import Model.AuthToken;
import Model.Person;
import Request.ClearRequest;
import Request.PersonRequest;
import Result.ClearResult;
import Result.PersonIDResult;
import Result.PersonResult;

public class PersonService {
    /**
     *     Returns ALL family members of the current user. The current user is determined by the provided authtoken.
     */

    /**
     *  takes in a person request, and then loads the program and returns the result of the load
     * @param authtoken  string
     * @return a person request object the tells if it was a failure or a success
     */
    public PersonResult doService(String authtoken) throws DataAccessException {
            Database db = new Database();
            try {
                db.openConnection();
                try {//This might not work. I don't know if the proper error will pop up by doing nested trys
                    AuthToken auth = new AuthTokenDao(db.getConnection()).find(authtoken);
                    Person[] people = new PersonDao(db.getConnection()).getPeople(auth.getUsername());
                    db.closeConnection(true);
                    PersonResult result = new PersonResult(true,null, people);
                    return result;
                } catch (DataAccessException ex) {
                    ex.printStackTrace();
                    db.closeConnection(false);
                    PersonResult result= new PersonResult(false, "Error: Invalid auth token");
                    return result;
                }
            } catch (DataAccessException ex) {
                ex.printStackTrace();
                db.closeConnection(false);
                PersonResult result= new PersonResult(false, "Error: Internal server error");
                return result;
            }
        }
}