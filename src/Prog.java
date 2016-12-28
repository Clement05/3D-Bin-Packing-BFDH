import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Prog { 

	public static void main(String[] args) {
		//list of part to fill in chamber
		LinkedList<Part> allParts;
		//Python line for FCMacro script
		LinkedList<String> res;
		//Define optimization var
		boolean optimize = true;
		LinkedList<Chamber> chambers = new LinkedList<Chamber>();
		LinkedList<Row> rows = new LinkedList<Row>();
		LinkedList<Shelf> shelves = new LinkedList<Shelf>();
		Chamber currChamber;
		Part currPart;
		Row currRow = null;
		Shelf currShelf = null;
		
		for (String str : args) {
			String[] split = str.split("=");
			switch (split[0]) {
			case "optimize":
				optimize = Boolean.parseBoolean(split[1]);
				break;
			}
		}
		
		//Populate list of part to fill in chamber from text file
		allParts = Util.GeneratePartFromFileInput("C:/Users/girarcle/Desktop/instance2HeightSorted.txt");
		//Sort list by Z, Y and X decreasing
		Util.SortPart(allParts);
		//Define a new chamber
		Chamber myChamber = new Chamber(0,0,0,0,10,10,10);

		chambers.add(myChamber);
		currChamber = chambers.get(0);
		
		for (int i = 0; i < allParts.size(); i++) {
			currPart = allParts.get(i);
			boolean foundRow = false;
			for (int j = 0; j < rows.size(); j++) {
				if(rows.get(j).CanContains(currPart) && rows.get(j).BetterThan(currPart, currRow)){
					currRow = rows.get(j);
					foundRow = true;
				}
			}
			if(foundRow){
				currRow.AddPart(currPart);
			}
			else {
				int id = rows.size();
				currRow = new Row(id, currPart);
				rows.add(currRow);
				
			}
			System.out.println("add: "+currPart.toString());
			System.out.println(" in row: "+currRow.getId());
		}
		
		for (int i = 0; i < rows.size(); i++) {
			currRow = rows.get(i);
			boolean foundShelf = false;
			for (int j = 0; j < shelves.size(); j++) {
				if(shelves.get(j).CanContains(currRow) && shelves.get(j).BetterThan(currRow, currShelf)){
					currShelf = shelves.get(j);
					foundShelf = true;
				}
			}
			if(foundShelf){
				currShelf.AddRow(currRow);
			}
			else {
				int id = shelves.size();
				currShelf = new Shelf(id, currRow);
				shelves.add(currShelf);
				
			}
			System.out.println("add: "+currRow.toString());
			System.out.println(" in shelf: "+currShelf.getId());

		}
		//update region
		int z = 0;
		for (Shelf shelf : shelves) {
			int y = 0;
			for (Row row : shelf.getRows()) {
				for (Part part : row.getParts()) {
					part.setY1(y);
					part.setZ1(z);
					System.out.println(part.toString());
				}
				y += row.getWidth();
			}
			z += shelf.getHeight();
		}
	}
}
