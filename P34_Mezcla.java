import java.util.ArrayList;
import java.util.Scanner;

public class P34_Mezcla {
	
	//variables y arreglos globales para el ordenamiento
	public int[] Arreglo;
	
	public int longitud = 0;
	
	public ArrayList<Integer> izquierda = new ArrayList<>();
	public ArrayList<Integer> derecha = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P34_Mezcla M = new P34_Mezcla();
		M.MenuCrear();
	}
	
	//Menu que crea el arreglo, consiste en preguntar si deseas ingresar un arreglo o que se cree aleatoriamente
	public void MenuCrear(){
		P("Elija la opcion que desee o cualquier otra cosa para salir.");
		P("1. Ingresar arreglo de 15 elementos.");
		P("2. Crear arreglo random de elementos.");
		
		String opc = LeerS();
		
		switch(opc){
		case "1":
			Ingresar();
			Menu();
			break;
		case "2":
			Crear();
			Menu();
			break;
			default:
				P("Saliendo del programa...");
				System.out.close();
		}
			
	}
	
	//cuando decides ingrear tu propio arreglo, este solo tiene 15 elementos, entonces te los pide uno a uno
	// y luego los guarda en el arreglo que se crea con longitud 15
	public void Ingresar(){
		Arreglo = new int[15];
		longitud = 15;
		for(int i = 0; i < Arreglo.length; i++){
			P("Ingrese el elemento " + i);
			Arreglo[i] = LeerI();
		}
	}
	
	/*Cuando decides crear el arreglo de forma aleatoria entonces establece el tamaño de dicho arreglo
	* y se llena con numeros aleatorios gracias a la clase Math.random
	*/
	public void Crear(){
		P("Ingrese la cantidad de elementos que desea en el arreglo aleatorio.");
		longitud = LeerI();
		Arreglo = new int[longitud];
		
		for(int j = 0; j < Arreglo.length; j++){
			Arreglo[j] = (int) (Math.random()*longitud);
		}
		
		P("Arreglo aleatorio creado.");
		Peek(Arreglo);
	}
	
	//Este es el menu principal donde se elije si ver el arreglo, ordenarlo o modificarlo
	public void Menu(){
		P("-----------------------------------------------------------");
		P("Elija la opcion que desee o cualquier otra cosa para salir.");
		P("1. Modificar arreglo.");
		P("2. Ordenar.");
		P("3. Ver arreglo.");
		
		String opc = LeerS();
		
		switch(opc){
		case "1":
			MenuCrear();
			break;
		case "2":
			MergeSort();
			Menu();
			break;
		case "3":
			Peek(Arreglo);
			Menu();
			break;
			default:
				P("Saliendo del programa...");
				System.out.close();
				break;
		}
	}
	
	/*
	 *  MergeSort.
	 *  tal como lo encontre en los libros, el Merge divide el arreglo en dos subarreglos, 
	 *  en duplos de 1, 2, 4, 8, 16... segun ese patron, luego compara los elementos de dichos arreglos
	 *  uno con otro y vuelve a ponerlos en el arreglo original ya ordenados. Esto se repite hasta que el
	 *  tamaño de el duplo es mayor al de la longitud del arreglo. 
	 */
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
							izquierda.add(Arreglo[j]);
						} else {
							derecha.add(Arreglo[j]);
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
			//Solamente se imprimen los arreglos para poder visualizar el proceso
			PeekList(izquierda);
			PeekList(derecha);
			
			//Aqui es donde ordenamos
			int cont = 0; //Este contador ayuda a no pasarnos de la longitud del arreglo
			while(a < izquierda.size()  && b < derecha.size()  &&  cont < longitud - 1) {
				/*
				 * Primero se hace una imitacion de burbuja, pero mucho mas veloz y menos costosa en tiempo
				 * y memoria, solo ordena los elementos adyacentes, por lo que es lineal
				 */
				for(int c = 0; c < izquierda.size() - 1; c++){
					if(izquierda.get(c) > izquierda.get(c+1)) {
						int temp = izquierda.get(c+1);
						izquierda.set(c + 1, izquierda.get(c));
						izquierda.set(c, temp);
					}
				}
				
				for(int c = 0; c < derecha.size() - 1; c++){
					if(derecha.get(c) > derecha.get(c+1)) {
						int temp = derecha.get(c+1);
						derecha.set(c + 1, derecha.get(c));
						derecha.set(c, temp);
					}
				}
				
				/*
				 * Ahora analizamos cual de los elementos en los arreglos esta el menor, entonces al encontrarlo
				 * lo guarda en el arreglo original
				 */
				if(izquierda.get(a) <= derecha.get(b)) {
					Arreglo[cont] = izquierda.get(a);
					a++;
				} else {
					Arreglo[cont] = derecha.get(b);
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
						Arreglo[i] = derecha.get(b);
						b++;
					}
				}
				
				if(b == derecha.size() && a < izquierda.size()) {
					for(int i = cont; i < longitud; i++) {
						Arreglo[i] = izquierda.get(a);
						a++;
					}
				}
				
			}
			
			//Aqui imprimimos el arreglo y duplicamos el valor de k
			Peek(Arreglo);
			P("¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
			k = k*2;
		} while(k < longitud);
//		for(int h = 0; h <longitud - 1; h++) {
//			if(Arreglo[h + 1] >= Arreglo[h]) {
//				
//			} else {
//				P("Elemento: " + Arreglo[h] + " esta fuera de lugar");
//				break;
//			}
//		}
	}
	
	
	
	//Metodo para imprimir arreglos
	public void Peek(int[] arr){
		for(int k = 0; k < arr.length; k++){
			if(k%20 == 0){
				P("");
			}
			System.out.print(arr[k] + "  ");
		}
		P("");
	}
	
	//Metodo para convertir arreglos dinamicos en arreglos estaticos
	public void PeekList(ArrayList al) {
		int[] a = new int[al.size()];
		for(int i = 0; i < a.length; i++) {
			a[i] = (int) al.get(i);
		}
		Peek(a);
	}
	
	//Metodo auxiliar para leer numeros enteros
	public int LeerI(){
		Scanner li = new Scanner(System.in);
		int l = li.nextInt();
		return l;
	}
	
	//Metodo auxiliar para leer cadenas
	public String LeerS(){
		Scanner ls = new Scanner(System.in);
		String l = ls.nextLine();
		return l;
	}
	
	//Metodo auxiliar para imprimir
	public void P(String mensaje){
		System.out.println(mensaje);
	}

}
