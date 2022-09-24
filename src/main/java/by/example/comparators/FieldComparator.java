package by.example.comparators;

import java.util.Comparator;

public class FieldComparator implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Number && o2 instanceof String) {
            return -1;
        } else if (o1 instanceof String && o2 instanceof Number) {
            return 1;
        } else if (o1 instanceof Number && o2 instanceof Number) {
            return Double.compare(((Number) o1).doubleValue(), ((Number) o2).doubleValue());
        } else {
            return o1.toString().compareTo(o2.toString());
        }
    }
}
