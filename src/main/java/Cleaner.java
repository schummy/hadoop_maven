import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 9/18/15.
 * Cleaner class represent cleaners who cleans recycle bin.
 */
public class Cleaner implements Runnable{
    private String name;
    private Double performance;
    private List<RecycleBin> recycleBinsPool;
    final Logger logger = LoggerFactory.getLogger(Cleaner.class);

    public Cleaner() {
    }

    public Cleaner(String name, Double performance) {
        this.name = name;
        this.performance = performance;
    }

    public void setRecycleBinsPool(List<RecycleBin> recycleBins) {

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
        if (recycleBinsPool == null) {
            logger.info("{} is not assigned to any floors.", this.name );
            Thread.sleep(10000);
            return;
        }

        for (RecycleBin recycleBin : this.recycleBinsPool) {
            cleanBin(recycleBin);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }
}
