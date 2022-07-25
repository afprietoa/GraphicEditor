package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import controller.App;
import model.ControlPoint;
import model.DocumentListener;
import model.Figure;
import view.ToolListener.ToolEvent;

public class Canvas extends JPanel
implements DocumentListener {

	public static final int CLIN=0;
	public static final int CREC=1;
	public static final int CSQR=2;
	public static final int CELI=3;
	public static final int CCIR=4;
	public static final int CTXT=5;
	public static final int CTRI=6;
	public static final int MOV=7;
	public static final int RESZ=8;
	public static final int SELT=9;
	
	public static final int NTOOLS=SELT+1;
	
	// 1. declaration
	private Tool[] tools;
	private Tool activeTool;
	
	public Canvas() {
		super();
		listeners=new LinkedList<ToolListener>();
		setBackground( new Color(255, 255, 128) );
		
		tools=new Tool[NTOOLS];
		tools[CLIN]=new LineCreationTool();
		tools[CREC]=new RectangleCreationTool();
		tools[CSQR]=new SquareCreationTool();
		tools[CELI]=new EllipseCreationTool();
		tools[CCIR]=new CircleCreationTool();
		tools[CTRI]=new TriangleCreationTool();
		tools[CTXT]=new TextCreationTool();
		tools[MOV]=new MoveTool();
		tools[RESZ]=new ResizeTool();
		tools[SELT]=new SelectionTool();
	
		
		addMouseListener(
			new MouseAdapter() {
				@Override
			    public void mousePressed(MouseEvent e) {
					
					ControlPoint cp = App.getInstance().getSelectedCtrlPoint( e.getPoint() );
					if ( cp == null ) {
					Figure f = App.getInstance().getSelectedFigure(
							e.getPoint()
						);
						
						if ( f == null ) {
							App.getInstance().deselectAll();
						}
						else {
							setActiveTool(
								MOV
							);
							
							   ((MoveTool)activeTool).setFigure( 
								f 
							);
						}
					}
						else {
							setActiveTool( RESZ );
							 ((ResizeTool)activeTool).setControlPoint( cp );						
						}
					activeTool.mousePressed( e );
				}

				@Override
			    public void mouseReleased(MouseEvent e) {
					activeTool.mouseReleased( e );
					if ( activeTool == tools[ MOV ] ) { 
						setActiveTool( SELT);
					}
				}
			}
		);

		addMouseMotionListener(
			new MouseAdapter() {
				@Override
			    public void mouseDragged(MouseEvent e) {
					activeTool.showFeedback( e );
					activeTool.mouseDragged( e );
				}
				
				@Override
			    public void mouseMoved(MouseEvent e) {
					Cursor cursor = App.getInstance().getCursor(
						e.getPoint()
					);
					
					if ( cursor == null ) {
						setCursor( Cursor.getDefaultCursor() );
					}
					else {
						setCursor( cursor );
					}
				}
			}
		);
	}


	
	public void paint( Graphics g ) {
		super.paint( g );
		
		App.getInstance().paint( 
			(Graphics2D)g 
		);
	}
	public void init() {
		App.getInstance().addListener( this );
	}
	
	public void setActiveTool( int idx )
		throws InvalidParameterException {
		
		if ( 0 <= idx && idx < tools.length ) {
			activeTool = tools[ idx ];
			
			 notifyListeners( ToolEvent.ACTIVETOOL );
			 activetoolVerify();
		}
		else {
			throw new InvalidParameterException(
				"Invalid tool index"
			);
		}
	}
	@Override
	public void documentChange(DocumentEvent event) {
		// TODO Auto-generated method stub
		if(event.name().equals("SAVED"))
		{
			//NOP
		}
		else
		{
			repaint();
		}
	}private void notifyListeners(ToolEvent event)
	{
		Iterator<ToolListener> indx=listeners.iterator();
		while(indx.hasNext())
		{
			indx.next().toolChange(event);
		}
	}
	public void activetoolVerify()
	{
		if (tools[CLIN].equals(activeTool))
		{
			notifyListeners( ToolEvent.LINE_CREATION);
		}
		else if(tools[CREC].equals(activeTool))
		{
			notifyListeners( ToolEvent.RECT_CREATION);
		}
		else if(tools[CELI].equals(activeTool))
		{
			notifyListeners( ToolEvent.ELLI_CREATION);
		}
		else if(tools[CCIR].equals(activeTool))
		{
			notifyListeners( ToolEvent.CIRC_CREATION);
		}
		else if(tools[CTRI].equals(activeTool))
		{
			notifyListeners( ToolEvent.TRI_CREATION);
		}
		else if(tools[CTXT].equals(activeTool))
		{
			notifyListeners( ToolEvent.TXT_CREATION);
		}
		else if(tools[SELT].equals(activeTool))
		{
			notifyListeners( ToolEvent.SELECTION);
		}
	}
	public void addListener(ToolListener listener) {
		// TODO Auto-generated method stub
		listeners.add(listener);
	}
	public void removeListener(ToolListener listener) {
		// TODO Auto-generated method stub
		listeners.remove(listener);
	}
	private List<ToolListener> listeners;
}
