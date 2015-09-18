/**
 * Created by user on 9/18/15.
 */
public class Litter implements Runnable {

    private RecycleBin _bin;

    public Litter(RecycleBin _been) {
        this._bin = _been;
    }
    public void litter() throws InterruptedException {
        Thread.sleep((long) (100000 * Math.random()));
        this._bin.set_isEmpty(false);
        System.out.println("New trash in the bin" + _bin.get_coordinate());
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
