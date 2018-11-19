import java.util.Scanner;

public class P33_MetodoShell {

	public int contador = 0; //Contador para medir la cantidad de ciclo que hace
	public int tamano = 50; //tamano que tendra el arreglo
	public int[] arreglo; //Se declara el arreglo
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P33_MetodoShell m = new P33_MetodoShell();
		m.Iniciar();
	}
	
	
	public void Iniciar() {
		/*
		 * Primero se crea el arreglo
		 * Luego se llama al metodo Quick, que hace el proceso de ordenamiento
		 * Despues imprimo el arreglo ya ordenado
		 */
		Scanner leer = new Scanner(System.in);
		P("Arreglo generado aleatoriamente.");
		Crear();
		P("Ingrese enter para ordenar arreglo por metodo ShellSort.");
		String x = leer.nextLine();
		Shell(arreglo);
		P("************************************");
		Imprimir();
		P("Cantidad de veces que se cicla: " + contador);
	}
	
	public void Shell(int[] a) {
		
		//Variables locales, longitud del arreglo, contador, un auxiliar y una bandera
		int x, i, aux;
		boolean b;
		x = a.length;
		
		//Mientras la longitud del arreglo sea mayor a cero, o sea, mientras el arreglo tenga al menos dos datos
		//que ordenar
		while(x > 0){
			// se divide el arreglo en dos, para poder comparar
			x = x / 2;
			b = true; //Se asigna valor true a la bandera para poder continuar en el siguiente ciclo
			
			while(b){
				//Se vuelve false la bandera, para que no cicle infinitamente, sino bajo ciertas condiciones
				b = false;
				i = 0; //reiniciamos el contador
				
				while ((i+x) <=a.length-1){ //Se asegura que nuestro avance en los indices sea menor  a la longitud
					//El ultimo es nuestro pivote
					contador++;
					if (a[i] > a[i + x]){ //Se compara la primera mitad del arreglo con la segunda mitad
						//x marca la division del arreglo entre la mitad derecha e izquierda
						// Luego se hace un intercambio, para garantizar que el menor este a la mitad izquierda
						aux = a[i];
						a[i] = a[i+x];
						a[i+x] = aux;
						b = true; //Se vuelve true la bandera para que vuelva a ciclarse
					}
					i = i +1;
					//avanzamos en el arreglo, nuestro contador
				} //Cuando deja de ciclarse manda el control al ciclo anterior
				/*
				 * Si se vuelve a ejecutar entonces reinicia el contador y hace otra pasada para asegurarse
				 * Si no se vuelve a ejecutar, entonces cede el control al sigueinte ciclo
				 */
			}
			/*
			 * Si se vuelve a ejecutar, entonces se reduce el tamano de x, por tanto se hacen cada vez
			 * Mas comparaciones, y cada vez mas cercanas, hasta comparar 1 a 1
			 */
		}
		
		P("Arreglo ordenado.");
	}
	
	
	//Crea el arreglo aleatorio, con la longitud definida arriba
		public void Crear() {
			//Todos los numeros en el arreglo son creados dentro de cierto rango y aleatroiamente, luego se imprime
			arreglo = new int[tamano];
			for(int i = 0; i < tamano; i++) {
				arreglo[i] = (int)(Math.random()*tamano);
			}
			Imprimir();
		}
		
		//Se imprime el arreglo con un for, se concatenan los datos y luego se despliegan como vector
		public void Imprimir() {
			String x = "[";
			for(int i = 0; i < tamano; i++) {
				x = x +arreglo[i] + ", ";
			}
			P(x + "]");
		}
		
		//Vector auxiliar que permite imprimir en consola
		public void P(String mensaje) {
			System.out.println(mensaje);
		}

}
