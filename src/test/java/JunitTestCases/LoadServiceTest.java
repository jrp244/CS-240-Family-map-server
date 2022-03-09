package JunitTestCases;

import DataAccess.DataAccessException;
import JsonReader.LoadData;
import JsonReader.locationData;
import Model.Event;
import Model.Person;
import Model.User;
import Request.ClearRequest;
import Request.LoadRequest;
import Result.ClearResult;
import Result.LoadResult;
import Service.ClearService;
import Service.LoadService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

public class LoadServiceTest {
    @Test
    public void loadPass() throws DataAccessException, FileNotFoundException {
        /*
        // create Gson instance
        Gson gson = new Gson();
        // create a reader
        FileReader reader = new FileReader("FamilyMapServerStudent-master/passoffFiles/LoadData.json");
        LoadData data = gson.fromJson(reader, LoadData.class);
        */ //Not sure if I need to do this
        User[] users = { new User("sheila", "parker", "sheila@parker.com", "Sheila", "Parker", "f", "Sheila_Parker")
        };
        Person[] persons = { new Person("Golden_Boy", "patrick", "Spencer", "Seeger", "f", "Happy_Birthday")
        };
        Event[] events = { new Event("birth", "sheila", "Sheila_Parker", (float) -36.18, (float) 144.96, "Australia", "Melborne",  "Sheila_Birth", 1999)
        };
        LoadRequest request = new LoadRequest(users, persons, events);
        LoadService service = new LoadService();
        LoadResult result = service.load(request);
        assertTrue(result.getSuccess());
    }
    @Test
    public void loadFail() throws DataAccessException {
        User[] users = { new User("sheila", "parker", "sheila@parker.com", "Sheila", "Parker", "f", "Sheila_Parker")
        };
        Person[] persons = { new Person("Golden_Boy", "patrick", "Spencer", "Seeger", "f", "Happy_Birthday")
        };
        Event[] events = {};
        LoadRequest request = new LoadRequest(users, persons, events);
        LoadService service = new LoadService();
        LoadResult result = service.load(request);
        assertFalse(result.getSuccess());
    }
}
