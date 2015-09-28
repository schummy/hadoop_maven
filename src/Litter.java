/**
 * Created by user on 9/18/15.
 * Litter class represents employee who puts trash into the recycle bin.
 */

public class Litter implements Runnable {

    private RecycleBin bin;

    public Litter(RecycleBin bin) {

        this.bin = bin;
    }

    public void litter() throws InterruptedException {
            Thread.sleep((long) (100000 * Math.random()));
            synchronized (this.bin) {
                this.bin.setEmpty(false);
                System.out.println("New trash in the bin " + bin.getCoordinate());
            }
    }

    @Override
    public void run() {
        while (true) {
            try {
                litter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
