package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.MCircle;
import model.MEllipse;
import model.MLine;
import model.MRectangle;
import model.Drawing;

public class DrawingApp extends Application {

    private static final double WIDTH = 950;
    private static final double HEIGHT = 780;
    
    Scene scene;
    BorderPane borderPane;
    Group group;
    GridPane gridPane;
    
    Label lblIndex, lblX, lblY, lblA, lblB, lblForm, lblUmfang, lblFlaeche;
    TextField txtIndex, txtX, txtY, txtA, txtB, txtForm, txtUmfang, txtFlaeche;
    
    ContextMenu contextMenu;
    MenuItem itemCircle, itemEllipse, itemLine, itemPolygon, itemRectangle, itemSquare, itemTriangle;
    
    Drawing shapes = new Drawing();
    
    public double x0,x1,y0,y1;
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// initialize BorderPane
			borderPane = new BorderPane();
			// Group
			group = new Group();
            Rectangle rectangle = new Rectangle(0, 0, 950, 700);
            rectangle.setFill(Color.rgb(0,150,136));
            group.getChildren().addAll(rectangle);
			// Toolbar
			gridPane = new GridPane();
			gridPane.setHgap(5);
			gridPane.setVgap(5);
			gridPane.setPadding(new Insets(5, 5, 5, 5));
			
			lblIndex = new Label("Index");
			gridPane.add(lblIndex, 0, 0);
			txtIndex = new TextField();
			gridPane.add(txtIndex, 1, 0);
			txtIndex.setOnKeyPressed(event ->  {
	            if (event.getCode().equals(KeyCode.ENTER))
	            {
	            	int txtToInt;
	            	try {
	            		txtToInt = Integer.parseInt(txtIndex.getText().trim());
	            	} catch (NumberFormatException e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Fehler");
						alert.setHeaderText(null);
						alert.setContentText("Bitte geben Sie nur Zahlen zur Auswahl des Form-Index an!");
						alert.showAndWait();		
						return;	            		
	            	}
					if(txtToInt < 1 || txtToInt > shapes.getSize()) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Fehler");
						alert.setHeaderText(null);
						alert.setContentText("Die Form existiert nicht! Insgesamt sind " + shapes.getSize() + " Elemente auf der Zeichenfläche.");
						alert.showAndWait();		
						return;
					}
					getForm(txtToInt);
			    }
		    });
		      
			lblX = new Label("X");
			gridPane.add(lblX, 2, 0);
			txtX = new TextField();
			gridPane.add(txtX, 3, 0);
			
			lblY = new Label("Y");
			gridPane.add(lblY, 4, 0);
			txtY = new TextField();
			gridPane.add(txtY, 5, 0);
			
			lblA = new Label("A");
			gridPane.add(lblA, 6, 0);
			txtA = new TextField();
			gridPane.add(txtA, 7, 0);
			
			lblB = new Label("B");
			gridPane.add(lblB, 8, 0);
			txtB = new TextField();
			gridPane.add(txtB, 9, 0);
			
			lblForm = new Label("Form");
			gridPane.add(lblForm, 0, 1);
			txtForm = new TextField();
			txtForm.setDisable(true);
			if(txtForm.getText().isEmpty()) {
				txtForm.setText("Kreis");
			}
			gridPane.add(txtForm, 1, 1);
			
			lblUmfang = new Label("Umfang");
			gridPane.add(lblUmfang, 2, 1);
			txtUmfang = new TextField();
			txtUmfang.setDisable(true);
			gridPane.add(txtUmfang, 3, 1);
			
			lblFlaeche = new Label("Fläche");
			gridPane.add(lblFlaeche, 4, 1);			
			txtFlaeche = new TextField();
			txtFlaeche.setDisable(true);
			gridPane.add(txtFlaeche, 5, 1);   
			
			Button changeButton = new Button();
			changeButton.setText("Figur anpassen");
			changeButton.setOnAction( event -> {
				changeFigure();
			});
			gridPane.add(changeButton, 6, 1, 2, 1);  
			// add Elements to BorderPane
			borderPane.setCenter(group);		   
		    borderPane.setBottom(gridPane);	 
		    // Scene 
		    // show Stage
	        scene = new Scene(borderPane, WIDTH, HEIGHT);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("DrawingApp");
	        primaryStage.show();        
			// Context Menu
	        ContextMenu contextMenu = new ContextMenu();
	 
	        itemCircle = new MenuItem("Kreis");
	        itemCircle.setOnAction(e -> chooseFigure("Kreis"));
	 
	        itemEllipse = new MenuItem("Ellipse");
	        itemEllipse.setOnAction(e -> chooseFigure("Ellipse"));
	        
	        itemLine = new MenuItem("Linie");
	        itemLine.setOnAction(e -> chooseFigure("Linie"));
	        
	        itemRectangle = new MenuItem("Rechteck");
	        itemRectangle.setOnAction(e -> chooseFigure("Rechteck"));
	        
	        itemSquare = new MenuItem("Quadrat");
	        itemSquare.setOnAction(e -> chooseFigure("Quadrat"));
	        
	        contextMenu.getItems().addAll(itemCircle, itemEllipse, itemLine, itemRectangle, itemSquare);
	 
	        scene.setOnContextMenuRequested(me ->{
	        	contextMenu.show(group, me.getScreenX(), me.getScreenY());
	        });			
	        // set figures
	        group.setOnMousePressed(me ->{
	        	MouseButton button = me.getButton();
	        	if(button==MouseButton.PRIMARY){ 
	        		scene.setCursor(Cursor.CROSSHAIR);
	        		this.x0 = me.getX(); this.y0 = me.getSceneY();
	        	}
			   });
	        group.setOnMouseReleased(me->{
	        	MouseButton button = me.getButton();
	        	if(button==MouseButton.PRIMARY){ 
	        	scene.setCursor(Cursor.DEFAULT);
	        	this.x1 = me.getSceneX(); this.y1 = me.getSceneY();
	        	if (this.x1 < 0.1 || this.x1 > 949.9 || this.y1 < 0.1 || this.y1 > 699.9) {
					outOfBoundsAlert();	
					return;	
	        	}
	        	

					switch(txtForm.getText()) {
					case "Kreis":
						double x,y,r,querschnittX,querschnittY;		
						if(this.x0<this.x1) {
						  x = ((this.x1 - this.x0)/2) + this.x0;
						  querschnittX = this.x1 - this.x0;						  
						} else {  
						  x = ((this.x0 - this.x1)/2)+this.x1;	
						  querschnittX = this.x0 - this.x1;	
						}
						if(this.y0<this.y1) {
						  y = ((this.y1 - this.y0)/2)+this.y0;
						  querschnittY = this.y1 - this.y0;	
						} else {
						  y = ((this.y0 - this.y1)/2)+this.y1;	
						  querschnittY = this.y0 - this.y1;	
						}			
						if(querschnittX>querschnittY)
						  r = querschnittX/2;
						else 
						  r = querschnittY/2;	

						if((x+r)>949.9 || (x-r) < 0.1) {
							outOfBoundsAlert();	
							return;	
						} else if((y+r)>699.9 || (y-r) < 0.1) {
							outOfBoundsAlert();	
							return;		        	
	        			}
						MCircle circle = new MCircle(x, y, r);
						shapes.setShapes(circle);
						repaint();
						break;
					case "Ellipse":
						double rX,rY,centerX,centerY;
						if(this.x0<this.x1) {
							centerX = ((this.x1 - this.x0)/2)+this.x0;
							rX = (this.x1 - this.x0)/2;
						} else {
							centerX = ((this.x0 - this.x1)/2)+this.x1;
							rX = (this.x0 - this.x1)/2;
						}
						if(this.y0<this.y1) {
							centerY = ((this.y1 - this.y0)/2)+this.y0;
							rY = (this.y1 - this.y0)/2;
						} else {
							centerY = ((this.y0 - this.y1)/2)+this.y1;	
							rY = (this.y0 - this.y1)/2;
						}
						if((centerX+rX)>949.9 || (centerX-rX) < 0.1) {
							outOfBoundsAlert();	
							return;	
						} else if((centerY+rY)>699.9 || (centerY-rY) < 0.1) {
							outOfBoundsAlert();	
							return;		        	
	        			}						
						MEllipse ellipse = new MEllipse(centerX, centerY, rX, rY);
						shapes.setShapes(ellipse);
						repaint();
						break;
					case "Linie":
						MLine line = new MLine(this.x0, this.y0, this.x1, this.y1);
						shapes.setShapes(line);
						repaint();
						break;
					case "Rechteck":
						double xStart,yStart,wr,yr;
						if(this.x0<this.x1) {
							wr = (this.x1-this.x0);
							xStart = this.x0;
						} else {
							wr = (this.x0-this.x1);
							xStart = this.x1;
						}
						if(this.y0<this.y1) {
							yr = (this.y1-this.y0);
							yStart = this.y0;
						} else {
							yr = (this.y0-this.y1);
							yStart = this.y1;
						}
						
						MRectangle mRectangle = new MRectangle(xStart,yStart,wr,yr);
						shapes.setShapes(mRectangle);
						repaint();
						break;
					case "Quadrat":
						double xqStart,yqStart,wq,yq;
						if(this.x0<this.x1) {
							wq = (this.x1-this.x0);
							xqStart = this.x0;
						} else {
							wq = (this.x0-this.x1);
							xqStart = this.x1;
						}
						if(this.y0<this.y1) {
							yq = (this.y1-this.y0);
							yqStart = this.y0;
						} else {
							yq = (this.y0-this.y1);
							yqStart = this.y1;
						}
						if(wq>yq) 
							yq=wq;
						else
							wq=yq;
						if((xqStart+wq)>949.9) {
							outOfBoundsAlert();	
							return;		    							
						} else if((yqStart+yq)>699.9) {
							outOfBoundsAlert();	
							return;		    							
						}
						MRectangle qRectangle = new MRectangle(xqStart,yqStart,wq,yq);
						shapes.setShapes(qRectangle);
						repaint();
						break;		
					}	
		        	getForm(shapes.getSize());	
	        	}
			});	        
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	private void changeFigure() {
		int formNumber = Integer.parseInt(txtIndex.getText().trim());
		int id = formNumber-1;
		double doubleX = 0.0;
		double doubleY = 0.0;
		double doubleA = 0.0;
		double doubleB = 0.0;	
		try {
			doubleX = Double.parseDouble(txtX.getText().trim());
			doubleY = Double.parseDouble(txtY.getText().trim());
			doubleA = Double.parseDouble(txtA.getText().trim());
			doubleB = Double.parseDouble(txtB.getText().trim());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Bitte geben Sie nur Zahlen für die Koordinaten und Zahlenwerte für A und B ein!");
			alert.showAndWait();				
		}
		
		switch(shapes.getShapes(id).getForm()) {
		case "model.MCircle":
				if((doubleX-doubleA) < 0.1 || (doubleX + doubleA) > 949.9 || (doubleY-doubleA) < 0.1 || (doubleY + doubleA) > 699.9) {
					outOfBoundsAlert();
					return;
				} else if (doubleA < 0) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Fehler");
					alert.setHeaderText(null);
					alert.setContentText("Bitte geben Sie positive Werte für die Größe Ihres Rechtecks an!");
					alert.showAndWait();						
				} else {
					shapes.getShapes(id).setX(doubleX);
					shapes.getShapes(id).setY(doubleY);
					shapes.getShapes(id).setA(doubleA);
				}
			break;
		case "model.MEllipse":
			if((doubleX-doubleA)<0.1 || (doubleX+doubleA)>949.9 || (doubleY-doubleB)<0.1 || (doubleY+doubleB)>699.9) {
				outOfBoundsAlert();
				return;				
			} else if (doubleA < 0 || doubleB < 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Bitte geben Sie positive Werte für die Größe Ihres Rechtecks an!");
				alert.showAndWait();		
			} else {
				shapes.getShapes(id).setX(doubleX);
				shapes.getShapes(id).setY(doubleY);
				shapes.getShapes(id).setA(doubleA);
				shapes.getShapes(id).setB(doubleB);
			}
			break;
		case "model.MLine":
			if (doubleA < 0 || doubleB < 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Bitte geben Sie positive Werte für die Größe Ihres Rechtecks an!");
				alert.showAndWait();					
			} else if(doubleX < 0.1 && doubleX > 949.9 && doubleY < 0.1 && doubleY > 699.9) {
				outOfBoundsAlert();
				return;	
			} else {
				shapes.getShapes(id).setX(doubleX);
				shapes.getShapes(id).setY(doubleY);
				shapes.getShapes(id).setA(doubleA);
				shapes.getShapes(id).setB(doubleB);		
			}
			break;
		case "model.MRectangle": 
			if(doubleX < 0.1 || (doubleX + doubleA) > 949.9 || doubleY < 0.1 || (doubleY + doubleB) > 699.9) {
				outOfBoundsAlert();
				return;							
			} else if (doubleA < 0 || doubleB < 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Bitte geben Sie positive Werte für die Größe Ihres Rechtecks an!");
				alert.showAndWait();					
			} else {
				shapes.getShapes(id).setX(doubleX);
				shapes.getShapes(id).setY(doubleY);
				shapes.getShapes(id).setA(doubleA);
				shapes.getShapes(id).setB(doubleB);
			}
			break;
		}
		

		repaint();

	}
	
	private void chooseFigure(String figure) {
		txtIndex.setText("");
		txtX.setText("");
		txtY.setText("");
		txtA.setText("");
		txtB.setText("");
		txtB.setDisable(false);
		txtUmfang.setText("");
		txtFlaeche.setText("");
		switch(figure) {
		case "Kreis":
			txtForm.setText("Kreis");
			break;
		case "Ellipse":
			txtForm.setText("Ellipse");
			break;
		case "Linie":
			txtForm.setText("Linie");
			break;
		case "Polygon":
			txtForm.setText("Polygon");
			break;
		case "Rechteck":
			txtForm.setText("Rechteck");
			break;
		case "Quadrat":
			txtForm.setText("Quadrat");
			break;
		case "Dreieck":
			txtForm.setText("Dreieck");
			break;			
		}
	}
	
	private void outOfBoundsAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Out of Bounds");
		alert.setHeaderText(null);
		alert.setContentText("Es kann nicht über die Grenzen hinweg gezeichnet werden");
		alert.showAndWait();			
	}
	
	private void repaint() {
		group.getChildren().clear();
        Rectangle rectangle = new Rectangle(0, 0, 950, 700);
        rectangle.setFill(Color.rgb(0,150,136));
        group.getChildren().addAll(rectangle);
		for(int i=0; i<shapes.getSize();i++) {
			switch(shapes.getShapes(i).getForm()) {
			case "model.MCircle":
				Circle pCircle = new Circle(shapes.getShapes(i).getX(),shapes.getShapes(i).getY(),shapes.getShapes(i).getA());
				group.getChildren().add(pCircle);
				break;
			case "model.MEllipse":
				Ellipse pEllipse = new Ellipse(shapes.getShapes(i).getX(), shapes.getShapes(i).getY(), shapes.getShapes(i).getA(), shapes.getShapes(i).getB());
				group.getChildren().add(pEllipse);
				break;
			case "model.MLine":
				Line pLine = new Line(shapes.getShapes(i).getX(), shapes.getShapes(i).getY(), shapes.getShapes(i).getA(), shapes.getShapes(i).getB());
				group.getChildren().add(pLine);
				break;
			case "model.MRectangle": 
				Rectangle pRectangle = new Rectangle(shapes.getShapes(i).getX(), shapes.getShapes(i).getY(), shapes.getShapes(i).getA(), shapes.getShapes(i).getB());
				group.getChildren().add(pRectangle);
				break;
			}
		}
	}
	
	private void getForm(int id) {
		int index = id-1;
		switch(shapes.getShapes(index).getForm()) {
		case "model.MCircle":
			txtIndex.setText(""+id);
			txtX.setText(""+shapes.getShapes(index).getX());
			txtY.setText(""+shapes.getShapes(index).getY());
			txtA.setText(""+shapes.getShapes(index).getA());
			txtB.setText("0.0");
			txtB.setDisable(true);
			txtForm.setText("Kreis");
			txtUmfang.setText(""+shapes.getShapes(index).circumference());
			txtFlaeche.setText(""+shapes.getShapes(index).area());
			break;
		case "model.MEllipse":
			txtIndex.setText(""+id);
			txtX.setText(""+shapes.getShapes(index).getX());
			txtY.setText(""+shapes.getShapes(index).getY());
			txtA.setText(""+shapes.getShapes(index).getA());
			txtB.setText(""+shapes.getShapes(index).getB());
			txtB.setDisable(false);
			txtForm.setText("Ellipse");
			txtUmfang.setText(""+shapes.getShapes(index).circumference());
			txtFlaeche.setText(""+shapes.getShapes(index).area());
			break;
		case "model.MLine":
			txtIndex.setText(""+id);
			txtX.setText(""+shapes.getShapes(index).getX());
			txtY.setText(""+shapes.getShapes(index).getY());
			txtA.setText(""+shapes.getShapes(index).getA());
			txtB.setText(""+shapes.getShapes(index).getB());
			txtForm.setText("Linie");
			txtB.setDisable(false);
			txtUmfang.setText(""+shapes.getShapes(index).circumference());
			txtFlaeche.setText(""+shapes.getShapes(index).area());
			break;
		case "model.MRectangle": 
			txtIndex.setText(""+id);
			txtX.setText(""+shapes.getShapes(index).getX());
			txtY.setText(""+shapes.getShapes(index).getY());
			txtA.setText(""+shapes.getShapes(index).getA());
			txtB.setText(""+shapes.getShapes(index).getB());
			txtForm.setText("Rechteck");
			txtB.setDisable(false);
			txtUmfang.setText(""+shapes.getShapes(index).circumference());
			txtFlaeche.setText(""+shapes.getShapes(index).area());
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
