package view;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.ControlPoint;

public abstract class Tool {

	 public void mouseDragged(MouseEvent e) {
			showFeedback(e);
		}
	public abstract void showFeedback(MouseEvent e);
	protected abstract void processMouseReleased();

	protected Point ptp;
	protected Point ptr;
	
    public void mousePressed(MouseEvent e) {
		ptp = e.getPoint();
	}

    // template method
    public final void mouseReleased(MouseEvent e) {
    	// 1. store point
		ptr = e.getPoint();
		
		// 2. do something w/2 points
		processMouseReleased();
	}
	
	
}
