package view;

import java.awt.event.MouseEvent;

import controller.App;
import model.BoundBox;
import model.Figure;
import model.Triangle;

public class TriangleCreationTool extends CreationTool{
	@Override
	protected Figure createFigure() {
		
		BoundBox bbox = new BoundBox( 
			ptp, 
			ptr 
		);
		
		/*return new Rectangle(
			bbox, 
			App.getInstance().getColor(), 
			App.getInstance().getFillColor()
		);*/
		return new Triangle(
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
		// TODO Auto-generated method stub
		
	}
}
