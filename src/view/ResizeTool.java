package view;

import java.awt.event.MouseEvent;

import controller.App;
import model.ControlPoint;

public class ResizeTool extends Tool {
	private ControlPoint cpRes;
	
	public void mouseDragged( MouseEvent e ) {
		int dx = e.getPoint().x - ptp.x;
		int dy = e.getPoint().y - ptp.y;
		
		if ( cpRes == null ) {
			// NOOP
		}
		else {
			App.getInstance().resizeFigure( cpRes, dx, dy );
		}
		
		ptp = e.getPoint();
	}

	@Override
	protected void processMouseReleased() {
		cpRes = null;
	}
	@Override
	public void showFeedback(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setControlPoint( ControlPoint cp ) {
		cpRes = cp;
	}   

}
