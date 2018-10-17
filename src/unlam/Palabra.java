package unlam;

public class Palabra {

	private String palabra = "";
	
	public Palabra(String palabra) {
		this.palabra = palabra;
	}

	public int resolver() {
		String aux = this.palabra;
		aux = aux.concat(this.palabra.substring(0, 1));
		
		if (this.isPalindromo(aux)) {
			return 1;
		}
		
		return 0;
	}
	
	public boolean isPalindromo(String string) {
		
		for (int i = 0; i < string.length()/2; i++) {
			if (!string.substring(i, i+1).equals(string.substring(string.length()-i-1, string.length()-i))) {
				return false;
			}
		}
		return true;
	}

}
