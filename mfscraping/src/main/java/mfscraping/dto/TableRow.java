package mfscraping.dto;

public class TableRow {

	private final int code;
	private final String name;

	private TableRow(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static TableRow create( int code, String name) {
		return new TableRow( code, name);
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
}
