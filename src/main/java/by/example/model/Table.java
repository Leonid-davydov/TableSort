package by.example.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Table {
    ArrayList<Row> table;

    public Table(ArrayList<Row> table) {
        this.table = table;
    }

    public ArrayList<Row> getTable() {
        return table;
    }

    public void sort(Comparator<Row> comparator) {
        table.sort(comparator);
    }
}
