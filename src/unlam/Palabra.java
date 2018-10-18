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

		if (this.isPalindromo(this.palabra)) {
			return 0;
		}

		// agrego primera letra al final
		String aux = this.palabra.concat(this.palabra.substring(0, 1));

		if (this.isPalindromo(aux)) {
			return 1;
		}

		// agrego ultima adelante
		aux = this.palabra.substring(this.palabra.length() - 1, this.palabra.length()).concat(this.palabra);

		if (this.isPalindromo(aux)) {
			return 1;
		}

		this.calcularMayorSimetria(this.palabra);

		int cantidadLetras = 0;

		while (!this.isPalindromo(this.palabra)) {
			aux = this.ponerAlInicioDeLaSimetria(this.posicionMayorSimetria - this.mayorSimetria,
					this.posicionMayorSimetria + this.mayorSimetria);

			int simetriaAnterior = this.mayorSimetria;

			if (aux != null && this.calcularMayorSimetria(aux) > simetriaAnterior) {
				cantidadLetras++;
				if (this.isPalindromo(aux)) {
					return cantidadLetras;
				}
				this.palabra = aux;
			} else {
				aux = this.ponerAlFinalDeLaSimetria(this.posicionMayorSimetria + this.mayorSimetria);
				cantidadLetras++;
				if (this.isPalindromo(aux)) {
					return cantidadLetras;
				}
				this.palabra = aux;
			}
		}
		return 0;
	}

	private String ponerAlInicioDeLaSimetria(int posicionArranque, int posicionFinal) {
		if (posicionFinal < this.palabra.length()) {
			String aux = this.palabra.substring(0, posicionArranque + 1);

			aux = aux.concat(this.palabra.substring(posicionFinal, posicionFinal + 1));
			return aux.concat(this.palabra.substring(1));
		}
		return null;
	}

	private String ponerAlFinalDeLaSimetria(int posicionArranque) {
		String aux = this.palabra.substring(0, posicionArranque);
		aux = aux.concat(this.palabra.substring(this.posicionMayorSimetria - this.mayorSimetria,
				this.posicionMayorSimetria - this.mayorSimetria + 1));
		return aux.concat(this.palabra.substring(posicionArranque));
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

	public int calcularMayorSimetria(String aux) {
		this.mayorSimetria = 0;
		this.posicionMayorSimetria = 0;
		int simetria_actual = 0;
		if (aux == null) {
			return 0;
		}
		for (int i = 1; i < aux.length() - 1; i++) {
			simetria_actual = this.simetria(aux, i);
			if (this.mayorSimetria < simetria_actual) {
				this.mayorSimetria = simetria_actual;
				this.posicionMayorSimetria = i;
			}
		}
		return this.mayorSimetria;
	}

}
