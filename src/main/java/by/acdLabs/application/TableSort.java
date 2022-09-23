package by.acdLabs.application;

import by.acdLabs.application.comparators.FieldComparator;
import by.acdLabs.application.comparators.LineComparator;
import by.acdLabs.application.converter.Converter;
import by.acdLabs.application.parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TableSort {
    private static final String inPath = "src/main/resources/in.txt";
    private static final String outPath = "src/main/resources/out.txt";

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        ArrayList<List<Object>> table = (ArrayList<List<Object>>) parser.read();
        table.sort(new LineComparator());
        parser.write(table);

    }
}
