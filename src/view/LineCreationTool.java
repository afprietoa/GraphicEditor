package view;

import java.awt.event.MouseEvent;

import controller.App;
import model.BoundBox;
import model.Figure;
import model.Line;

public class LineCreationTool extends CreationTool {

	@Override
	protected Figure createFigure() {
		
		BoundBox bbox = new BoundBox( 
			ptp, 
			ptr 
		);
		
		return new Line(
				bbox,

				App.getInstance().getCurrentColor(),
				App.getInstance().getCurrentThickness(),
				App.getInstance().getLineStyle()
				
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
