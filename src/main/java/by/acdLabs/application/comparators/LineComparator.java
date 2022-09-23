package by.acdLabs.application.comparators;

import java.util.Comparator;
import java.util.List;

public class LineComparator implements Comparator<List<Object>> {
    private final Comparator<Object> fieldComparator = new FieldComparator();

    public int compare(List<Object> o1, List<Object> o2) {
        int minSize = Integer.min(o1.size(), o2.size());

        for (int i = 0; i < minSize; i++) {
            if (fieldComparator.compare(o1.get(i), o2.get(i)) != 0) {
                return fieldComparator.compare(o1.get(i), o2.get(i));
            }
        }

        return Integer.compare(o1.size(), o2.size());
    }
}
