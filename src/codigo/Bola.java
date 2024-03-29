package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx = 1; //velocidad en el eje x
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
		//rebote con el suelo y rebote con el techo
		if (getY() > ark.getHeight()){
			
			
			ark.add(ark.fin);
			ark.waitForClick();
			ark.removeAll();
			ark.init();
			ark.run();
		}
		if(getY() < 10){
			dy = dy * -1;
		}
			

		//rebote con la pared derecha y rebote con la pared izquierda
		if (getX()+getWidth() > ark.ANCHO_PANTALLA - 30 || getX() < 10){
			dx = dx * -1;
		}

		//chequeo la esquina superior izquierda de la bola
		if (chequeaColision(getX(),	getY(), ark) ){
			if (chequeaColision(getX() + getWidth(), getY(), ark) ){
				if (chequeaColision(getX(),	getY()+getHeight(), ark) ){
					if (chequeaColision(getX()+getWidth(), getY()+getHeight(), ark) ){

					}
				}
			}
		}

		//mueve la bola en la direcci�n correcta
		this.move(dx,dy);
	}

	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;

		auxiliar = ark.getElementAt(posx, posy);

		if (auxiliar == ark.miCursor){ //si entra aqu� es que choca con el cursor
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){ //si vale null es que no hab�a nada ahi

		}else if (auxiliar instanceof Ladrillo){ //si es un ladrillo(Consigue rebotar bien con los ladrillos)
			if (auxiliar.getX() + auxiliar.getWidth() == posx || auxiliar.getX() == posx){
				dx = dx * -1;
			}
			if (auxiliar.getY() + auxiliar.getHeight() == posy || auxiliar.getY() == posy){
				dy = dy * -1;
			}
			ark.miMarcador.incrementaMarcador(1);

			ark.remove(auxiliar);//borro el ladrillo
			noHaChocado = false;
		}

		return noHaChocado;
	}

}