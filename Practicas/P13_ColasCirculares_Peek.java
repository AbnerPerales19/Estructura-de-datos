import java.util.Scanner;

public class P13_ColasCirculares_Peek {
	
	//Variables locales que se usan en muchos metodos
	public int t;
	public String[] ColaCircular;
	public int longitud;
	public int front;
	public int fin;
	public int contador;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P13_ColasCirculares_Peek cc = new P13_ColasCirculares_Peek
				();
		cc.CrearCola();
	}
	
	//Crea la cola en primera instancia
	//Asigno la longitud a la cola e inicializo las variables auxiliares, contador, fin y front
	public void CrearCola() {
		P("Ingrese la longitud de la cola.");
		longitud = LeerInt();
		ColaCircular = new String[longitud];
		
		contador = -1;
		fin = 0;
		front = -1;
		
		Menu();
	}
	
	//Menu de opciones segun lo que decisa el usuario
	public void Menu() {
		P("Ingresa la opcion deseada y cualquier otra para salir.");
		P("1. Agregar un elemento a la pila.");
		P("2. Eliminar elementos de la pila.");
		P("3. Ver los elementos de la pila.");
		
		String opc = LeerString();
		//Se evalua la opcion del usuario y se llama al metodo correspondiente
		switch(opc) {
		case "1":
			Agregar();
			break;
		case "2":
			Eliminar();
			break;
		case "3":
			Ver();
			break;
			default:
				P("Saliendo del programa");
				System.out.close();
				break;
		}
	}
	
	//Agrega datos a la cola siempre y cuando no este llena
	public void Agregar() {
		if(contador < longitud - 1) {
			contador++; //Maneja la cantidad de elementos en la cola
			front++;
			int x = front % longitud; // Esto permite que de vuelta a la cola.
			
			//Se ingresa el elemento nuevo
			P("Ingrese el elemento.");
			String dato = LeerString();
			ColaCircular[x] = dato;
			
		} else {
			P("La cola esta llena...");
		}
		
		Menu();
	}
	
	
	//Elimina datos de la cola siempre y cuando no este vacia
	public void Eliminar() {
		if(contador >= 0) {
			contador--; //Maneja la cantidad de elementos en la cola
			int x = fin % longitud; // Esto permite que de vuelta a la cola.
			
			//Se elimina el elemento de la cola
			P("El elemento " + ColaCircular[x] + " ha sido eliminado.");
			ColaCircular[x] = "";
			fin++;
			
		} else {
			P("La cola esta vacia, no hay elementos que eliminar...");
		}
		
		Menu();
	}
	
	//Submenu para ver los datos en la cola circular
	public void Ver() {
		P("Elija la opcion deseada y cualquier otra para volver al menu principal.");
		P("1. Ver el ultimo elemento ingresado.");
		P("2. Ver el primer elemento ingresado.");
		P("3. Ver todos los elementos.");
		
		String o = LeerString();
		
		switch(o) {
			case "1":
				PeekLast();
				break;
			case "2":
				PeekFirst();
				break;
			case "3":
				PeekAll();
				break;
				default:
					Menu();
					break;
		}
	}
	
	//Se evalua si hay elementos en la cola y se imprime el ultimo elemento ingresado
	public void PeekLast() {
		if(contador >= 0) {
			int y = front % longitud;
			P("El ultimo elemento ingresado es: " + ColaCircular[y]);
		} else {
			P("La cola esta vacia.");
		}
		
		Ver();
	}
	
	//Se evalua si hay elementos en la cola y se imprime el primer elemento ingresado, o sea, el que esta  apunto de salir
	public void PeekFirst() {
		if(contador >= 0) {
			int y = fin % longitud;
			P("El primer elemento ingresado es: " + ColaCircular[y]);
		} else {
			P("La cola esta vacia.");
		}
		
		Ver();
	}
	
	//Se evalua si hay elementos en la cola y se imprime todos los datos de la cola
	public void PeekAll() {
		if(contador >= 0) {
			String cadena = "";
			
			for(int i = 0; i < longitud; i++) {
				cadena = cadena + ColaCircular[i] + " - ";
			}
			P(cadena);
		} else {
			P("La cola esta vacia.");
		}
		
		Ver();
	}
	
	//Metodo auxiliar para imprimir
		public void P(String mensaje) {
			System.out.println(mensaje);
		}
		
		//Metodo auxiliar para leer enteros
		public int LeerInt() {
			Scanner li = new Scanner(System.in);
			
			try {
				t = li.nextInt();
			} catch(NumberFormatException e) {
				P("Por favor ingrese solo enteros");
				P(e.toString());
				LeerInt();
			}
			
			
			return t;
		}
		
		//Metodo auxiliar para leer cadenas
		public String LeerString() {
			Scanner ls = new Scanner(System.in);
			String cadena = ls.nextLine();
			return cadena;
		}

}