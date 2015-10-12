import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 9/18/15.
 * Litter class represents employee who puts trash into the recycle bin.
 */

public class Litter implements Runnable {

    private RecycleBin bin;
    final Logger logger = LoggerFactory.getLogger(Litter.class);

    public Litter(RecycleBin bin) {

        this.bin = bin;
    }

    public void litter() throws InterruptedException {
        bin.litter();
        Thread.sleep((long) (100000 * Math.random()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                litter();
            } catch (InterruptedException e) {
                bin.litter();
            }
        }
    }
}
