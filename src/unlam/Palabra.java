package unlam;

public class Palabra {

	private String palabra = "";
	
	public Palabra(String palabra) {
		this.palabra = palabra;
	}

	public int resolver() {
		String aux = this.palabra;
		
		aux.concat(this.palabra.substring(0, 1));
		
		if (this.isPalindromo(aux)) {
			return 1;
		}
		
		return 0;
	}
	
	public boolean isPalindromo(String string) {
		
		// todavia no funciona
		for (int i = 0; i < string.length()/2; i++) {
			if (string.substring(i, 1) != string.substring(string.length()-i-1, 1)) {
				return false;
			}
		}
		return true;
	}

}
