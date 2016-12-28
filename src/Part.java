import java.util.LinkedList;

public class Part extends Box {

public Part(int id, int x1, int y1, int z1, int x2, int y2, int z2) {
		super(id, x1, y1, z1, x2, y2, z2);
		// TODO Auto-generated constructor stub
	}

public String toString(){
	return "{ 'Part': {'id': '"+this.getId() +"', 'coords': {'x': '"+this.getX1()+"','y': '"+this.getY1()+"','z': '"+this.getZ1()+"' } , 'size': {'x': '"+this.getX2()+"','y': '"+this.getY2()+"','z': '"+this.getZ2()+"' } } }";		
	}
}