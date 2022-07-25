package model;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;

public class ControlPoint implements Serializable {

	public final int SIZE = 3;
	
	enum Cardinal {
		NW, N, NE, E, SE, S, SW, W
	}
	
	private BoundBox owner;
	private Cardinal cardinal;
	private int dty;
	
	public ControlPoint( 
		final BoundBox owner,
		final Cardinal cardinal ) {
		
		this.owner = owner;
		this.cardinal = cardinal;
	}


	public Cursor getCursor() {
		switch ( cardinal ) {
			case NW: return Cursor.getPredefinedCursor(
				Cursor.NW_RESIZE_CURSOR
			);

			case N: return Cursor.getPredefinedCursor(
				Cursor.N_RESIZE_CURSOR
			);

			case NE: return Cursor.getPredefinedCursor(
				Cursor.NE_RESIZE_CURSOR
			);

			case E: return Cursor.getPredefinedCursor(
				Cursor.E_RESIZE_CURSOR
			);

			case SE: return Cursor.getPredefinedCursor(
				Cursor.SE_RESIZE_CURSOR
			);

			case S: return Cursor.getPredefinedCursor(
				Cursor.S_RESIZE_CURSOR
			);

			case SW: return Cursor.getPredefinedCursor(
				Cursor.SW_RESIZE_CURSOR
			);				

			case W: return Cursor.getPredefinedCursor(
				Cursor.W_RESIZE_CURSOR
			);				
		}
		
		return null;
	}

	public void paint( Graphics g ) {
		
		g.setColor( owner.getColor() );
		
		Point pt = getPosition();
		
		g.fillRect(
			pt.x - SIZE, 
			pt.y - SIZE, 
			2 * SIZE + 1, 
			2 * SIZE + 1
		);		
	}

	private Point getPosition() {
		Point pt = new Point();
		
		switch ( cardinal ) {
			case NW: 
				pt.x = owner.x; 
				pt.y = owner.y;
				break;

			case N: 
				pt.x = owner.x + owner.width / 2; 
				pt.y = owner.y;
				break;

			case NE: 
				pt.x = owner.x + owner.width; 
				pt.y = owner.y;
				break;

			case E: 
				pt.x = owner.x + owner.width; 
				pt.y = owner.y + owner.height / 2;
				break;

			case SE: 
				pt.x = owner.x + owner.width; 
				pt.y = owner.y + owner.height;
				break;

			case S: 
				pt.x = owner.x + owner.width / 2; 
				pt.y = owner.y + owner.height;
				break;

			case SW: 
				pt.x = owner.x; 
				pt.y = owner.y + owner.height;
				break;				

			case W: 
				pt.x = owner.x; 
				pt.y = owner.y + owner.height / 2;
				break;				
		}
		
		return pt;
	}


	public boolean contains( Point pt ) {
		
		Point pos = getPosition();
		
		Rectangle r = new Rectangle(
			pos.x - SIZE,
			pos.y - SIZE,
			2 * SIZE + 1,
			2 * SIZE + 1
		);

		return r.contains( pt );
	}


	public void resize(int dx, int dy) {
		dty = owner.y + owner.height;
		switch ( cardinal ) {
			case NW: 
				owner.x += dx;
				owner.y += dy;		
				owner.width -= dx;
				owner.height -= dy;
				break;
	
			case N: 
				owner.y += dy;	
				owner.height -= dy;
				break;
	
			case NE: 
				owner.y += dy;		
				owner.width += dx;
				owner.height -= dy;
				break;
	
			case E: 
				owner.width += dx;
				break;
	
			case SE: 
				dty  -= dy;			
				owner.width += dx;
				owner.height += dy;
				break;
	
			case S: 
				dty  -= dy;	
				owner.height += dy;
				break;
	
			case SW: 
				owner.x += dx;
				dty  -= dy;		
				owner.width -= dx;
				owner.height += dy;

				break;				
	
			case W: 
				owner.x += dx;
				owner.width -= dx;
				break;				
		}
		
	}
}
