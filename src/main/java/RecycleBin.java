import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 9/18/15.
 * RecycleBin  class
 */
public class RecycleBin {
    private boolean isEmpty;
    private String coordinate;

    static final Logger logger = LoggerFactory.getLogger(RecycleBin.class);

    public RecycleBin(String coordinate) {

        this.isEmpty = true;
        this.coordinate = coordinate;
    }

    public String getCoordinate() {

        return coordinate;
    }

    public boolean isEmpty() {

        return isEmpty;
    }

    /**
     * Set isEmpty flag for current recycleBin.
     *
     * @param  empty boolean flag
     * @see         RecycleBin
     */
    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
        logger.info("New trash in the bin " + getCoordinate());

    }

    public synchronized double clean(Double performance) throws InterruptedException {
        if (! isEmpty()) {
            double time = 400 * performance;
            Thread.sleep((long) time);
            setEmpty(true);
            return time;
        }
        return 0;
    }

    public synchronized void litter() {

        setEmpty(false);
    }
}
