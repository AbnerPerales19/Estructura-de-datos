import java.util.Scanner;

public class P16_ColasDobles_Peek {

	//Variables auxiliares para la cola doble
	
	public int longitud;
	public int contadorI = 0;
	public int contadorD = 0;
	public String[] ColaDoble;
	public int divisor;
	
	public int frontI;
	public int frontD;
	public int finI;
	public int finD;
	
	//metodo main, llama al metodo crear cola
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P16_ColasDobles_Peek p16 = new P16_ColasDobles_Peek();
		p16.P("Cola doble");
		p16.CrearCola();
	}
	
	//Metodo para crear la cola, pide la longitud y crea la cola
	public void CrearCola() {
		P("Ingrese la longitud de la cola derecha e izquierda.");
		longitud = LeerI();
		ColaDoble = new String[longitud*2];
		
		divisor = longitud - 1;
		
		//frontI = 0;
		finI = -1;
		
		//frontD = longitud*2 - 1;
		finD = longitud*2;
		
		for(int k = 0; k < ColaDoble.length - 1; k++) {
			ColaDoble[k] = "0";
		}
		
		Menu();
	}
	
	//Menu principal, aqui se decique que accion se ejecutara en la cola
	public void Menu() {
		P("------------------------------------------------------");
		P("Ingrese la opcion deseada o cualquier otra para salir.");
		P("1. Ingresar datos a la cola");
		P("2. Eliminar de la cola.");
		P("3. Leer datos de la cola.");
		
		String opc = LeerS();
		
		switch(opc) {
		case "1":
			Push();
			Menu();
			break;
		case "2":
			Pop();
			Menu();
			break;
		case "3":
			Peek();
			Menu();
			break;
			default:
				P("Saliendo del programa...");
				System.out.close();
				break;
		}
	}
	
	//Metodo push, se elije entre ingresar por la derecha o izquierda
	public void Push() {
		P("Desea agregar por izquierda o derecha?");
		P("1. Derecha.");
		P("2. Izquierda.");
		
		String op = LeerS();
		
		switch(op) {
		case "1":
			PushD();
			break;
		case "2":
			PushI();
			break;
			default:
				P("Opcion no valida...");
				Push();
				break;
		}
	}
	
	//Para ingresar por la izquierda se ingresa desde indice 0, y envia un mensaje cuando se llena esa mitad
	public void PushI() {
		if(contadorI <= divisor) {
			finI++;
			
			P("Ingrese el elemento.");
			ColaDoble[finI] = LeerS();
			P("Elemento " + ColaDoble[finI] + " ha sido ingresado");
			contadorI++;
		} else {
			P("Cola izquierda llena...");
		}
	}
	
	//Se ingresa a partir de la mitad de la cola, y se envia un mensaje cuando esta llena esa mitad.
	public void PushD() {
		if(contadorD <= divisor) {
			finD--;
			
			P("Ingrese el elemento.");
			ColaDoble[finD] = LeerS();
			P("Elemento " + ColaDoble[finD] + " ha sido ingresado");
			contadorD++;
		} else {
			P("Cola derecha llena...");
		}
	}
	
	//Metodo de eleccion para elimnar por la derecha o izquierda
	public void Pop() {
		P("Desea Eliminar por izquierda o derecha?");
		P("1. Derecha.");
		P("2. Izquierda.");
		
		String op = LeerS();
		
		switch(op) {
		case "1":
			PopD();
			break;
		case "2":
			PopI();
			break;
			default:
				P("Opcion no valida...");
				Pop();
				break;
		}
	}
	
	//Para elimnar por la izquierda se evalua la primera mitad, desde el cero hasta la division
	public void PopI() {
		if(contadorI > 0) {
			
			P("Elemento " + ColaDoble[0] + " ha sido eliminado");
			for(int i = 0; i <= divisor - 1; i++) {
				ColaDoble[i] = ColaDoble[i + 1];
			}
			ColaDoble[divisor] = "0";
			
			finI--;
			contadorI--;
		} else {
			P("Cola izquierda vacia...");
		}
	}
	
	//Para elimnar por la derecha se evalua la segunda mitad, desde el divisor hasta el final
		public void PopD() {
			if(contadorD > 0) {
				P("Elemento " + ColaDoble[ColaDoble.length - 1] + " ha sido eliminado");
				for(int i = ColaDoble.length - 1; i > divisor + 1; i--) {
					ColaDoble[i] = ColaDoble[i - 1];
				}
				ColaDoble[divisor + 1] = "0";
				
				finD++;
				contadorD--;
			} else {
				P("Cola izquierda vacia...");
			}
		}
		
		//Elemento para ver los elementos de la cola doble
		public void Peek() {
			P("Elija las siguientes opciones");
			P("1. Ver elementos de la derecha.");
			P("2. Ver elementos de la izquierda.");
			P("3. Ver todos los elementos.");
			
			String op = LeerS();
			
			switch(op) {
			case "1": //Para la derecha mostramos desde uno despues del divisor hasta el final
				P("Elementos de la derecha, del primer ingresado al ultimo");
				for(int j = ColaDoble.length - 1; j > divisor; j-- ) {
					P(ColaDoble[j]);
				}
				break;
			case "2": //Para la izquierda mostramos desde el cero hasta el divisor
				P("Elementos de la izquierda, del primer ingresado al ultimo");
				for(int l = 0; l <= divisor; l++ ) {
					P(ColaDoble[l]);
				}
				break;
			case "3": //Mostramos los dos casos anteriores
				P("Elementos de la derecha, del primer ingresado al ultimo");
				for(int j = ColaDoble.length - 1; j > divisor; j-- ) {
					P(ColaDoble[j]);
				}
				P("Elementos de la izquierda, del primer ingresado al ultimo");
				for(int l = 0; l <= divisor; l++ ) {
					P(ColaDoble[l]);
				}
				break;
			default:
				P("Opcion no valida...");
				Peek();
				break;
			}
		}
	
	//Metodo auxiliar para leer enteros
	public int LeerI() {
		Scanner li = new Scanner(System.in);
		int l = li.nextInt();
		return l;
	}
	
	//Metodo auxiliar para leer cadenas
	public String LeerS() {
		Scanner ls = new Scanner(System.in);
		String l = ls.nextLine();
		return l;
	}

	//Metodo auxiliar para imprimir
	public void P(String mensaje) {
		System.out.println(mensaje);
	}
}