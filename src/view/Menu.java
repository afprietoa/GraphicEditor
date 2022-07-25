package view;


import java.awt.Checkbox;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import controller.App;

public class Menu extends JMenuBar 
implements ToolListener{
	
	
	JMenu fileMenu;
	JMenu helpMenu;
	JMenu toolMenu;
	JMenu colorMenu;
	JMenuItem exitItem;
	JMenuItem aboutItem;
	JMenuItem newItem;
	JMenuItem saveItem;
	JMenuItem openItem;
	JMenuItem colorItem; 
	JMenuItem fillColorItem;
	JCheckBoxMenuItem lineItem;
	JCheckBoxMenuItem rectangleItem;
	JCheckBoxMenuItem squareItem;
	JCheckBoxMenuItem triangleItem;
	JCheckBoxMenuItem ellipseItem;
	JCheckBoxMenuItem circleItem;
	JCheckBoxMenuItem txtItem;
	JCheckBoxMenuItem seltItem;
	private ButtonGroup group;
	private static Color color;
	private static Color colorToApp;
	private static Color fillColor;
	private static Color fillColorToApp;
	
	public Menu()  {
		
		group=new ButtonGroup();
		
		fileMenu=new JMenu("File");
		this.add(fileMenu);
		
		
		toolMenu=new JMenu("Tool");
		this.add(toolMenu);
		
		colorMenu=new JMenu("Color");
		this.add(colorMenu);
		
		helpMenu=new JMenu("Help");
		this.add(helpMenu);
		
		newItem=new JMenuItem("New");
		fileMenu.add(newItem);
		
		openItem=new JMenuItem("Open");
		fileMenu.add(openItem);
		
		saveItem=new JMenuItem("Save");
		fileMenu.add(saveItem);
		
		fileMenu.add( new JSeparator() );
		
		exitItem=new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		aboutItem=new JMenuItem("About");
		helpMenu.add(aboutItem);
		
		lineItem=new JCheckBoxMenuItem("Line");
		toolMenu.add(lineItem);
		group.add(lineItem);
		
		rectangleItem=new JCheckBoxMenuItem("Rectangle");
		toolMenu.add(rectangleItem);
		group.add(rectangleItem);
		
		squareItem=new JCheckBoxMenuItem("Square");
		toolMenu.add(squareItem);
		group.add(squareItem);
		
		triangleItem=new JCheckBoxMenuItem("Triangle");
		toolMenu.add(triangleItem);
		group.add(triangleItem);
		
		ellipseItem=new JCheckBoxMenuItem("Ellipse");
		toolMenu.add(ellipseItem);
		group.add(ellipseItem);
		
		circleItem=new JCheckBoxMenuItem("Circle");
		toolMenu.add(circleItem);
		group.add(circleItem);
		
		txtItem=new JCheckBoxMenuItem("Text");
		toolMenu.add(txtItem);
		group.add(txtItem);
		
		toolMenu.add( new JSeparator() );
		
		seltItem=new JCheckBoxMenuItem("Select");
		toolMenu.add(seltItem);
		group.add(seltItem);
		
		colorItem=new JMenuItem("Border");
		colorMenu.add(colorItem);
		group.add(colorItem);
		
		fillColorItem=new JMenuItem("Filler");
		colorMenu.add(fillColorItem);
		group.add(fillColorItem);
		
	}
	public void initMenu () {
		
		
		newItem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						App.getInstance().newDocument();
					}
				}
			);
		
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().openDocument();
				
			}
		});
			
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().saveDocument();
				
			}
		});
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		

		
		aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
						null, "    Vector Graphics Editor "
								+ "\n             Version 0.001") ;
				
			}
		});
		
		
		
		
		lineItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				App.getInstance().setActiveTool(Canvas.CLIN);
				
			}
		});
		
	
	rectangleItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CREC);
			
		}
	});
	
   squareItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CSQR);
			
		}
	});
	
	
	triangleItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CTRI);
			
		}
	});
	
	
	ellipseItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CELI);
			
		}
	});
	
circleItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CCIR);
			
		}
	});
	
	txtItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.CTXT);
			
		}
	});
   seltItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().setActiveTool(Canvas.SELT);
			
		}
	});
   
  
	colorItem.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new JColorChooser();
			color = JColorChooser.showDialog(null,"Color de borde: ", Color.BLACK);
			setColor(color);
			
		}
	}
	
	);
	
	JMenuItem tFillColor = new JMenuItem("Fill Color");
	fillColorItem.addActionListener(new ActionListener() {
	
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
			lineItem.setState(true);
			rectangleItem.setState(false);
			triangleItem.setState(false);
			ellipseItem.setState(false);
			txtItem.setState(false);
			seltItem.setState(false);
		}
		else if (event.name().equals("RECT_CREATION"))
		{
			lineItem.setState(false);
			triangleItem.setState(false);
			ellipseItem.setState(false);
			txtItem.setState(false);
			seltItem.setState(false);
			rectangleItem.setState(true);
			
		}
		else if (event.name().equals("TRI_CREATION"))
		{
			lineItem.setState(false);
			ellipseItem.setState(false);
			txtItem.setState(false);
			seltItem.setState(false);
			rectangleItem.setState(false);
			triangleItem.setState(true);
		}
		else if (event.name().equals("ELLI_CREATION"))
		{
			lineItem.setState(false);
			txtItem.setState(false);
			seltItem.setState(false);
			rectangleItem.setState(false);
			triangleItem.setState(false);
			ellipseItem.setState(true);
		}
		else if (event.name().equals("TXT_CREATION"))
		{
			lineItem.setState(false);
			seltItem.setState(false);
			rectangleItem.setState(false);
			triangleItem.setState(false);
			ellipseItem.setState(false);
			txtItem.setState(true);
		}
		else if (event.name().equals("SELECTION"))
		{
			lineItem.setState(false);
			rectangleItem.setState(false);
			triangleItem.setState(false);
			ellipseItem.setState(false);
			txtItem.setState(false);
			seltItem.setState(true);
		}
	}
	

}
