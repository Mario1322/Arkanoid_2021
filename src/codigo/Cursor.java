package codigo;

import java.awt.Color;


import acm.graphics.GRect;

public class Cursor extends GRect{

	public Cursor(double x, double y, double width, double height, Color c) {
		super(x, y, width, height);
		this.setFillColor(c);
		this.setFilled(true);
	}
// esta el la posicion que puede tener la barra en el juego
	public void muevete(int anchopantalla, int posX){
		if(posX + getWidth()< anchopantalla) {
			setLocation(posX , getY());
		}
	}

}