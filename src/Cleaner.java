import java.util.ArrayList;

/**
 * Created by user on 9/18/15.
 * Cleaner class represent cleaners who cleans recycle bin.
 */
public class Cleaner implements Runnable{
    private String name;
    private Double performance;
    private ArrayList<RecycleBin> recycleBinsPool;

    public Cleaner(String name, Double performance) {
        this.name = name;
        this.performance = performance;
    }

    public void assignFloor(ArrayList<RecycleBin> recycleBins) {

        this.recycleBinsPool = recycleBins;
    }

    public void cleanBin(RecycleBin bin) throws InterruptedException {
        if ( ! bin.isEmpty() ) {
            double time = 400 * this.performance;
            Thread.sleep((long) time);
            bin.setEmpty(true);
            System.out.println(this.name + " has cleaned the bin " + bin.getCoordinate()
                    + " in " + String.valueOf(time) + "ms" );
        }
    }

    public void cleanBinsPool() throws InterruptedException {
        for (RecycleBin been : this.recycleBinsPool) {
            cleanBin(been);
        }
        System.out.println(this.name + " has cleaned the floor" );
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
