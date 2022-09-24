package by.example.mappers;

public class FieldMapper {
    private FieldMapper() {
    }

    public static Object map(String field) {
        try {
            return Long.parseLong(field);
        } catch (NumberFormatException ignored) {
            //If a field does not match an Long, it may still match a Double or a String
        }

        try {
            return Double.parseDouble(field);
        } catch (NumberFormatException ignored) {
            //If a field does not match Double it is a String
        }

        return field;
    }
}
