package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import controller.App;
import model.DocumentListener;

public class MainWindow extends JFrame
implements DocumentListener{

	
	private Canvas canvas;
	private Menu menu;
	private ToolBar toolBar;
	private String title;
	public MainWindow()
	{}
	public MainWindow( 
		final String title ) {
		
		super( 
			title 
		);
		
		setDefaultCloseOperation( 
			JFrame.EXIT_ON_CLOSE 
		);
		this.title=title;
		canvas = new Canvas();
		menu=new Menu();
		toolBar=new ToolBar();
		
	}
	
	public void init() {
		setExtendedState( 
			JFrame.MAXIMIZED_BOTH 
		);
		App.getInstance().addListener(this);
		add( canvas, BorderLayout.CENTER );
		add( menu, BorderLayout.NORTH );
		add( toolBar, BorderLayout.EAST );
	
		canvas.init();
		menu.initMenu();
		toolBar.initToolBar();
		addListenerTool(this.menu);
		addListenerTool(this.toolBar);
	}
	
	public void repaintCanvas() {
		canvas.repaint();
	}

	public void setActiveTool(int tool) {
		canvas.setActiveTool(tool);
		
	}

	@Override
	public void documentChange(DocumentEvent event) {
		// TODO Auto-generated method stub
		if(event.name().equals("SAVED"))
				{
			setTitle(title);
				}
		else
		{
			setTitle( title+ "*");
		}
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return menu.getColor();
	}

	public Color getFillColor() {
		// TODO Auto-generated method stub
		return menu.getFillColor();
	}
	public void addListenerTool(ToolListener t)
	{
	canvas.addListener(t);
	
	}
	public void releaseCanvasGraphics(Graphics2D g) {
		g.dispose();
		
	}
	public Graphics2D getCanvasGraphics() {
		return (Graphics2D)canvas.getGraphics();
	}

}



