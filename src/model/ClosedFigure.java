package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class ClosedFigure extends GeometricFigure {
	
	protected abstract void paintBorder( 
		Graphics2D g 
	);

	private Color fillColor;
	
	public ClosedFigure(
			BoundBox bbox,
			Color color,
			Color fill,
			float thickness,
			float[] style ) {
			
			super( bbox, color,thickness, style );
			this.fillColor = fill;
			
		}
	public ClosedFigure(
		BoundBox bbox, 
		Color color) {

		super( bbox, color );
	
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fill) {
		this.fillColor = fill;
	}

	public abstract void paintFill( Graphics2D g );
	
	// template method
	public void doPaint(
		Graphics2D g ) {
		
		Color color = getColor();
		Color fill = getFillColor();
		
		// 1. set fill color
		if ( fill != null ) {
			g.setColor( fill );

			// 2. paint fill
			paintFill( g );
		}
		
		// 3. set border color
		g.setColor( color );
		
		// 4. paint border
		paintBorder( g );
	}
}
