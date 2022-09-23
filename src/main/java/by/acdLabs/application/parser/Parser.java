package by.acdLabs.application.parser;

import by.acdLabs.application.converter.Converter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String inPath = "src/main/resources/in.txt";
    private static final String outPath = "src/main/resources/out.txt";

    public List<List<Object>> read() throws IOException {
        List<List<Object>> table = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(inPath)));

        String line = reader.readLine();
        List<Object> row;

        while (line != null) {
            line += "a";
            row = Arrays.stream(line.split("\t")).map(Converter::convert).collect(Collectors.toList());
            String lastString = row.get(row.size() - 1).toString();
            row.remove(row.size() - 1);
            Object correctLast = Converter.convert(lastString.substring(0, lastString.length() - 1));
            row.add(correctLast);
            table.add(row);

            line = reader.readLine();
        }

        return table;
    }

    public void write(List<List<Object>> table) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outPath)));
        StringBuilder row;

        for (List<Object> line : table) {
            row = new StringBuilder();
            Iterator<Object> iterator = line.iterator();

            while (iterator.hasNext()) {
                row.append(iterator.next());
                if (iterator.hasNext()) {
                    row.append("\t");
                }
            }

            row.append("\n");
            writer.append(row);
        }

        writer.flush();
    }
}
