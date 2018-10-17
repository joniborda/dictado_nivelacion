package unlam;

public class Palabra {

	private String palabra = "";
	private int mayorSimetria;
	private int posicionMayorSimetria;

	public Palabra(String palabra) {
		this.palabra = palabra;
	}

	/**
	 * Se resuelve de dos formas, o agrega la primer letra al final o la ultima
	 * letra al principio. Luego de eso me fijo en donde hay una simetria dentro de
	 * la palabra. A partir esa simetria lo que hago es completar la simetria
	 * 
	 * @return Cantidad de letras que tuve que agregar para hacerlo palindromo
	 */
	public int resolver() {
		String aux = this.palabra.concat(this.palabra.substring(0, 1));
		// agrego primera letra al final
		if (this.isPalindromo(aux)) {
			return 1;
		}

		this.calcularMayorSimetria(aux);
		int posicionArranque = this.posicionMayorSimetria - this.mayorSimetria;
		/*
		 * tengo que poner todas las letras que faltan para llegar a la ultima pero en
		 * sentido inverso. Ej: mesetam -> matesetam
		 */
		String aux2 = null;
		aux2 = aux.substring(0, posicionArranque + 1);
		int cantidadLetras = 1;
		for (int j = aux.length() - 1; j > this.posicionMayorSimetria + this.mayorSimetria; j--) {
			aux2 = aux2.concat(aux.substring(j - 1, j));
			cantidadLetras++;
		}

		aux2 = aux2.concat(aux.substring(1));

		if (this.isPalindromo(aux2)) {
			return cantidadLetras;
		}

		// agrego ultima adelante
		aux = this.palabra.substring(this.palabra.length() - 1, this.palabra.length()).concat(this.palabra);

		if (this.isPalindromo(aux)) {
			return 1;
		}

		return 0;
	}

	public boolean isPalindromo(String string) {

		for (int i = 0; i < string.length() / 2; i++) {
			if (!string.substring(i, i + 1).equals(string.substring(string.length() - i - 1, string.length() - i))) {
				return false;
			}
		}
		return true;
	}

	public int simetria(String string, int posicion) {
		int simetrias = 0;
		for (int i = 0; i < posicion; i++) {
			if (!string.substring(posicion + i, posicion + i + 1)
					.equals(string.substring(posicion - i, posicion - i + 1))) {
				return simetrias;
			}
			simetrias++;
		}
		return simetrias;
	}

	public void calcularMayorSimetria(String aux) {
		this.mayorSimetria = 0;
		this.posicionMayorSimetria = 0;
		int simetria_actual = 0;
		for (int i = 1; i < aux.length() - 1; i++) {
			simetria_actual = this.simetria(aux, i);
			if (this.mayorSimetria < simetria_actual) {
				this.mayorSimetria = simetria_actual;
				this.posicionMayorSimetria = i;
			}
		}
	}

}
