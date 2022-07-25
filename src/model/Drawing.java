package model;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.DocumentListener.DocumentEvent;

public class Drawing {

	

	public Drawing() {
		
		super();
		figures= new LinkedList<Figure>();
		listeners= new LinkedList<DocumentListener>();
		
	}


	/*public boolean add(
		Figure f ) {
		
		if ( f == null ) {
			modified = true; 
			return figures.add( f );
			
		}
		
		return false;
	}*/
	
	public void addListener( DocumentListener dl ) {
		listeners.add( dl );
	}

	public void removeListener( DocumentListener dl ) {
		listeners.remove( dl );
	}
	
	public void addFigure( final Figure f ) {
		if ( f == null ) {
			// NOOP
		}
		else {
			figures.add( f );
			notifyListeners( DocumentEvent.ADD_FIGURE );
		}
	}
	
	public void removeFigure( final Figure f ) {
		if ( f == null ) {
			// NOOP
		}
		else {
			figures.remove( f );
			notifyListeners( DocumentEvent.REM_FIGURE );
		}
	}
	
	private void notifyListeners(DocumentEvent event)
	{
		Iterator<DocumentListener> indx=listeners.iterator();
		while(indx.hasNext())
		{
			indx.next().documentChange(event);
		}
	}
	
	public void paint( Graphics2D g ) {
		for ( int c = 0; c < figures.size(); c++ ) {
			Figure f = this.figures.get( c );
			
			f.paint( g );
		}
	}

/*	public void save( 
		ObjectOutputStream oos ) {
		
		for ( int c = 0; c < figures.size(); c++ ) {
			Figure f = this.figures.get( c );
			
			f.save( oos );
		}
	}*/
	
	/*public boolean isModified() {
		return modified;
	}*/

	public String getPath() {
		return path;
	}

	/*public boolean save() {
		return false;
	}*/


	public void select(Point pt) {
		for ( int c = figures.size() -1;
			c >= 0;
			c-- ) {
		
			Figure f = figures.get( c );
			
			f.select( pt );
			
			if ( f.isSelected() ) {
				break;
			}
		}
	}

	public void select( Point ptp, Point ptr ) {
		BoundBox bbox = new BoundBox( 
				ptp, 
				ptr 
			);
			
			bbox.normalize();

		for ( int c = figures.size() -1;
			c >= 0;
			c-- ) {
		
			Figure f = figures.get( c );
		
			
			f.select( bbox );
		}
	}
	public boolean save( ObjectOutputStream oos ) {
		try {
			oos.writeObject( figures );
			notifyListeners( DocumentEvent.SAVED );
			return true;
		} 
		catch (IOException e) {
			return false;
		}
	}
	
	public boolean load( ObjectInputStream ois ) {
		try {
			figures = (List<Figure>)ois.readObject();
			notifyListeners( DocumentEvent.LOADED );
			return true;
		} 
		catch ( Exception e ) {
			System.err.println(
				e.toString()
			);
			return false;
		}
	}
	private List<Figure> figures;
	private List<DocumentListener> listeners;
	//private boolean modified;
	private String path;
private String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name=name;
		
	}


	public void moveFigure(Figure fMove, int dx, int dy) {
		fMove.doMove(dx,dy);
		
	}


	public Figure getSelectedFigure(Point pt) {
Figure figure = null;
		
		for ( int c = figures.size() - 1;
				c >= 0;
				c-- ) {
			
				Figure f = figures.get( c );
				
				if ( f.isSelected() ) {
					if ( f.contains( pt ) ) {
						figure = f;
						break;
					}
				}
				else {
					// skip it
				}
			}
		
		return figure;
	}


	public void deselectAll() {
		for ( int c = figures.size() - 1;
				c >= 0;
				c-- ) {
			
				Figure f = figures.get( c );
				
				f.setSelected( false );
			}		
		
	}


	public Cursor getCursor(Point pt) {
Cursor cursor = null;
		
		for ( int c = figures.size() - 1;
			c >= 0;
			c-- ) {
		
			Figure f = figures.get( c );
			
			if ( f.isSelected() ) {
				cursor = f.getCursor(pt);
				
				if ( cursor != null ) {
					break;
				}
			}
			else {
				// skip it
			}
		}
		
		return cursor;
	}


	public void resizeFigure(ControlPoint cp, int dx, int dy) {
		cp.resize( dx, dy );
		
	}


	public ControlPoint getSelectedCtrlPoint(Point pt) {
ControlPoint cp = null;
		
		for ( int c = figures.size() -1;
				c >= 0;
				c-- ) {
			
				Figure fig = figures.get( c );
				
				if ( fig.isSelected() ) {
					cp = fig.getControlPoint( pt );
					
					if ( cp == null ) {
						// NOOP
					}
					else {
						break;
					}
				}
				else {
					// skip it
				}
		}
		
		return cp;
	}


	public void clear() {
		figures.clear();
		
	}
}




