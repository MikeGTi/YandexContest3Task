package training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserTextTable {

    String table;

    String rowDelimiter="\n";

    String columnsDelimiter = "\\|";

    public ParserTextTable(String table) {
        this.table = table;
    }
    public ParserTextTable(String table, String columnsDelimiter) {
        this.table = table;
        this.columnsDelimiter = columnsDelimiter;
    }

    public ParserTextTable(String table, String rowDelimiter, String columnsDelimiter) {
        this.table = table;
        this.rowDelimiter = rowDelimiter;
        this.columnsDelimiter = columnsDelimiter;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setRowDelimiter(String rowDelimiter) {
        this.rowDelimiter = rowDelimiter;
    }

    public void setColumnsDelimiter(String columnsDelimiter) {
        this.columnsDelimiter = columnsDelimiter;
    }

    public List<Map<String,String>> parse(){
        String[] parsedTable = table.split(rowDelimiter);
        String[] titles = parsedTable[0].split(columnsDelimiter);
        String[] parsedRow;

        List<Map<String,String>> list = new ArrayList<>();

        for (int i = 1; i < parsedTable.length; i++) {
            parsedRow = parsedTable[i].split(columnsDelimiter);
            Map<String, String> rowMap = new HashMap<>() {  };
            for (int j = 0; j < parsedRow.length; j++) {
                rowMap.put(titles[j], parsedRow[j]);
            }
            list.add(rowMap);
        }
        return list;
    }

}
