package by.acdLabs.application.comparators;

import java.util.Comparator;
import java.util.List;

public class FieldComparator implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Number && o2 instanceof String) {
            return -1;
        } else if (o1 instanceof String && o2 instanceof Number) {
            return 1;
        } else if (o1 instanceof Number && o2 instanceof Number) {
            return Double.compare(((Number) o1).doubleValue(), ((Number) o2).doubleValue());
        } if (o1 instanceof String && o2 instanceof String) {
            return ((String) o1).compareTo((String) o2);
        } else {
            throw new IllegalArgumentException("Objects could be only numbers or strings");
        }
    }
}
