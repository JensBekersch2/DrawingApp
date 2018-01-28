package model;

import javafx.scene.paint.Color;

/**
 * Ellipse
 * Berechnen der Fläche und des Umfangs einer Ellipse
 * 
 * @author Jens Bekersch (bekersch@th-brandenburg.de)
 * @version 1.00, 11.2017
 */
public class MEllipse extends Figure {
	/**
	 * Konstruktor
	 * ohne Parameter zum Aufruf der Klasse ohne Parameter
	 * Berechnung mit Initialwerten
	 */	
	public MEllipse() {
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
	public MEllipse(double x, double y, double a, double b) { 
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
	public MEllipse(double x, double y, double a, double b, Color fillColor, Color lineColor) { 
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
	 * @return halbachseA
	 */
	public double getHalbachseA() {
		return a;
	}
	/**
	 * Setter
	 * @param halbachseA
	 */
	public void setHalbachseA(double a) {
		this.a = a;
	}
	/**
	 * Getter
	 * @return halbachseB
	 */
	public double getHalbachseB() {
		return b;
	}
	/**
	 * Setter
	 * @param halbachseB
	 */
	public void b(double b) {
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
		System.out.println("Ellipse:");
		System.out.println("Der Umfang beträgt: " + this.circumference());
		System.out.println("Die Fläche beträgt: " + this.area()) ;		
	}	
	/**
	 * Berechnung des Umfangs
	 * @return umfang
	 */
	@Override
	public double circumference() {
		double t = (this.a-this.b)/(this.a+this.b);		
		return (this.a+this.b)*pi*(1+(3*Math.pow(t, 2)/10+(Math.sqrt(4-3*Math.pow(t, 2)))));
	}
	/**
	 * Berechnung des Flächeninhaltes
	 * @return flächeninhalt
	 */	
	@Override
	public double area() {
		return pi*this.a*this.b;
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
