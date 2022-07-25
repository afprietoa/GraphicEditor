package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Triangle extends ClosedFigure {

	public Triangle(
			BoundBox bbox, 
			Color color, 
			Color fill,
			float thickness, 
			float[] style) {
		super(bbox, color, fill,thickness, style); 
		// TODO Auto-generated constructor stub
	}

	private int[] getArrayX() {
		int[] xPoints = new int[ 3 ];
		
		Point pos = getPosition();
		Dimension size = getSize();

		xPoints[ 0 ] = pos.x;
		xPoints[ 1 ] = pos.x+(size.width)/2;
		xPoints[ 2 ] = pos.x + size.width;
		
		return xPoints;
	}

	private int[] getArrayY() {
		int[] yPoints = new int[ 3 ];
		
		Point pos = getPosition();
		Dimension size = getSize();

		yPoints[ 0 ] = pos.y + size.height;
		yPoints[ 1 ] = pos.y;
		yPoints[ 2 ] = pos.y + size.height;
		
		return yPoints;
	}

	@Override
	public void paintBorder( Graphics2D g ) {
		
		g.drawPolygon(
			getArrayX(), 
			getArrayY(), 
			3
		);
	}

	@Override
	public void paintFill(Graphics2D g) {
		g.setStroke( new BasicStroke(
				thickness, 
				BasicStroke.CAP_SQUARE, 
				BasicStroke.JOIN_MITER, 
				10.0f, 
				style, 
				0.0f
			));
		g.fillPolygon(
			getArrayX(), 
			getArrayY(), 
			3
		);
	}
}
