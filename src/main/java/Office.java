
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Office {

    final Logger logger = LoggerFactory.getLogger(Office.class);

    private ArrayList <Floor> floors;
    private ArrayList <Cleaner> cleaners;

    public Office() {

    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public ArrayList<Cleaner> getCleaners() {
        return cleaners;
    }

    public void setCleaners(ArrayList<Cleaner> cleaners) {
        this.cleaners = cleaners;
    }

    public void run() {

        for (Floor floor : floors) {
            for (Employee employee : floor.getEmployees()) {

                (new Thread(employee)).start();
            }
        }

        for (int i = 0; i < cleaners.size(); i++) {
            Cleaner cleaner = cleaners.get(i);

            cleaner.setRecycleBinsPool( floors.get(i).getRecycleBins());
            (new Thread(cleaner)).start();
        }
    }
}
