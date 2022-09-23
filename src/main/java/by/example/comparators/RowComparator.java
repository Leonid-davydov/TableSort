package by.example.comparators;

import by.example.model.Row;

import java.util.Comparator;

public class RowComparator implements Comparator<Row> {
    private final Comparator<Object> fieldComparator;

    public RowComparator(Comparator<Object> fieldComparator) {
        this.fieldComparator = fieldComparator;
    }

    public int compare(Row row1, Row row2) {
        int minSize = Integer.min(row1.size(), row2.size());

        for (int i = 0; i < minSize; i++) {
            if (fieldComparator.compare(row1.get(i), row2.get(i)) != 0) {
                return fieldComparator.compare(row1.get(i), row2.get(i));
            }
        }

        return Integer.compare(row1.size(), row2.size());
    }
}
