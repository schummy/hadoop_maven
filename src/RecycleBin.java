/**
 * Created by user on 9/18/15.
 */
public class RecycleBin {
    private boolean _isEmpty;
    private String _coordinate;

    public String get_coordinate() {
        return _coordinate;
    }

    public void set_coordinate(String _coordinate) {
        this._coordinate = _coordinate;
    }

    public boolean is_isEmpty() {
        return _isEmpty;
    }

    public RecycleBin(String coordinate) {
        this._isEmpty = true;
        this._coordinate = coordinate;
    }

    public void set_isEmpty(boolean _isEmpty) {
        this._isEmpty = _isEmpty;
    }
}
