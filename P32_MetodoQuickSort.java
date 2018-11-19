import java.util.ArrayList;
import java.util.Scanner;

public class P32_MetodoQuickSort {

	
	public int contador = 0; //Contador para medir la cantidad de ciclo que hace
	public int tamano = 200; //tamano que tendra el arreglo
	public int[] arreglo; //Se declara el arreglo
	
	public static void main(String[]args) {
		P32_MetodoQuickSort m = new P32_MetodoQuickSort();
		
		m.Iniciar();
	}
	
	//Instrucciones para iniciar
	public void Iniciar() {
		/*
		 * Primero se crea el arreglo
		 * Luego se llama al metodo Quick, que hace el proceso de ordenamiento
		 * Despues imprimo el arreglo ya ordenado
		 */
		Scanner leer = new Scanner(System.in);
		P("Arreglo generado aleatoriamente.");
		Crear();
		P("Ingrese enter para ordenar arreglo por metodo Quicksort.");
		String x = leer.nextLine();
		Quick(arreglo, 0, tamano -1);
		P("************************************");
		P("Arreglo ordenado.");
		Imprimir();
		P("Cantidad de veces que se llama al metodo: " + contador);
	}
	
	
	//Metodo Quick
	public void Quick(int[] a, int izq, int der) {
		/*
		 * El metodo recibe un arreglo y un rango, en base a los dos punteros/numeros que se recibem
		 * El contador se incrementa para saver cuantas veces se lalma al metodo
		 * Asigno el pivote al primer elemento segun el rago elejido
		 * Asigno los valores recibidos a variables locales, que estaremos modificando en lo largo 
		 * del proceso
		 */
		
		contador++;
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
            Quick(a, izq, right - 1);
        }
        if (right + 1 < der) {
        	//Si el limite inicial derecho es mayor a el limite derecho actual mas 1, entonces se vuelve a ciclar
        	//Esto permite ciclar solo si hay datos que ordenar
            Quick(a, right + 1, der);
        }
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
