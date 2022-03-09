package Service;

import DataAccess.*;
import Model.Person;
import Request.ClearRequest;
import Request.LoadRequest;
import Result.ClearResult;
import Result.LoadResult;

import java.util.ArrayList;

public class LoadService {
    /**
     *     Clears all data from the database (just like the /clear API)
     *     Loads the user, person, and event data from the request body into the database.
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
     *  takes in a load request, and then loads the program and returns the result of the load
     * @param r load request object
     * @return a load request object the tells if it was a failure or a success
     */
    public LoadResult load(LoadRequest r) throws DataAccessException { //TODO: how to return gson.
        Database db = new Database();
        try {
            ArrayList<Person> emptyArray = new ArrayList<>();
            if (r.getEventArray().length == 0 || r.getPersonArray().length == 0 || r.getUserArray().length == 0) {
                LoadResult result = new LoadResult(false, "Invalid request data (missing values, invalid values, etc.)");
                return result;
            }
            db.openConnection();
            new EventDao(db.getConnection()).clear();//Why does it need to be new?
            new PersonDao(db.getConnection()).clear();
            new UserDao(db.getConnection()).clear();
            new AuthTokenDao(db.getConnection()).clear();
            for (int i = 0; i < r.getEventArray().length; i++) {//To insert the elements back in:
                new EventDao(db.getConnection()).insert(r.getEventArray()[i]);
            }
            for (int i = 0; i < r.getPersonArray().length; i++) {
                new PersonDao(db.getConnection()).insert(r.getPersonArray()[i]);
            }
            for (int i = 0; i < r.getUserArray().length; i++) {
                new UserDao(db.getConnection()).insert(r.getUserArray()[i]);
            }
            db.closeConnection(true);
            LoadResult result = new LoadResult(true,"Successfully added X users, Y persons, and Z events to the database.");
            return result;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            LoadResult result= new LoadResult(false, "Error: Internal server error");
            return result;
        }
    }
}
