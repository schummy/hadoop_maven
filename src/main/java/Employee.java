import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 9/18/15.
 * Employee class represents employee who puts trash into the recycle recycleBin.
 */

public class Employee implements Runnable {

    private RecycleBin recycleBin;
    String name;
    final Logger logger = LoggerFactory.getLogger(Employee.class);

    public Employee() {
    }

    public void litter() throws InterruptedException {

        if ( recycleBin != null ) {
            recycleBin.litter();
        }
        else {
            logger.info("Employee {} has no recycleBin to put the trash!", name);
        }
        Thread.sleep((long) (100000 * Math.random()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                litter();
            } catch (InterruptedException e) {
                recycleBin.litter();
            }
        }
    }

    public RecycleBin getRecycleBin() {
        return recycleBin;
    }

    public void setRecycleBin(RecycleBin bin) {
        this.recycleBin = bin;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
