import java.util.LinkedList;

public class Shelf {

	private int height;
	private int id;
	
	private LinkedList<Row> rows = new LinkedList<Row>();
	
	public Shelf(){
		this.height = 0;
		this.id = 0;
	}
	
	public Shelf(int id, int height){
		this.height = height;
		this.id =id;
	}

	public Shelf(int id, Row currRow) {
		this.id = id;
		this.rows.add(currRow);
		this.height = currRow.getHeight();
	}

	public boolean CanContains(Row currRow) {
		int currWidth = 0;
		
		for (Row r : rows) {
			currWidth += r.getWidth();
		}
		currWidth += currRow.getWidth();
		
		if(this.height >= currRow.getHeight() && currWidth <= 10){
			return true;
		}
		return false;
	}

	public boolean BetterThan(Row currRow, Shelf currShelf) {
		int currWidth = 0;
		int widthToTest = 0;
		for (Row r : rows) {
			widthToTest += r.getWidth();
		}
		widthToTest += currRow.getWidth();
		
		for (Row r : currShelf.rows) {
			currWidth += r.getWidth();
		}
		currWidth += currRow.getWidth();;
		
		if(widthToTest >= currWidth || (widthToTest <= 10 && currWidth > 10)){
			return true;
		} else {
			return false;
		}
	}

	public void AddRow(Row currRow) {
		int y = 0;
		for (Row r : rows) {
			for (Part p : r.getParts()) {
				p.setY1(y);
			}
			y += r.getWidth();
		}
		rows.add(currRow);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public LinkedList<Row> getRows() {
		return rows;
	}

	public void setRows(LinkedList<Row> rows) {
		this.rows = rows;
	}
}
