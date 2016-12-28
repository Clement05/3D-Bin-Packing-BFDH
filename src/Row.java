import java.util.LinkedList;

public class Row {

	private int height;
	private int width;
	private int id;
	
	private LinkedList<Part> parts = new LinkedList<Part>();
	
	public Row(){
		this.width = 0;
		this.id = 0;
	}
	
	public Row(int id, int width){
		this.width = width;
		this.id = id;
	}

	public Row(int id, Part currPart) {
		this.id = id;
		this.parts.add(currPart);
		this.width = currPart.getY2();
		this.height = currPart.getZ2();
	}

	public boolean CanContains(Part currPart) {
		int currDepth = 0;
		
		for (Part p : parts) {
			currDepth += p.getX2();
		}
		 currDepth += currPart.getX2();
		
		if(this.width >= currPart.getY2() && currDepth <= 10){
			return true;
		}
		return false;
	}

	public void AddPart(Part part) {
		int x = 0;
		for (Part p : parts) {
			x += p.getX2();
		}
		part.setX1(x);
		parts.add(part);
	}

	public boolean BetterThan(Part part, Row currRow) {
		int currDepth = 0;
		int depthToTest = 0;
		for (Part p : parts) {
			depthToTest += p.getX2();
		}
		depthToTest += part.getX2();
		
		for (Part p : currRow.parts) {
			currDepth += p.getX2();
		}
		currDepth += part.getX2();
		
		if(depthToTest >= currDepth || (depthToTest <= 10 && currDepth > 10)){
			return true;
		} else {
			return false;
		}
	}
	
	public String toString(){
		return "{ 'Row': {'id': '"+this.id +"', 'width': '"+this.width+"',  'height': '"+this.height+"'} }";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public LinkedList<Part> getParts() {
		return parts;
	}

	public void setParts(LinkedList<Part> parts) {
		this.parts = parts;
	}
}
