package mfscraping.dto;

import java.util.ArrayList;
import java.util.List;

public class TableMeta {
	String tableName;
	List<String> columnNames;
	List<TableRow> rows;
	TableMeta childTable;
	
	
	public TableMeta(String string){
		tableName = string;
		rows = new ArrayList<>();
	}
	
	public void add(TableRow create) {
		rows.add(create);
	}

	public List<TableRow> getRows() {
		return rows;
	}
	
	public String name() {
		return tableName;
	}
}
