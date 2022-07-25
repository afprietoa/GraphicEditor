package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import controller.App;
import model.BoundBox;
import model.Figure;
import model.Rectangle;

public class RectangleCreationTool extends CreationTool {

	@Override
	protected Figure createFigure() {
		
		BoundBox bbox = new BoundBox( 
			ptp, 
			ptr 
		);
		
	
		return new Rectangle(
				bbox,

				App.getInstance().getCurrentColor(),
				App.getInstance().getCurrentFillColor(),
				App.getInstance().getCurrentThickness(),
				App.getInstance().getRectangleStyle()
				
			);
	}

    public void mouseDragged(MouseEvent e) {
    	// TODO
	}

	@Override
	public void showFeedback(MouseEvent e) {
Graphics2D g = App.getInstance().getGraphics();
		
		float dash[] = {
				4.0f, 4.0f
		};
		BasicStroke dashed = new BasicStroke(
			1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f 
		);
		g.setStroke( dashed );

		g.setXORMode( Color.WHITE );
		
		if ( ptr == null ) ptr = e.getPoint();
		BoundBox bbox = new BoundBox( ptp, ptr );
		ptr = e.getPoint();

		g.drawRect( bbox.x, bbox.y, bbox.width, bbox.height );
		bbox = new BoundBox( ptp, ptr );
		g.drawRect( bbox.x, bbox.y, bbox.width, bbox.height );		
		
		App.getInstance().releaseGraphics( g );
	}
}
