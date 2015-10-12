import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 10/9/15.
 * The main Application class. It creates instance of @Office and start cleaning.
 */
public class Application {
    static final Logger logger = LoggerFactory.getLogger(Office.class);

    public static void main(String[] args) throws InterruptedException {

      logger.info("Start cleaning!");
      Office office = new Office();
      office.runCleaners();
  }
}
