package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import controller.App;
import model.BoundBox;
import model.Figure;
import model.Rectangle;
import model.Text;

public class TextCreationTool extends CreationTool {

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
	return new Text(
			bbox,
			App.getInstance().getCurrentColor()
		
			
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