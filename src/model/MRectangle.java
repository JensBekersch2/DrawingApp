package model;
import javafx.scene.paint.Color;

/**
 * Rectangle
 * Berechnen der Fläche und des Umfangs eines Rechtecks
 * 
 * @author Jens Bekersch (bekersch@th-brandenburg.de)
 * @version 1.00, 11.2017
 */
public class MRectangle extends Figure {
	/**
	 * Konstruktor
	 * ohne Parameter zum Aufruf der Klasse ohne Parameter
	 * Berechnung mit Initialwerten
	 */	
	public MRectangle() {
		super();
	}
	/**
	 * Konstruktor
	 * Mit Parameter für die individuelle Berechnung 
	 * @param x Position x
	 * @param y Position y
	 * @param a 
	 * @param b 
	 */
	public MRectangle(double x, double y, double a, double b) { 
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
	/**
	 * Konstruktor
	 * Mit Parameter für die individuelle Berechnung 
	 * @param x Position x
	 * @param y Position y
	 * @param a 
	 * @param b 
	 * @param fillColor Füllfarbe
	 * @param lineColor Linienfarbe
	 */	
	public MRectangle(double x, double y, double a, double b, Color fillColor, Color lineColor) { 
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
		this.fillColor = fillColor;
		this.lineColor = lineColor;
	}
	/**
	 * Getter
	 * @return seiteA
	 */
	public double getSeiteA() {
		return a;
	}
	/**
	 * Setter
	 * @param seiteA
	 */
	public void setSeiteA(double a) {
		this.a = a;
	}
	/**
	 * Getter
	 * @return seiteB
	 */
	public double getSeiteB() {
		return b;
	}
	/**
	 * Setter
	 * @param seiteB
	 */
	public void setSeiteB(double b) {
		this.b = b;
	}	
	/**
	 * 	Form der geometrischen Figur
	 */
	@Override
	public String getForm() {
		return this.getClass().getName();
	}	
	/**
	 * Ausgabe der Berechnung auf der Konsole
	 */
	@Override
	public void show() {
		System.out.println("Rectangle");
		System.out.println("Der Umfang beträgt: " + this.circumference());
		System.out.println("Die Fläche beträgt: " + this.area()) ;		
	}	
	/**
	 * Umfang
	 * @return umfang
	 */
	@Override
	public double circumference() {
		return 2*this.a+2*this.b;
	}
	/**
	 * Flächeninhalt
	 * @return flächeninhalt
	 */
	@Override
	public double area() {
		return this.a*this.b;	
	}	
	/*
	 * (non-Javadoc)
	 * @see drawing.Figure#toString()
	 */	
	@Override
	public String toString() {
		return this.getForm() + " hat einen Flächeninhalt von " + this.area() + 
				" und einen Umfang von " + this.circumference();		
	}

	@Override
	public void setA(double a) {
		this.a = a;
	}
	@Override
	public void setB(double b) {
		this.b = b;
	}	
}
