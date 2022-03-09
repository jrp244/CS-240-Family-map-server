package Service;
import DataAccess.*;
import JsonReader.fnameData;
import JsonReader.locationData;
import JsonReader.mnameData;
import JsonReader.snameData;
import Model.Event;
import Request.ClearRequest;
import Result.ClearResult;
import Result.FillResult;
import Request.FillRequest;
import Model.Person;
import com.google.gson.Gson;

import java.io.FileReader;
import java.sql.Connection;
import java.util.UUID;

public class GenerateService {
    public Person generatePerson(String gender, int generations, PersonDao persondao, String username) {
        int year = 2001;
        Person mother = null;
        Person father = null;
        if (generations > 1) {
            mother = generatePerson("f", generations - 1, persondao, username);
            father = generatePerson("m", generations - 1, persondao, username);
            // Set mother's and father's spouse IDs
            UUID uuid = UUID.randomUUID();
            mother.setPersonID(uuid.toString());
            uuid = UUID.randomUUID();
            father.setPersonID(uuid.toString());
            // (their marriage events must be in sync with each other)
            generateEvent("marriage", mother.getPersonID(), year, father, persondao.getConn());
            generateEvent("birth", mother.getPersonID(), year, father, persondao.getConn());
            generateEvent("death", mother.getPersonID(), year, father, persondao.getConn());
            generateEvent("birth", father.getPersonID(), year, father, persondao.getConn());
            generateEvent("death", father.getPersonID(), year, father, persondao.getConn());
        }
        UUID uuid = UUID.randomUUID();
        String personID = uuid.toString();
        String firstName;
        String lastName;
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            FileReader reader = new FileReader("FamilyMapServerStudent-master/json/fnames.json");

            fnameData femaleData = gson.fromJson(reader, fnameData.class);
            reader = new FileReader("FamilyMapServerStudent-master/json/mnames.json");
            mnameData maleData = gson.fromJson(reader, mnameData.class);
            reader = new FileReader("FamilyMapServerStudent-master/json/snames.json");
            snameData lastData = gson.fromJson(reader, snameData.class);
            int b = (int)(Math.random()*(femaleData.getData().length-0+1)+0);
            if (gender.equals("f")) {
                firstName = femaleData.getData()[b];
            } else {
                firstName = maleData.getData()[b];
            }
            lastName = lastData.getData()[b];
            Person person = new Person(personID, username, firstName, lastName, gender, father.getPersonID(), mother.getPersonID(), null);
            persondao.insert(person);
            // Set person's properties
            // Generate events for person (except marriage)
            // Save person in database
            return person;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void generateEvent(String eventType, String personID, int year, Person father, Connection conn) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            FileReader reader = new FileReader("FamilyMapServerStudent-master/json/locations.json");

            locationData data = gson.fromJson(reader, locationData.class);
            UUID uuid = UUID.randomUUID();
            String eventID = uuid.toString();
            uuid = UUID.randomUUID();
            String username = uuid.toString();
            int b = (int)(Math.random()*(data.getData().length-0+1)+0);
            year = year - 20;
            if (eventType.equals("death")) {
                year = year + 70;
            }
            Event event = new Event(eventID, username, personID, data.getData()[b].getLatitude(), data.getData()[b].getLongitude(), data.getData()[b].getCountry(), data.getData()[b].getCity(), eventType, year);
            new EventDao(conn).insert(event);
            if (eventType.equals("marriage")) {
                event = new Event(eventID, username, father.getPersonID(), data.getData()[b].getLatitude(), data.getData()[b].getLongitude(), data.getData()[b].getCountry(), data.getData()[b].getCity(), eventType, year);
                new EventDao(conn).insert(event);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
