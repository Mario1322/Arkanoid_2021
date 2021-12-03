package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;

import acm.graphics.GRect;

public class Marcador extends GRect{
//Como empieza el marcadr¡or
	GLabel texto = new GLabel("");
	int puntuacion = 0;

	public Marcador(double width, double height) {
		super(width, height);
//muestra lo que va a ver la persona al jugar al Arkanoid
		texto.setLabel("0");
		texto.setColor(Color.GREEN);
		texto.setFont(new Font("Arial", Font.BOLD, 40));

	}

	//suma el nº de puntos que se indica en la variable puntos 
	//a la puntuacion actual
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos; // puntuacion += puntos;
		texto.setLabel("" + puntuacion);

	}
//este es el comando que hace que se muestre el numero de ladrillos eliminados
	public void addMarcador(Arkanoid arkanoid){


		arkanoid.add(texto, arkanoid.getWidth() - 100, 200);
	}


}