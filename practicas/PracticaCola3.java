package Cola;

//Colas - Practica de laboratorio - create and push para colas
import java.util.Scanner;

public class PracticaCola3 {
	
	public static  String[] cola;
	
	public static int contador = 0;
	
	public static int l;

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
	   	 
    	//Crear un try catch para cuando no ingrese int
    	System.out.println("Ingrese la longitud de la cola: ");
    	l = leer.nextInt();
    	Crear(l);
    	//Insertar(l);
    	Menu();
	}
	
	//Menu
	public static void Menu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("\n Que accion desea realizar?, ingrese el numero por favor.");
		System.out.println("1. Agregar elemento a la cola.");
		System.out.println("2. Ver elementos en la cola.");
		System.out.println("3. Eliminar elemento en la cola.");
		System.out.println("4. Salir.");
		
		int opcion = 0;
		Scanner l2 = new Scanner(System.in);
		
		try {
			opcion = l2.nextInt();
		} catch (NumberFormatException e) {
			System.out.println("Por favor ingrese solo numeros.");
		}
		
		switch(opcion) {
		case 1:
			Insertar();
			break;
		case 2:
			Ver();
			break;
		case 3:
			Eliminar();
			break;
		case 4:
			System.out.close();
			break;
		default:
			System.out.println("Ingreso un numero de opcion no valido.");	
			Menu();
			break;
		}
		
		
	}
	
	//Crear cola con longitud dada por el usuario
	public static void Crear(int longitud){
	    cola = new String[longitud];
	    System.out.println("Se creo cola, longitud: " + longitud + "\n");
	    
	    for(int i = 0; i < longitud; i++) {
	    	cola[i] = "0";
	    }
	}
	    
		//Agregar datos a la cola
	public static void Insertar(){
		int longitud = cola.length;
		
		if(contador < longitud) { //Mientras no haya tantos elementos como espacio en la lista
			Scanner l3 = new Scanner(System.in);
			
			System.out.println("Ingrese el elemento a la cola");
			cola[contador] = l3.nextLine();
			System.out.println("El elemento <" + cola[contador] + "> ha sido agregado a la cola");
			contador ++;
			Menu();
		} else {
			System.out.println("La cola esta llena, no acepta mas elementos. Favor de elegir otra opcion.");
			//System.out.println("Contador: " + contador + "  longitud: " + longitud);
			Menu();
			
		}
	}
	
	//Aqui el usuario decide que es lo que quiere ver
	public static void Ver() {
		System.out.println("Elija la opciones o alguna otra para salir.");
		System.out.println("1. Ver todos los elementos en la cola");
		System.out.println("2. Ver el ultimo elemento ingresado.");
		System.out.println("3. Ver el elemento a salir.");
		
		Scanner x = new Scanner(System.in);
		String xx = x.nextLine();
		//Segun la opcion del usuario se llama al metodo peek necesario
		switch(xx) {
		case "1":
			PeekAll();
			break;
		case "2":
			PeekLast();
			break;
		case "3":
			PeekFirst();
			break;
			default:
				System.out.println("Saliendo...");
				Menu();
				break;
		}
		
		Menu();
		
	}
	
	//Este metodo es para mostrar todos los datos de la cola incluido los vacios
	public static void PeekAll() {
		System.out.println("Hay espacio para " + l + " elementos en la cola:");
		for(int a = 0; a < l; a++) {
			System.out.println("Elemento " + a + " con dato " + cola[a]);
		}
		Ver();
	}
	
	//En este metodo muestras solo el ultimo ingresado
	public static void PeekLast() {
		System.out.println("Ultimo elemento ingresado: " + cola[contador - 1]);
		Menu();
	}
	
	//Este metodo muestra el elemento a punto de salir
	public static void PeekFirst() {
		System.out.println("Elemento a punto de salir: " + cola[0]);
		Menu();
	}
	
	public static void Eliminar() {
		int longitud2 = cola.length;
		
		if(contador > 0) {
			System.out.println("Se elimino el elemento " + cola[0]);
			contador--;
			for(int i = 0; i < longitud2 - 1; i++) {
				cola[i] = cola[i + 1];
				cola[i + 1] = "0";
			} 
			
		} else {
			System.out.println("La cola esta vacia.");
		}
			Menu();
			
		}
		
		
}