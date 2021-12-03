package codigo;


import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;

	Bola bola1 = new Bola(10, 10, Color.PINK);
	//Cursor miCursor = new Cursor(0, 400, 60, 10, Color.GREEN);
	//vamos a poner el fondo
	GImage fondo = new GImage("imagenes1/estrellas-9.gif");

	//vamos a poner el fondo del lado derecho
	GRect fondoMarcador = new GRect(340, 600);
	//vamos a poner el marcador para ver los ladrillos eliminados
	Marcador miMarcador = new Marcador(20, 40);
	//vamos a poner el logo del juego
	GImage logo = new GImage("imagenes1/logo.png");
	//Esta es la pantalla de carga del juego, la introduccion
	GImage carga = new GImage("imagenes1/carga (2) (1).gif");
	//Esta es la pantalla del final del juego
	GImage fin = new GImage("imagenes1/fin.jpg");
	Cursor2 miCursor = new Cursor2("imagenes1/cursor.jpg",0 ,400);
	boolean vueltaAlPrincipio = true;

	public void init(){
		setSize(ANCHO_PANTALLA + 300 ,500);
		add(carga);
		//no se puede hacer click con el raton en la pantalla
		waitForClick();
		//elimina el fondo de la pantalla de carga
		remove(carga);
		//añade el fondo del videojuego
		add(fondo);
		//Añadimos el fondo del lado derecho
		fondoMarcador.setFillColor(Color.PINK);
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA- 30,0);
		//Estamos añadiendo el logo de arkanoid en el lado derecho
		add(logo, ANCHO_PANTALLA-25, 10);
		addMouseListeners();
		//vamos a 
		add(bola1, 50, 80);
		add(miCursor);
	}
	public void run(){

		pause(100);
		creaPiramide();
		miMarcador.addMarcador(this);
		while(true){
		
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando
			pause(20);
			miCursor.muevete(ANCHO_PANTALLA - 30, (int) bola1.getX());
			
		
		}
	}




	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}



	private void creaPiramide(){
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;

		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(
						ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						ALTO_LADRILLO*j + desplazamiento_inicial_Y,  //pos Y
						ANCHO_LADRILLO, //ancho
						ALTO_LADRILLO, // alto
						Color.GREEN);

				add(miLadrillo);
				pause(30);
			}
		}
	}


}