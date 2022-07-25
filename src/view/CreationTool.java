package view;

import controller.App;
import model.Figure;

public abstract class CreationTool extends Tool {

	protected abstract Figure createFigure();

	@Override // template method
	protected void processMouseReleased() {
		// 1. check points
		if ( ptp.equals( ptr ) ) {
			// NOOP
		}
		else {
			// 2. create figure
			Figure f = createFigure();
			
			// 3. check figure
			if ( f != null ) {
				App.getInstance().addFigure(
						f
				);
			}
		}
	}
}
