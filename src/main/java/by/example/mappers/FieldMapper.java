package by.example.mappers;

public class FieldMapper {
    private FieldMapper() {
    }

    public static Object map(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException ignored) {
        }

        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException ignored) {
        }

        return s;
    }
}
