package unlam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Archivo {

	public static String leer(String archivo) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(archivo));
		
		String string = sc.nextLine();
		
		sc.close();
		
		return string;
	}
	
	public static void escribir(int res, String archivo) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(archivo));
		
		pw.write(String.valueOf(res));
		
		pw.close();
	}
}
