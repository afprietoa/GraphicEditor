package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import model.ControlPoint.Cardinal;

public class BoundBox extends Rectangle {

	public final int NUM_CTRL_POINTS = 
		Cardinal.values().length;
	
	// 1. declaration
	private ControlPoint[] ctrlPoints;
	
	public BoundBox(Point p, Dimension d) {
		this(
			p.x, 
			p.y,
			d.width,
			d.height
		);
	}

	public BoundBox( Point ptp, Point ptr ) {
		
		this(
			ptp.x, 
			ptp.y,
			ptr.x - ptp.x,
			ptr.y - ptp.y 
		);
	}

	public BoundBox(
		int x, int y, int width, int height ) {
		super( x, y, width, height );
		
		// 2. construction
		ctrlPoints = new ControlPoint[ NUM_CTRL_POINTS ];
		
		// 3. fill
		Cardinal[] cardinals = Cardinal.values();
		
		for ( int i = 0; i < NUM_CTRL_POINTS; i++ ) {
			ctrlPoints[ i ] = new ControlPoint(
				this, 
				cardinals[ i ]
			);
		}
	}

	public BoundBox(BoundBox bbox) {
		this( bbox.x, bbox.y, bbox.width, bbox.height );
	}

	public void normalize() {
		if ( width < 0 ) {
			width = -width;
			x -= width;
		}
		if ( height < 0 ) {
			height = -height;
			y -= height;
		}
	}
	//protected float style[] = { 10.0f };
	public void paint( Graphics2D g ) {
		
		g.setColor( getColor() );
		// TODO: dashed pattern
		// TODO: draw control points
		
		g.setStroke( new BasicStroke(
					thickness, 
					BasicStroke.CAP_SQUARE, 
					BasicStroke.JOIN_MITER, 
					10.0f, 
					style, 
					0.0f
				));
		g.drawRect(
			x, 
			y, 
			width, 
			height
		);		
		
		for ( int i = 0; i < NUM_CTRL_POINTS; i++ ) {
			ctrlPoints[ i ].paint( g );
		}
	}

	public Color getColor() {
		return Color.GRAY;
	}
	
	public Cursor getCursor( Point pt ) {
		Cursor cursor = null;
		
		for ( int i = 0; i < NUM_CTRL_POINTS; i++ ) {
			if ( ctrlPoints[ i ].contains( pt ) ) {
				cursor = ctrlPoints[ i ].getCursor();
				break;
			}
		}
		
		return cursor;
	}
	protected float thickness;
	protected float[] style;

	public void doMove(int dx, int dy) {
		x+=dx;
		y+=dy;
	}

	public ControlPoint getControlPoint(Point pt) {
ControlPoint cp = null;
		
		for ( int i = 0; i < NUM_CTRL_POINTS; i++ ) {
			if ( ctrlPoints[ i ].contains( pt ) ) {
				cp = ctrlPoints[ i ];
				break;
			}
		}
			
		return cp;
	}
}
