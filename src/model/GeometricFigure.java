package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public abstract class GeometricFigure extends Figure {
	protected float thickness;
	protected float[] style;

	public GeometricFigure(
			BoundBox bbox, Color color , float thickness,
			float[] style) {
		
		super( bbox, color );
		this.thickness = thickness;
		this.style = style;
	}

	public GeometricFigure(BoundBox bbox, Color color) {
		// TODO Auto-generated constructor stub
		super( bbox, color );
	}
	
}
