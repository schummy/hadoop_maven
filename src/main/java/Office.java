
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

public class Office {

    final Logger logger = LoggerFactory.getLogger(Office.class);
    private final int MAX_EMPLOYEES_PER_FLOOR = 100;
    private final int NUMBER_OF_FLOORS = 3;

    private ArrayList <ArrayList<RecycleBin> > floors;
    private ArrayList <Cleaner> cleaners;

    public Office() {
        initFloors();
        initCleaners();
        for (int i = 0; i < NUMBER_OF_FLOORS; i++){
            cleaners.get(i).setRecycleBinsPool(floors.get(i));
        }

    }

    private void initCleaners() {
        this.cleaners = new ArrayList<Cleaner>();
        this.cleaners.add(new Cleaner("Svitlana Petrivna", 0.9));
        this.cleaners.add(new Cleaner("Olena Anatoliivna", 0.85));
        this.cleaners.add(new Cleaner("Iryna Vasilivna", 0.92));
    }

    private void initFloors() {

        this.floors = new ArrayList <ArrayList<RecycleBin>>();
        for (int i = 0; i < NUMBER_OF_FLOORS; i++){
            ArrayList<RecycleBin> floor = new ArrayList<RecycleBin>();
            for (int j = 0; j < MAX_EMPLOYEES_PER_FLOOR; j++) {
                RecycleBin bin = new RecycleBin(String.valueOf(i+1) + ":" + String.valueOf(j+1));
                floor.add(bin);
                (new Thread(new Litter(bin))).start();
            }
            floors.add(floor);
        }
    }

    public ArrayList<ArrayList<RecycleBin>> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<ArrayList<RecycleBin>> floors) {
        this.floors = floors;
    }

    public ArrayList<Cleaner> getCleaners() {
        return cleaners;
    }

    public void setCleaners(ArrayList<Cleaner> cleaners) {
        this.cleaners = cleaners;
    }

    public void runCleaners() {
        for (Cleaner cleaner : cleaners) {
            (new Thread(cleaner)).start();
        }
    }
}
