package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends ClosedFigure {
	
	/*public Rectangle(
		BoundBox bbox, 
		Color color, 
		Color fill ) {

		super( bbox, color, fill );
	}*/

	public Rectangle(
			BoundBox bbox, 
			Color color, 
			Color fill,
			float thickness, 
			float[] style) {
		super(bbox, color, fill,thickness, style); 
		// TODO Auto-generated constructor stub
	}

	public void paintBorder(
		Graphics2D g ) {
		
		Point pos = getPosition();
		Dimension size = getSize();
		
		g.drawRect(
			pos.x, 
			pos.y, 
			size.width, 
			size.height
		);
	}

	@Override
	public void paintFill(Graphics2D g) {
		Point pos = getPosition();
		Dimension size = getSize();
		g.setStroke( new BasicStroke(
				thickness, 
				BasicStroke.CAP_SQUARE, 
				BasicStroke.JOIN_MITER, 
				10.0f, 
				style, 
				0.0f
			));
		g.fillRect(
			pos.x, 
			pos.y, 
			size.width, 
			size.height
		);		
	}
}
