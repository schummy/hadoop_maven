import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 9/18/15.
 * RecycleBin  class
 */
public class RecycleBin implements java.io.Serializable{
    private int trash;
    private String coordinate;


    static final Logger logger = LoggerFactory.getLogger(RecycleBin.class);

    public RecycleBin(String coordinate) {

        this.trash = 0;
        this.coordinate = coordinate;
    }
    public RecycleBin() {

        this.trash = 0;
    }

    public String getCoordinate() {

        return coordinate;
    }

    /**
     * Set trash flag for current recycleBin.
     *
     * @param  trash int value
     * @see         RecycleBin
     */
    public void setTrash(int trash) {
        this.trash = trash;

    }

    public synchronized double clean(Double performance) throws InterruptedException {
        if (! this.isEmpty()) {
            double time = 400 * performance;
            Thread.sleep((long) time);
            trash = 0;
            logger.debug("The bin {} was cleaned.", getCoordinate());
            return time;
        }
        return 0;
    }

    private boolean isEmpty() {
        return trash == 0;
    }

    public synchronized void litter() {

        trash++;
        logger.info("The bin {} has trash {}.", getCoordinate(), trash);

    }

    public void setCoordinate(String coordinate) {

        this.coordinate = coordinate;
        logger.debug("New coordinates for bin: {}.", getCoordinate());

    }
}
