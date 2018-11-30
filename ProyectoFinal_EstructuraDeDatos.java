import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoFinal_EstructuraDeDatos {

	/*
	 * Proyecto final de Estructura de datos
	 * Horario de la clase: Lunes a viernes, 13:00 pm a 14:00 pm
	 * Alumno: Perales Niebla Abner Jesús
	 * Profesor Ray Parra
	 * Fecha de entrega en github: 30 diciembre 2018
	 * 
	 *  Instrucciones: hacer 30 pruebas con los 4 metodos de ordenamiento vistos en clase, ordenar el mismo
	 *  	arreglo con los 4 metodos, pero un arreglo distinto por cada prueba. Comparar tiempos.
	 */
	/*
	 * Todos los siguientes son arreglos y variables globales necesarios para el proyecto
	 */
	public int[] Arreglo;
	public int[] ArregloMerge;
	public int[] ArregloQuick;
	public int[] ArregloShell;
	public int[] ArregloBubble;
	
	public int longitud = 0;
	public ArrayList<Integer> izquierda = new ArrayList<>();
	public ArrayList<Integer> derecha = new ArrayList<>();
	
	//Variables de tiempo
	long BubbleS, QuickS, ShellS, MergeS;
	long comienzo, fin, total;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProyectoFinal_EstructuraDeDatos PF = new ProyectoFinal_EstructuraDeDatos();
		PF.Instrucciones();
	}
	
	/*
	 * Este es el metodo en el que se ejecutaran todas las pruebas
	 * Se presentan instrucciones generales y luego un ciclo de 30 iteraciones
	 */
	public void Instrucciones() {
		//Instrucciones generales
		P("Se hara la comparacion con 30 arreglos.");
		P("Cada arreglo tendra 10000 elementos aleatorios.");
		P("Cada arreglo se presenta al inicio de cada ciclo.");
		longitud = 5000;
		
		//Ciclo para las 30 pruebas
		for(int f = 0; f < 30; f++) {
			//Creamos el arreglo aleatorio y luego lo guardamos en los auxiliares
			Arreglo = Random(longitud);
			ArregloBubble = Arreglo;
			ArregloQuick = Arreglo;
			ArregloShell = Arreglo;
			ArregloMerge = Arreglo;
			
			P("Arreglo a ordenar.");
			Peek(Arreglo);
			/*
			 * En cada modulo de cada metodo se realiza lo siguiente
			 * 
			 * Se resetean las variables de tiempo a cero, para evitar que se sumen a otros tiempos.
			 * Se toma el tiempo en milisegundos de inicio
			 * Se realiza el proceso
			 * Se toma el tiempo en milisegundos al fin del proceso
			 * Se resta el final - el inicio y se obtiene el total
			 * Se imprime el tiempo que duro y se suma el valor a una variable que obtiene todos los tiempos
			 * por cada metodo.
			 */
			
			//*********** BubbleSort en ejecucion *********************
			comienzo = 0;
			fin = 0;
			total = 0;
			comienzo  = System.currentTimeMillis();
			Bubble();
			P("Burbuja Ordenado...");
			fin = System.currentTimeMillis();
			total = fin - comienzo;
			P("BubbleSort: " + total);
			BubbleS = BubbleS + total;
			//*********** BubbleSort en ejecucion *********************
			
			//*********** QuickSort en ejecucion *********************
			comienzo = 0;
			fin = 0;
			total = 0;
			comienzo  = System.currentTimeMillis();
			QuickSort(ArregloQuick, 0, longitud -1);
	        P("Quicksort Ordenado...");
			fin = System.currentTimeMillis();
			total = fin - comienzo;
			P("QuickSort: " + total);
			QuickS = QuickS + total;
			//*********** QuickSort en ejecucion *********************
			
			//*********** ShellSort en ejecucion *********************
			comienzo = 0;
			fin = 0;
			total = 0;
			comienzo  = System.currentTimeMillis();
			ShellSort(ArregloShell);
			P("ShellSort Ordenado...");
			fin = System.currentTimeMillis();
			total = fin - comienzo;
			P("ShellSort: " + total);
			ShellS = ShellS + total;
			//*********** ShellSort en ejecucion *********************
			
			//*********** MergeSort en ejecucion *********************
			comienzo = 0;
			fin = 0;
			total = 0;
			comienzo  = System.currentTimeMillis();
			MergeSort();
			P("MergeSort Ordenado...");
			fin = System.currentTimeMillis();
			total = fin - comienzo;
			P("MergeSort: " + total);
			MergeS = MergeS + total;
			//*********** MergeSort en ejecucion *********************
			
			//Esto detiene la ejecucion para que no salten todas la pruebas de una
			P("Presione enter para avanzar a la siguiente prueba...");
			String detener = LeerS();
			P("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
		
		//Guarda los tiempos de los metodos y el nombre
		double[] metodos = {BubbleS/30, QuickS/30, ShellS/30, MergeS/30};
		String[] nombres = {"BubbleSort", "QuickSort", "ShellSort", "MergeSort"};
		P("---------------------------------------------------------------");
		P("Promedio de los tiempos de ejecucion.");
		
		//Con un mini burbuja se ordenan de menor a mayor junto al nombre
		for(int e = 0; e < 3; e++) {
			for(int ee = 0; ee < 3; ee++) {
				if(metodos[ee] > metodos[ee + 1]){
					double ax = metodos[ee];
					metodos[ee] = metodos[ee + 1];
					metodos[ee + 1] = ax;
					
					String as = nombres[ee];
					nombres[ee] = nombres[ee + 1];
					nombres[ee + 1] = as;
				}
			}
		}
		
		//Se despliegan los tiempos de los metodos
		for(int v = 0; v < 4; v++) {
			P(nombres[v] + ": " + metodos[v]);
		}
		P("Presione enter para salir.");
		String enter = LeerS();
		System.out.close();
	}
	
	//*********************************** METODOS DE ORDENAMIENTO *****************************************
	
	
	public void Bubble() {
		/*
		 * Metodo burbuja, ordenalos elemntos de forma lineal
		 * 
		 * Consiste en intercambiar de lugar elementos que esten inmediatamente al lado, segun el criterio de
		 * cual es mayor o menor. Esto se hace recorriendo todo el arreglo.
		 * Esto se hace la cantidades de veces igual a la longitud del arreglo. Esto tomando en cuenta el peor
		 * de los casos, por si el menor esta al final del arreglo, le tomara longitud de pasos llegar al inicio
		 */
		//Se hace menos uno, pues se utiliza un j+1 y no queremos probocar un error de indices
		for(int i = 0; i< ArregloBubble.length -1; i++) {
			for(int j = 0; j < ArregloBubble.length - 1; j++) {
				if(ArregloBubble[j] > ArregloBubble[j+1]) {
					int aux = ArregloBubble[j];
					ArregloBubble[j] = ArregloBubble[j+1];
					ArregloBubble[j+1] = aux;
				}
			}
		}
	}
	
	public void QuickSort(int[] a, int izq, int der) {
			/*
			 * El metodo recibe un arreglo y un rango, en base a los dos punteros/numeros que se recibem
			 * El contador se incrementa para saver cuantas veces se lalma al metodo
			 * Asigno el pivote al primer elemento segun el rago elejido
			 * Asigno los valores recibidos a variables locales, que estaremos modificando en lo largo 
			 * del proceso
			 */
			
			int pivote = a[izq]; 
			int left = izq;
			int right = der;
			int aux;
			
			//Mientras el limite izquierdo sea menor al limite derecho, se ejecutara este ciclo
			//Cuando es igual, significa que ya se compararon todos los numeros del arreglo
			while (left < right) {
				//Mientras el numero evaluado sea menor o igual que el pivote, el limite izquierdo avanza
	            while (a[left] <= pivote && left < right) {
	                left++;
	            }
	          //Mientras el numero evaluado sea mayor que el pivote, el limite derecho disminuye
	            while (a[right] > pivote) {
	                right--;
	            }
	            
	            //Si el limite izquiero es menor al limite derecho entonces se intercambias los valores
	            //de los arreglos en estas posiciones
	            if (left < right) {
	                aux = a[left];
	                a[left] = a[right];
	                a[right] = aux;
	            }
	            
	            //Seguimos comparando si left < right por que esto puede cambiar dentro del while
	        }
			
			//Luego intercambiamo los extremos del arreglo
	        a[izq] = a[right];
	        a[right] = pivote;
	        
	        //esto define el rango de la siguiente iteracion recursiva
	        if (izq < right - 1) {
	        	//Si el limite inicial izquierdo es menor a el limite derecho actual menos 1, entonces se vuelve a ciclar
	        	//Esto permite ciclar solo si hay datos que ordenar
	            QuickSort(a, izq, right - 1);
	        }
	        if (right + 1 < der) {
	        	//Si el limite inicial derecho es mayor a el limite derecho actual mas 1, entonces se vuelve a ciclar
	        	//Esto permite ciclar solo si hay datos que ordenar
	            QuickSort(a, right + 1, der);
	        }
		}
	
	public void ShellSort(int[] a) {
		
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
	}
	
	public void MergeSort() {
		//Primero declaramos nuestro contador, por asi llamarlo, el cual se aumentara segun la condicion que presentamos anteriormente
		int k = 1; 
		do { //Este es el ciclo que permitira ciclarnos hasta que la condicion cumpla
			//Se inicializan los arreglos en cada ciclo para resetearlos, junto con las demas variables
			//Los arreglos son dinamicos, pues el calcular su tamaño en cada iteracion es tiempo muerto
			
			izquierda = new ArrayList<>();
			derecha = new ArrayList<>();
			int a = 0;
			int b = 0;
			int t = 0;int w = 0;
			int y = 0;
			int id = 0;
			
			//Este primer while permite separar el arreglo original en dos
			while(t < longitud) {
				//w y y establecen un rango en el arreglo original que se copiara en los arreglos auxiliares
				w = y;
				y = y + k;
				for(int j = w; j< y; j++) {
					/*
					 * Este for guarda con una condicion dichos elementos en los arreglos
					 */
					if(t < longitud) {
						if(id == 0) {
							izquierda.add(ArregloMerge[j]);
						} else {
							derecha.add(ArregloMerge[j]);
						}
						t++;
					} else {
						break;
					}	
				}
				//Este cambio de valor con condiciones permite cambiar entre los arreglos auxiliares
				if(id == 0) {
					id = 1;
				} else {
					id = 0;
				}
			}
		
			
			//Aqui es donde ordenamos
			int cont = 0; //Este contador ayuda a no pasarnos de la longitud del arreglo
			while(a < izquierda.size()  && b < derecha.size()  &&  cont < longitud - 1) {	
				
				
				/*
				 * Ahora analizamos cual de los elementos en los arreglos esta el menor, entonces al encontrarlo
				 * lo guarda en el arreglo original
				 */
				if(izquierda.get(a) <= derecha.get(b)) {
					ArregloMerge[cont] = izquierda.get(a);
					a++;
				} else {
					ArregloMerge[cont] = derecha.get(b);
					b++;
				}
				cont++;
				
				/*
				 * Estas siguientes condiciones se ejecutan cuando un arreglo auxiliar ya se copio en el
				 * original ya ordenado, y como el otro ya no tiene elementos para comparar entonces se
				 * copia solo lo que falta 
				 */
				if(a == izquierda.size() && b < derecha.size()) {
					for(int i = cont; i < longitud; i++) {
						ArregloMerge[i] = derecha.get(b);
						b++;
					}
				}
				if(b == derecha.size() && a < izquierda.size()) {
					for(int i = cont; i < longitud; i++) {
						ArregloMerge[i] = izquierda.get(a);
						a++;
					}
				}
			}
			
			k = k*2;
		} while(k < longitud);
		
		
	}
	
	//*********************************** METODOS DE ORDENAMIENTO *****************************************
	
	//Metodo auxiliar para crear arreglos con elementos aleatorios
	public int[] Random(int l) {
		int[] x = new int[l];
		for(int i = 0; i < l; i++) {
			x[i] = (int) (Math.random()*l);
		}
		return x;
	}
	
	//Metodo auxiliar para imprimir arreglos
	public void Peek(int[] arr){
		for(int k = 0; k < arr.length; k++){
			if(k%20 == 0){
				P("");
			}
			System.out.print(arr[k] + "  ");
		}
		P("");
	}
	
	
	//Metodo auxiliar para leer cadenas
		public String LeerS(){
			Scanner ls = new Scanner(System.in);
			String l = ls.nextLine();
			return l;
		}
	
	//Metodo auxiliar de impresion
	public void P(String mensaje) {
		System.out.println(mensaje);
	}

}
