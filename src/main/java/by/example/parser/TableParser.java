package by.example.parser;

import by.example.mappers.RowMapper;
import by.example.model.Row;
import by.example.model.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TableParser {
    private static final String inPath = "src/main/resources/in.txt";
    private static final String outPath = "src/main/resources/out.txt";

    public Table read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(inPath)))){
            ArrayList<Row> table = new ArrayList<>();

            String line = reader.readLine();
            Row row;

            while (line != null) {
                row = RowMapper.map(line);
                table.add(row);

                line = reader.readLine();
            }

            return new Table(table);
        }
    }

    public void write(Table table) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outPath)))) {
            for (Row row : table.getTable()) {
                writeRow(writer, row);
            }

            writer.flush();
        }
    }

    private void writeRow(BufferedWriter writer, Row row) throws IOException {
        StringBuilder line = new StringBuilder();
        Iterator<Object> iterator = row.iterator();

        while (iterator.hasNext()) {
            line.append(iterator.next());
            if (iterator.hasNext()) {
                line.append("\t");
            }
        }

        line.append("\n");
        writer.append(line);
    }
}
