import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Start cleaning!");
        Cleaner svitlanaPetrivna = new Cleaner("Svitlana Petrivna", 0.9);
        Cleaner olenaAnatoliivna = new Cleaner("Olena Anatoliivna", 0.85);
        Cleaner irynaVasyliivna = new Cleaner("Iryna Vasilivna", 0.92);
        ArrayList<RecycleBin> floor1 = new ArrayList<RecycleBin>();
        ArrayList<RecycleBin> floor2 = new ArrayList<RecycleBin>();
        ArrayList<RecycleBin> floor3 = new ArrayList<RecycleBin>();

        Random rnd = new Random();

        for (int i=1; i<100; i++)
        {
            RecycleBin bin1 = new RecycleBin("1:"+String.valueOf(i));
            bin1.set_isEmpty(rnd.nextBoolean());
            floor1.add(bin1);
            (new Thread(new Litter(bin1))).start();

            RecycleBin bin2 = new RecycleBin("2:"+String.valueOf(i));
            bin2.set_isEmpty(rnd.nextBoolean());
            floor2.add(bin2);
            (new Thread(new Litter(bin2))).start();

            RecycleBin bin3 = new RecycleBin("3:"+String.valueOf(i));
            bin3.set_isEmpty(rnd.nextBoolean());
            floor3.add(bin3);
            (new Thread(new Litter(bin3))).start();

        }

        svitlanaPetrivna.assignFloor(floor1);
        olenaAnatoliivna.assignFloor(floor2);
        irynaVasyliivna.assignFloor(floor3);
        (new Thread(svitlanaPetrivna)).start();
        (new Thread(olenaAnatoliivna)).start();
        (new Thread(irynaVasyliivna)).start();
    }
}
