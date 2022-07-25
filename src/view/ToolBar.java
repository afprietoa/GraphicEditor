package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import controller.App;

public class ToolBar extends JToolBar 
implements ToolListener{

	JToggleButton lineButton;
	JToggleButton rectangleButton;
	JToggleButton triangleButton;
	JToggleButton ellipseButton;
	JToggleButton txtButton;
	JToggleButton seltButton;
	JToggleButton colorButton; 
	JToggleButton fillColorButton;
	ImageIcon lineIcon;
	ImageIcon rectangleIcon;
	ImageIcon triangleIcon;
	ImageIcon ellipseIcon;
	ImageIcon txtIcon;
	ImageIcon seltIcon;
	ImageIcon colorIcon;
	ImageIcon fillColorIcon;
	private ButtonGroup group;	
	private static Color color;
	private static Color colorToApp;
	private static Color fillColor;
	private static Color fillColorToApp;
	
	public ToolBar()  {
		this.setOrientation(1);
		
		group=new ButtonGroup();
		
		lineIcon=new ImageIcon("src\\iconImage\\line.png");
		lineButton=new JToggleButton(lineIcon);
		this.add(lineButton);
		group.add(lineButton);
		
		rectangleIcon=new ImageIcon("src\\iconImage\\rectangle.png");
		rectangleButton=new JToggleButton(rectangleIcon);
		this.add(rectangleButton);
		group.add(rectangleButton);
		
		triangleIcon=new ImageIcon("src\\iconImage\\triangle.png");
		triangleButton=new JToggleButton(triangleIcon);
		this.add(triangleButton);
		group.add(triangleButton);
		
		ellipseIcon=new ImageIcon("src\\iconImage\\ellipse.png");
		ellipseButton=new JToggleButton(ellipseIcon);
		this.add(ellipseButton);
		group.add(ellipseButton);
		
		txtIcon=new ImageIcon("src\\iconImage\\txt.png");
		txtButton=new JToggleButton(txtIcon);
		this.add(txtButton);
		group.add(txtButton);
		
		seltIcon=new ImageIcon("src\\iconImage\\select.png");
		seltButton=new JToggleButton(seltIcon);
		this.add(seltButton);
		group.add(seltButton);
		
		colorIcon=new ImageIcon("src\\iconImage\\color.png");
		colorButton=new JToggleButton(colorIcon);
		this.add(colorButton);
		group.add(colorButton);
		
		fillColorIcon=new ImageIcon("src\\iconImage\\fillColor.png");
		fillColorButton=new JToggleButton(fillColorIcon);
		this.add(fillColorButton);
		group.add(fillColorButton);
	}
	public void initToolBar () {

		lineButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().setActiveTool(Canvas.CLIN);
				
			}
		});
		
	
	rectangleButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CREC);
			
		}
	});
	

	
	triangleButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CTRI);
			
		}
	});
	
	
	ellipseButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CELI);
			
		}
	});
	
	
	txtButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CTXT);
			
		}
	});
   seltButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.SELT);
			
		}
	});
   
  
	colorButton.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new JColorChooser();
			color = JColorChooser.showDialog(null,"Color de borde: ", Color.BLACK);
			setColor(color);
			
		}
	}
	
	);
	
	JMenuItem tFillColor = new JMenuItem("Fill Color");
	fillColorButton.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new JColorChooser();
			fillColor = JColorChooser.showDialog(null,"Color de relleno: ", null);
			setFillColor(fillColor);
			
		}
	}
	
	);
	
	}
	public void setColor(Color color){
		colorToApp =  color;
		}
		
		public Color getColor() {
			return colorToApp;
		}
		
		public void setFillColor(Color fillColor){
			fillColorToApp =  fillColor;
		}
			
		public Color getFillColor() {
			return fillColorToApp;
		}
		@Override
		public void toolChange(ToolEvent event) {
		// TODO Auto-generated method stub
		if(event.name().equals("LINE_CREATION"))
		{
		lineButton.	setSelected(true);
		rectangleButton.setSelected(false);
		triangleButton.setSelected(false);
		ellipseButton.setSelected(false);
		txtButton.setSelected(false);
		seltButton.setSelected(false);
		}
		else if (event.name().equals("RECT_CREATION"))
		{
		lineButton.setSelected(false);
		triangleButton.setSelected(false);
		ellipseButton.setSelected(false);
		txtButton.setSelected(false);
		seltButton.setSelected(false);
		rectangleButton.setSelected(true);

		}
		else if (event.name().equals("TRI_CREATION"))
		{
		lineButton.setSelected(false);
		ellipseButton.setSelected(false);
		txtButton.setSelected(false);
		seltButton.setSelected(false);
		rectangleButton.setSelected(false);
		triangleButton.setSelected(true);
		}
		else if (event.name().equals("ELLI_CREATION"))
		{
		lineButton.setSelected(false);
		txtButton.setSelected(false);
		seltButton.setSelected(false);
		rectangleButton.setSelected(false);
		triangleButton.setSelected(false);
		ellipseButton.setSelected(true);
		}
		else if (event.name().equals("TXT_CREATION"))
		{
		lineButton.setSelected(false);
		seltButton.setSelected(false);
		rectangleButton.setSelected(false);
		triangleButton.setSelected(false);
		ellipseButton.setSelected(false);
		txtButton.setSelected(true);
		}
		else if (event.name().equals("SELECTION"))
		{
		lineButton.setSelected(false);
		rectangleButton.setSelected(false);
		triangleButton.setSelected(false);
		ellipseButton.setSelected(false);
		txtButton.setSelected(false);
		seltButton.setSelected(true);
		}
		}
	
	
}
