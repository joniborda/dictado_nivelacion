package unlam;

import java.io.FileNotFoundException;

public class App {

	public static void main(String args[]) throws FileNotFoundException {
		
		Palabra palabra = new Palabra(Archivo.leer("src/pruebas/entrada/uno.in"));
		
		Archivo.escribir(palabra.resolver(), "src/pruebas/salida_obtenida/uno.out");
		
		Palabra palabra2 = new Palabra(Archivo.leer("src/pruebas/entrada/fatigaAgregaUno.in"));
		
		Archivo.escribir(palabra.resolver(), "src/pruebas/salida_obtenida/fatigaAgregaUno.out");
	}
}
