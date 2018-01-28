package model;
import javafx.scene.paint.Color;

/**
 * Figure
 * Abstrakte Elternklasse von geometrischen Figuren
 * 
 * @author Jens Bekersch (bekersch@th-brandenburg.de)
 * @version 1.00, 11.2017
 */
public abstract class Figure {
	/** Kreizahl PI */
	public double pi = Math.PI;
	public double x = 0, y = 0, a = 1, b = 3, breite = 0, hoehe = 0;
	public String colors;
	public Color fillColor = Color.YELLOW;
	public Color lineColor = Color.BLACK;
	/**
	 * Konstruktor
	 * ohne Parameter zum Aufruf der Klasse ohne Parameter
	 * Berechnung mit Initialwerten
	 */	
	public Figure() { }
	/**
	 * Konstruktor
	 * Mit Parameter für die individuelle Berechnung 
	 * @param x Position x
	 * @param y Position y
	 * @param a 
	 * @param b 
	 */	
	public Figure(double x, double y, double a, double b) {
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
	public Figure(double x, double y, double a, double b, Color fillColor, Color lineColor) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
		this.fillColor = fillColor;
		this.lineColor = lineColor;
	}
	/**
	 * Abstrakte Methoden	
	 */
	public abstract void show();
	public abstract double circumference();
	public abstract double area();
	public abstract String getForm();
	/**
	 * Setter Position x und y
	 * @param x
	 * @param y
	 */
	public void setPos(double x, double y) {
		this.x = x; this.y = y;
	}
	/**
	 * Setter Dimension
	 * @param a
	 * @param b
	 */	
	public void setDim(double a, double b) {
		this.a = a; this.b = b;
	}
	/**
	 * Setter Farben
	 * @param fillColor
	 * @param lineColor
	 */
	public void setColors(Color fillColor, Color lineColor) {
		this.fillColor = fillColor; this.lineColor = lineColor;
	}
	/**
	 * Setter Position x
	 * @return x
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Setter Position y
	 * @return y
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Setter Position x
	 * @return x
	 */
	public void setA(double a) {
		this.a = a;
	}
	/**
	 * Setter Position y
	 * @return y
	 */
	public void setB(double b) {
		this.b = b;
	}	
	/**
	 * Getter Position x
	 * @return x
	 */
	public double getX() {
		return this.x;
	}
	/**
	 * Getter Position y
	 * @return y
	 */
	public double getY() {
		return this.y;
	}
	/**
	 * Getter Position a
	 * @return a
	 */
	public double getA() {
		return this.a;
	}
	/**
	 * Getter Position b
	 * @return b
	 */
	public double getB() {
		return this.b;
	}	
	/**
	 * Getter Breite der geometrischen Figur
	 * @return breite
	 */
	public double getWidth() {
		return breite;
	}
	/**
	 * Getter Höhe der geometrischen Figur
	 * @return hoehe
	 */	
	public double getHeight() {
		return hoehe;		
	}
	/**
	 * Farben anzeigen
	 * @return String Farben
	 */		
	public String getColors() {
		return "Farbe der Fläche: " + fillColor + " Farbe der Linie " + lineColor;
	}
	/**
	 * Textuelle Ausgabe der Figur
	 * @return String 
	 */		
	public String toString() {
		return this.getForm() + "hat die Farben" + this.getColors() + " ";		
	}
}
