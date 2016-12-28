import java.util.LinkedList;

public class Chamber extends Box{
	
	public LinkedList<Shelf> shelves = new LinkedList<Shelf>();
	
	public Chamber(int id, int x1, int y1, int z1, int x2, int y2, int z2) {
		super(id, x1, y1, z1, x2, y2, z2);
	}

	public void Fill(LinkedList<Part> allParts){
		
	}

	private void GeneratePythonLine(Part part, LinkedList<String> console, int currX, int currY, int currZ) {
		console.add("box"+part.getId()+" = doc.addObject('Part::Box','BOX_"+part.getId()+"')");
		console.add("box"+part.getId()+".Length = "+part.getX2() *10 );
		console.add("box"+part.getId()+".Width = "+part.getY2() * 10);
		console.add("box"+part.getId()+".Height = "+part.getZ2() * 10);
		console.add("box"+part.getId()+".Placement.Base.x = " + currX * 10);
		console.add("box"+part.getId()+".Placement.Base.y = " + currY * 10);
		console.add("box"+part.getId()+".Placement.Base.z = " + currZ * 10);	
		console.add("Gui.ActiveDocument.ActiveObject.ShapeColor = (" + part.getX2() /10.0 +","+part.getY2()/10.0+","+part.getZ2()/10.0+")");	
	}

	public void AddShelf(int heigt) {
		int id = this.shelves.size();
		this.shelves.add(new Shelf(id, heigt));
	}

}
