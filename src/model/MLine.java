package model;
import javafx.scene.paint.Color;

/**
 * Line
 * Rückgabe/Ausgabe der Linienlänge
 * 
 * @author Jens Bekersch (bekersch@th-brandenburg.de)
 * @version 1.00, 11.2017
 */
public class MLine extends Figure {
	/**
	 * Konstruktor
	 * ohne Parameter zum Aufruf der Klasse ohne Parameter
	 * Berechnung mit Initialwerten
	 */	
	public MLine() {
		super();
	}
	/**
	 * Konstruktor
	 * Mit Parameter für die individuelle Berechnung 
	 * @param x Position x
	 * @param y Position y
	 * @param a Länge
	 */
	public MLine(double x, double y, double a, double b) { 
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
	 * @param a Länge
	 * @param fillColor Füllfarbe
	 * @param lineColor Linienfarbe
	 */	
	public MLine(double x, double y, double a, double b, Color fillColor, Color lineColor) { 
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
	 * @return linienlänge
	 */
	public double getLinienlaenge() {
		return a;
	}
	/**
	 * Setter
	 * @param linienlaenge
	 */
	public void setLinienlaenge(double a) {
		this.a = a;
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
		System.out.println("Die Länge der Linie beträgt: " + this.getLinienlaenge());	
	}
	
	@Override
	public double circumference() {
		return 0;
	}
	
	@Override
	public double area() {
		return 0;
	}	
	/*
	 * (non-Javadoc)
	 * @see drawing.Figure#toString()
	 */
	@Override
	public String toString() {
		return this.getForm() + " hat eine Länge von " + this.a;		
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
