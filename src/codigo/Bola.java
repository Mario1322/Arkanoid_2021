package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{

	int dx = 1;//velocidad en el eje x
	int dy = 1; //velocidad en el eje y

	public Bola(double width, double height) {
		super(width, height);


	}
	public Bola(double width, double height, Color c) {
		super(width, height);
		this.setFillColor(c);
		this.setFilled(true);
	}

	public void muevete(Arkanoid ark){
		//revote con el suelo y el techo 
		if (getY() > ark.getWidth() - getWidth() || getX() < 0){
			dy = dy * -1;
		}

		// revote con la derecha y la izquierda
		if (getX() > ark.getWidth() - getHeight() || getX() < 0){
			dx = dx * -1;
		}

		if (chequeaColision(getX(), getY(),ark)){
			if (chequeaColision (getX() + getWidth(), getY(), ark)){
				if (chequeaColision(getX(), getY ()+getHeight (), ark)){
					if (chequeaColision(getX()+getWidth(),getY()+getHeight(),ark)
				}
		}
	}
}
//mueve la bola en la direccion correcta
this.move(dx,dy);
private boolean chequeaColision (double posx, double posy, Arkanoid ark){
	boolean haChocado = false;

	GObject auxiliar;

	auxiliar = ark.getElementAt(posx, posy);

	if (auxiliar == ark.miCursor){// si entra aqui es que choca con el cursor 
		dy = dy * -1;
	}else if(auxiliar == null){//si vale null es que no habia nada ahi

	}else {
		ark.remove(auxiliar);
	}


	return haChocado;
}		
}}
