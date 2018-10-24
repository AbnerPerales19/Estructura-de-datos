package Cola;

//Colas - Practica de laboratorio - create and push para colas
import java.util.Scanner;

public class PracticaCola {
	
	public static  String[] cola;
	
	public static int contador = 0;

	public static void main(String[] args) {
		
		int l = 0;
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
	}
	    
		//Agregar datos a la cola
	public static void Insertar(){
		int longitud = cola.length;
		
		if(contador < longitud) {
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
	
	public static void Ver() {
		
	}
	
	public static void Eliminar() {
		
	}
}
