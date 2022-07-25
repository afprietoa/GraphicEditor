package view;

import java.awt.event.MouseEvent;

import controller.App;
import model.Figure;
//la clase MoveTool  desplaza (dx,dy) una figura contenida en el bounding box (definira un metodo doMove)
//refrescando la vista (repaintCanvas) en ese cambio de coordenadas de la figura pintada
public class MoveTool extends Tool {
	private Figure fMove;
	@Override

	//mouseDragged devuelve el rastro de puntos que desencadena el arrastre del mouse
			// derivado desde un punto inicial
	public void showFeedback( MouseEvent e ) {
		//sentencia que condiciona el flujo del programa verificando
				//la no instancia del objeto
		if ( fMove == null ) {
			// NOOP
		}
		else {
			int dx = e.getPoint().x - ptp.x; 
			int dy = e.getPoint().y - ptp.y;
			
	    	App.getInstance().moveFigure(
	    		fMove, dx, dy 
	    	);
	    	
	    	ptp = e.getPoint();
		}
	}

	@Override
	protected void processMouseReleased() {
		// TODO Auto-generated method stub
		fMove=null;
	}


	public void setFigure(Figure f) {
		fMove = f;
		
	}

}
