package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Text extends ClosedFigure {

    
	public Text(BoundBox bbox, 
			Color color) {
		super(bbox, color); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintBorder(Graphics2D g) {
		String s = "Hello World Java";
		Point pt = getPosition();
		Dimension size = getSize();
		g.setColor( color );
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		
		 drawCenteredString(s, pt.x , pt.y ,size.width, size.height, g);
		// TODO Auto-generated method stub

	}
	public void drawCenteredString(String s, int px ,int py,int w, int h, Graphics g) {
		
	    FontMetrics fm = g.getFontMetrics();
	    int x = px+(w - fm.stringWidth(s)) / 2;
	    int y =py + (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
	    g.drawString(s, x, y);
	  }
	public void paintFill(Graphics2D g) {
			
	}
}