package by.acdLabs.application.converter;

public class Converter {
    private Converter() {}

    public static Object convert(String s) {
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
