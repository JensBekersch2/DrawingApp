package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Drawing Model
 * 
 * @author Jens Bekersch (bekersch@th-brandenburg.de)
 * @version 1.00, 11.2017
 */
public class Drawing  {
	/** Deklaration und Intialisierung der Liste */
	List<Figure> shapes = new ArrayList<Figure>(); 
	/**
	 * Konstruktor ohne Parameter
	 */
	public Drawing() { }
	/**
	 * Konstruktor mit Parameter
	 */	
	public Drawing(List<Figure> shapes) {
		this.shapes = shapes;
	}
	/**
	 * Getter
	 * @param id
	 * @return
	 */
	public Figure getShapes(int id) {
		return shapes.get(id);
	}
	/**
	 * Setter
	 * @param figure
	 */
	public void setShapes(Figure figure) {
		this.shapes.add(figure);
	}
	/**
	 * Lösche Element
	 * @param id
	 */
	public void removeElement(int id) {
		this.shapes.remove(id);
	}
	/**
	 * Gebe die Anzahl der Elemente in der Liste aus
	 * @return
	 */
	public int getSize() {
		return this.shapes.size();
	}
	/**
	 * Gebe den Inhalt der Liste auf der Konsole aus
	 */
	public void printElements() {
		System.out.println("Menge der enthaltenen Elemente: " + this.shapes.size() + "\r\n");
		for(Figure element : this.shapes) {
			System.out.println(element.getForm() + ":");
			if(element.getForm() == "Line") {
				System.out.println("Position (x|y): " + element.getX() + "," + element.getY());
				element.show();		
				System.out.println("\r\n");
			} else {
				System.out.println("Position (x|y): " + element.getX() + "," + element.getY());
				System.out.println("Umfang: " + element.circumference());
				System.out.println("Flächeninhalt: " + element.area() + "\r\n");
			}
		}
	}
}
