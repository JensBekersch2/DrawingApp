package model;
import javafx.scene.paint.Color;

/**
 * Circle
 * Berechnen der Fläche und des Umfangs eines Kreises
 * 
 * @author Jens Bekersch (bekersch@th-brandenburg.de)
 * @version 1.00, 11.2017
 */
public class MCircle extends Figure {
	/**
	 * Konstruktor
	 * ohne Parameter zum Aufruf der Klasse ohne Parameter
	 * Berechnung mit Initialwerten
	 */
	public MCircle() {
		super();
	}
	/**
	 * Konstruktor
	 * Mit Parameter für die individuelle Berechnung 
	 * @param x Position x
	 * @param y Position y
	 * @param a Radius
	 */
	public MCircle(double x, double y, double a) { 
		super();
		this.x = x;
		this.y = y;
		this.a = a;
	}
	/**
	 * Konstruktor
	 * Mit Parameter für die individuelle Berechnung 
	 * @param x Position x
	 * @param y Position y
	 * @param a Radius
	 * @param fillColor Füllfarbe
	 * @param lineColor Linienfarbe
	 */	
	public MCircle(double x, double y, double a, Color fillColor, Color lineColor) { 
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.fillColor = fillColor;
		this.lineColor = lineColor;
	}		
	/**
	 * Getter
	 * @return
	 */
	/*
	public double getA() {
		return this.a;
	}
	*/	
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
		System.out.println("Kreis:");
		System.out.println("Der Umfang beträgt: " + this.circumference());
		System.out.println("Die Fläche beträgt: " + this.area()) ;		
	}
	/**
	 * Berechnung des Umfangs
	 * @return umfang
	 */
	@Override
	public double circumference() {
		return 2*pi*this.a;
	}
	/**
	 * Berechnung der Fläche
	 * @return fläche
	 */
	@Override
	public double area() {
		return pi*Math.pow(this.a, 2);		
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

}
