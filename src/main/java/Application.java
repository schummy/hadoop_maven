import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by user on 10/9/15.
 * The main Application class. It creates instance of @Office and start cleaning.
 */
public class Application {
    static final Logger logger = LoggerFactory.getLogger(Office.class);

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("config/spring/Beans.xml");

       /* Employee litter = (Employee) context.getBean("litter1");
        Cleaner cleaner = (Cleaner) context.getBean("svitlanaPetrivna");
        (new Thread(litter)).start();
        (new Thread(cleaner)).start();*/
        Office officeEPAM = (Office) context.getBean("officeEPAM");
        officeEPAM.run();
     /* logger.info("Start cleaning!");
      Office office = new Office();
      office.runCleaners();*/
  }
}
