import java.util.Scanner;

public class P31_MetodoBurbuja {

	public int[] arreglo = new int[100];
	public int condiciones = 0;
	public int ciclos = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P31_MetodoBurbuja m = new P31_MetodoBurbuja();
		m.Crear();
		m.Ordenar();
	}
	
	public void Imprimir() {
		String x = "[";
		for(int i = 0; i < arreglo.length; i++) {
			x = x + arreglo[i] + ", ";
		}
		P(x + "]");
	}
	
	public void Crear() {
		for(int i = 0; i < arreglo.length; i++) {
			arreglo[i] = (int) (Math.random()*100);
		}
		Imprimir();
	}
	
	public void Ordenar() {
		for(int i = 0; i< arreglo.length -1; i++) {
			for(int j = 0; j < arreglo.length - 1; j++) {
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
