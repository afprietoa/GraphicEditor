package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import model.ControlPoint;
import model.DocumentListener;
import model.Drawing;
import model.Figure;
import view.MainWindow;
import view.ToolBar;
import view.ToolListener;

public class App {

	private static App instance;
	
	public static App getInstance() {
		if ( instance == null ) {
			instance = new App();
		}
		
		return instance;
	}
	
	private MainWindow mainWindow;
	private Drawing drawing;
	
	private App () {
		super();
		
		this.drawing = new Drawing();
		this.mainWindow = new MainWindow( 
			"EG v0.4" 
		);
	}
	
	private void run() {
		this.mainWindow.init();
		
		this.mainWindow
			.setBounds(
				10, 10, 800, 600
			);
		
		this.mainWindow
			.setVisible(
				true
			);
	}
	
	public static void main(String[] args) {
		App app = App.getInstance();
		app.run();
	}

	public void addFigure( Figure f ) {
		this.drawing.addFigure( f );
		
		updateView();
	}

	public void updateView() {
		this.mainWindow.repaintCanvas();
	}

	public void paint( Graphics2D g ) {
		this.drawing.paint( g );
	}
	
	/*public boolean documentModified() {
		return drawing.isModified();
	}*/
	


	public void select(Point pt) {
		drawing.select( pt );
		
		updateView();
	}

	public void select(Point ptp, Point ptr) {
		drawing.select( ptp, ptr );
		
		updateView();
	}


	
	public Color getCurrentFillColor() {
		return mainWindow.getFillColor();
	}
	
	public Color getCurrentColor() {
		// TODO Auto-generated method stub
		return mainWindow.getColor();
	}

	public void setActiveTool(int tool) {
		mainWindow.setActiveTool(tool);
		
	}

	public float getCurrentThickness() {
		// TODO Auto-generated method stub
		return 4;
	}

	

	public float[] getRectangleStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	public float[] getLineStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	public float[] getEllipseStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addListener(DocumentListener listener)
	{
		drawing.addListener(listener);
	}

	public void saveDocument() {
		File file;
		String drawName = drawing.getName();
		if (drawName == null) {
			JFileChooser fileChooser = new JFileChooser();
			//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.dwg", "dwg");
			//fileChooser.setFileFilter(filter);
			int accion = fileChooser.showSaveDialog(fileChooser);
			
			if(accion == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					if(drawing.save(oos)){
						oos.writeObject(drawing);
						drawing.setName(fileChooser.getName(fileChooser.getSelectedFile()));
						drawing.save(oos);
					}
					else {
						
					}
					oos.close();
				
				}
				catch(IOException e) {
					// TODO
				}
			}
		}
		else { 
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(drawName));
				if(drawing.save(oos)){
					oos.writeObject(drawing);
					drawing.save(oos);
				}
				else {
					
				}
				oos.close();
			
			}
			catch(IOException e) {
				// TODO
			}
		}
	}
	
	public void openDocument() { 
		File file;
		JFileChooser fileChooser = new JFileChooser();
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.dwg", "dwg");
		//fileChooser.setFileFilter(filter);
		int accion = fileChooser.showOpenDialog(fileChooser);
		
		if (accion==JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				if(drawing.load(ois)){
					
					drawing.load(ois);
					ois.close();
					drawing.setName(file.getName());
				}
				else{
					//ERROR
				}
				
				
			}
			catch (Exception e) {
					
			}
		}
	}

	public String getModelName() {
		return  drawing.getName();
	}

	public void moveFigure(Figure fMove, int dx, int dy) {
		// TODO Auto-generated method stub
		drawing.moveFigure( fMove, dx, dy);
		updateView();
	}

	public Figure getSelectedFigure(Point pt) {
		// TODO Auto-generated method stub
		return drawing.getSelectedFigure( pt );
	}

	public void deselectAll() {
		drawing.deselectAll();
		updateView();
		
	}

	public Cursor getCursor(Point pt) {
		return drawing.getCursor( pt );
	}

	public void releaseGraphics(Graphics2D g) {
		mainWindow.releaseCanvasGraphics( g );
		
	}

	public Graphics2D getGraphics() {
		return mainWindow.getCanvasGraphics();
	}

	public void resizeFigure(ControlPoint cp, int dx, int dy) {
		drawing.resizeFigure( cp, dx, dy );
		updateView();	
		
	}

	public ControlPoint getSelectedCtrlPoint(Point pt) {
		return drawing.getSelectedCtrlPoint( pt );
	}

	public void newDocument() {
		drawing.clear();
		updateView();
		
	}


	

	
	
	
	
	
	
	
	
	
	
}






