package by.example;

import by.example.comparators.FieldComparator;
import by.example.comparators.RowComparator;
import by.example.model.Table;
import by.example.parser.TableParser;

import java.io.IOException;

public class TableSort {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Table Sort application");

            TableParser parser = new TableParser();
            Table table = parser.read();
            System.out.println("Table is read");

            table.sort(new RowComparator(new FieldComparator()));
            System.out.println("Table is sorted");

            parser.write(table);
            System.out.println("Table is written to file");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
