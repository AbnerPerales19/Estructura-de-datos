import java.util.Scanner;

public class P14_ColasDobles_Push {

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
		P14_ColasDobles_Push p14 = new P14_ColasDobles_Push();
		p14.P("Cola doble");
		p14.CrearCola();
	}
	
	//Metodo para crear la cola, pide la longitud y crea la cola
	public void CrearCola() {
		P("Ingrese la longitud de la cola derecha e izquierda.");
		longitud = LeerI();
		ColaDoble = new String[longitud*2];
		divisor = longitud - 1;
		frontI = 0;
		finD = -1;
		frontD = longitud;
		finD = longitud -1;
		
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
			//Pop();
			Menu();
			break;
		case "3":
			//Peek();
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
			
			contadorI++;
		} else {
			P("Cola izquierda llena...");
		}
	}
	
	//Se ingresa a partir de la mitad de la cola, y se envia un mensaje cuando esta llena esa mitad.
	public void PushD() {
		if(contadorD <= divisor) {
			finD++;
			
			P("Ingrese el elemento.");
			ColaDoble[finD] = LeerS();
			
			contadorD++;
		} else {
			P("Cola derecha llena...");
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
