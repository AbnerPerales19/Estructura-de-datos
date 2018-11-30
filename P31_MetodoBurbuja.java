import java.util.Scanner;

public class P31_MetodoBurbuja {

	//variables y vectores necesarios para el proceo
	public int[] arreglo = new int[100];
	public int condiciones = 0;
	public int ciclos = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P31_MetodoBurbuja m = new P31_MetodoBurbuja();
		m.Crear();
		m.Ordenar();
	}
	
	//Imprime el arreglo
	public void Imprimir() {
		String x = "[";
		for(int i = 0; i < arreglo.length; i++) {
			x = x + arreglo[i] + ", ";
		}
		P(x + "]");
	}
	
	//Crea el arreglo de forma aleatoria
	public void Crear() {
		for(int i = 0; i < arreglo.length; i++) {
			arreglo[i] = (int) (Math.random()*100);
		}
		Imprimir();
	}
	
	/*
	 * Metodo burbuja, ordenalos elemntos de forma lineal
	 * 
	 * Consiste en intercambiar de lugar elementos que esten inmediatamente al lado, segun el criterio de
	 * cual es mayor o menor. Esto se hace recorriendo todo el arreglo.
	 * Esto se hace la cantidades de veces igual a la longitud del arreglo. Esto tomando en cuenta el peor
	 * de los casos, por si el menor esta al final del arreglo, le tomara longitud de pasos llegar al inicio
	 */
	
	public void Ordenar() {
		for(int i = 0; i< arreglo.length -1; i++) {
			for(int j = 0; j < arreglo.length - 1; j++) { //Se hace menos uno, pues se utiliza un j+1 y no queremos probocar un error de indices
				if(arreglo[j] > arreglo[j+1]) {
					int aux = arreglo[j];
					arreglo[j] = arreglo[j+1];
					arreglo[j+1] = aux;
					condiciones++;
				}
				ciclos++;
				Imprimir();
			}
			ciclos++;
		}
		//Imprimo el arreglo ordenado y la cantidad de comparaciones
		P("");
		P("");
		P("************************************************");
		P("Arreglo ya ordenado.");
		Imprimir();
		P("Condicione hechas: " + condiciones);
		P("Ciclos hechos: " + ciclos);
	}
	
	public void P(String mensaje) {
		System.out.println(mensaje);
	}

}
