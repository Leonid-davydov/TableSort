package by.example.model;

import java.util.Iterator;
import java.util.List;

public class Row {
    private List<Object> row;

    public Row(List<Object> row) {
        this.row = row;
    }

    public Object get(int index) {
        return row.get(index);
    }

    public int size() {
        return row.size();
    }

    public Iterator<Object> iterator() {
        return row.iterator();
    }
}
