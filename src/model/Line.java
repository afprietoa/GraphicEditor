package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.BasicStroke;

public class Line extends GeometricFigure {
	
	/*public Rectangle(
		BoundBox bbox, 
		Color color, 
		Color fill ) {

		super( bbox, color, fill );
	}*/

	public Line(
			BoundBox bbox, 
			Color color, 
			float thickness, 
			float[] style) {
		super(bbox, color, thickness, style); 
		// TODO Auto-generated constructor stub
	}
	protected boolean needsNormalization() {
		return false;
	}
	public void doPaint( Graphics2D g ) {
		Point pos = getPosition();
		Dimension size = getSize();
		Color color = getColor();
		
		g.setColor( color );
		g.setStroke( new BasicStroke(
				thickness, 
				BasicStroke.CAP_SQUARE, 
				BasicStroke.JOIN_MITER, 
				10.0f, 
				style, 
				0.0f
			));
		g.drawLine(
			pos.x, 
			pos.y, 
			pos.x + size.width, 
			pos.y + size.height
		);
	}

	}

