import java.util.ArrayList;

/**
 * Created by user on 9/18/15.
 */
public class Cleaner implements Runnable{
    private String _name;
    private Double _performance;

    private ArrayList<RecycleBin> _floor;

    public void assignFloor(ArrayList<RecycleBin> _floor) {
        this._floor = _floor;
    }

    public Cleaner(String _name, Double _performance) {
        this._name = _name;
        this._performance = _performance;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Double get_performance() {
        return _performance;
    }

    public void set_performance(Double _performance) {
        this._performance = _performance;
    }

    public void cleanBeen(RecycleBin been) throws InterruptedException {
        if (!been.is_isEmpty())
        {
            double time=400*this._performance;
            Thread.sleep((long) time);
            been.set_isEmpty(true);
            System.out.println(this._name+" has cleaned the bin "+been.get_coordinate()+" in "+String.valueOf(time)+"ms" );
        }
    }

    public void cleanFloor() throws InterruptedException {
        for (RecycleBin been : this._floor) {
            cleanBeen(been);
        }
        System.out.println(this._name+" has cleaned the floor" );
    }

    @Override
    public void run(){
        while(true) {
            try {
                cleanFloor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
