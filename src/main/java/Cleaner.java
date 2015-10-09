import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by user on 9/18/15.
 * Cleaner class represent cleaners who cleans recycle bin.
 */
public class Cleaner implements Runnable{
    private String name;
    private Double performance;
    private ArrayList<RecycleBin> recycleBinsPool;
    final Logger logger = LoggerFactory.getLogger(Cleaner.class);


    public Cleaner(String name, Double performance) {
        this.name = name;
        this.performance = performance;
    }

    public void setRecycleBinsPool(ArrayList<RecycleBin> recycleBins) {

        this.recycleBinsPool = recycleBins;
    }

    public void cleanBin(RecycleBin bin) throws InterruptedException {

        Double time =bin.clean(performance);
        if (time !=0 ) {
            logger.info("{} has cleaned the bin {} in {} ms", this.name,  bin.getCoordinate(),
                    time);
        }
    }

    public void cleanBinsPool() throws InterruptedException {
        for (RecycleBin been : this.recycleBinsPool) {
            cleanBin(been);
        }
        logger.info("{} has cleaned the floor.", this.name );
        Thread.sleep(10000);

    }

    @Override
    public void run(){
        while(true) {
            try {
                cleanBinsPool();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
