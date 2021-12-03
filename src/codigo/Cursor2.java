package codigo;



import acm.graphics.GImage;


public class Cursor2 extends GImage{

	
public Cursor2(String name, double x, double y) {
		super(name, x, y);
		
	}

// esta el la posicion que puede tener la barra en el juego
	public void muevete(int anchopantalla, int posX){
		if(posX + getWidth()< anchopantalla) {
			setLocation(posX , getY());
		}
	}

}