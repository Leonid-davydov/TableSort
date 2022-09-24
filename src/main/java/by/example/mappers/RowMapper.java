package by.example.mappers;

import by.example.model.Row;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RowMapper {
    public static Row map(String line) {
        List<Object> row;
        String lastString;
        Object correctLast;

        line += "a";
        row = Arrays.stream(line.split("\t")).map(FieldMapper::map).collect(Collectors.toList());
        lastString = row.get(row.size() - 1).toString();
        row.remove(row.size() - 1);
        correctLast = FieldMapper.map(lastString.substring(0, lastString.length() - 1));
        row.add(correctLast);

        return new Row(row);
    }
}
