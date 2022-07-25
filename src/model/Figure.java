package model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Figure 
	implements Serializable {

	public abstract void doPaint( Graphics2D g );
	
	private BoundBox bbox;
	protected Color color;
	
	private transient boolean selected;
	
	public Figure(
		BoundBox bbox, Color color ) {
		
		super();
		this.bbox = bbox;
		this.color = color;
		
		if ( needsNormalization() ) { 
			bbox.normalize();
		}
	}

	protected boolean needsNormalization() {
		return true;
	}

	public Point getPosition() {
		return bbox.getLocation();
	}

	public Dimension getSize() {
		return bbox.getSize();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void save( 
		ObjectOutputStream oos ) {
		
	}

	public void select( Point pt ) {
		setSelected(
			bbox.contains( pt )
		);
	}

	public void select( BoundBox bbox ) {
		setSelected(
			bbox.contains(
				this.bbox
			)
		);
	}
	
	// template method
	
	public final void paint( Graphics2D g ) {
		// 1. set color
		g.setColor( color );
		
		
		// 2. draw figure
		doPaint( g );
		
		// 4. draw bbox
		if ( isSelected() ) {
			bbox.paint( g );
		}
	}

	public void doMove(int dx, int dy) {
		bbox.doMove(dx,dy);
		
	}

	public boolean contains(Point pt) {
		return bbox.contains( pt );
	}

	public Cursor getCursor(Point pt) {
		Cursor cursor = bbox.getCursor( 
				pt
			);
			
			if ( cursor == null ) {
				if ( needsNormalization() ) { 
					if ( bbox.contains( pt ) ) {
						cursor = Cursor.getPredefinedCursor(
							Cursor.MOVE_CURSOR
						);
					}
				}
				else {
					BoundBox norm = new BoundBox( bbox );
					norm.normalize();
					
					if ( norm.contains( pt ) ) {
						cursor = Cursor.getPredefinedCursor(
							Cursor.MOVE_CURSOR
						);
					}
				}
			}
			else {
				// OK
			}
			
			return cursor;
	}

	public ControlPoint getControlPoint(Point pt) {
		return bbox.getControlPoint( pt );
	}
}




