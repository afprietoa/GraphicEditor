package view;

import java.awt.event.MouseEvent;

import controller.App;

public class SelectionTool extends Tool {

	@Override
	protected void processMouseReleased() {
		if ( ptp.equals( ptr ) ) {
			App.getInstance().select( ptp );
		}
		else {
			App.getInstance().select( ptp, ptr );
		}
	}

    public void mouseDragged(MouseEvent e) {
    	// TODO
	}

	@Override
	public void showFeedback(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
