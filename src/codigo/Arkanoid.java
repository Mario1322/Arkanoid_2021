package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;


	Bola bola1 = new Bola(10,10, Color.BLUE);
	//declaro el cursor del juego
	Cursor miCursor = new Cursor(0, 400, 60, 10, Color.BLUE);



	public void init(){
		addMouseListeners();
		add(bola1);

		miCursor.setFilled(true);
		miCursor.setFillColor(Color.GREEN);
		add(miCursor);
	}

	public void run(){
		creaPiramide();
		while (true){
			//acciones que cambian el contenido de la pantalla
			bola1.muevete(this);//paso el objeto arkanoid que se esta ejecutando en bola
			pause(5);
		}
	}
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(getWidth(), evento.getX());
	}
	private void creaPiramide(){
		int numeroLadrillos = 14;
		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo (
						ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j,//posicion x
						ALTO_LADRILLO*j,//posicion y 
						ANCHO_LADRILLO,//ancho
						ALTO_LADRILLO,//alto
						Color.BLUE);
				add(miLadrillo);
			}
		}
	}
}


