import java.util.Scanner;

public class P5_Pilas_Push {

	//Variables globales, estas se pueden usar desde cualquier lugar del programa
	public String[] pila; //Esta es la pila, un areglo con comportamiento especifico
	public int contador;  //Esta variable lleva el conteo de los elementos en la pila, de cierta forma seria la cima de la pila
	public int longitud;  //Establece la longitud de la pila
	public int t;         //Variable leida para regresar una lectura
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P5_Pilas_Push p = new P5_Pilas_Push();
		p.CrearPila();
	}
	
	//Se crea la pila con la longitud dada por el usuario y se establece el contador a un valor, luego se llama al menu princpal
	public void CrearPila() {
		P("Ingrese la longitud de la pila.");		
		longitud = LeerInt();
		pila = new String[longitud];
		contador = -1;
		Menu();
	}
	
	//Menu principal que muestra las 3 operaciones basicas de la pila, asi como la opcion de salir
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
	
	//este es el metodo agregar, mientras contador sea menor  a longitud -1,o sea, mientras no este llena, agregara elementos a la pila 
	public void Agregar() {
		if(contador < longitud - 1) {
			P("Ingresa el elemento a la pila");
			contador++;
			pila[contador] = LeerString();
			P("Se ha agregado el elemento " + pila[contador] + " con indice " + contador);
		} else { //En caso de que este llena la pila simplemente despliega que ya esta llena
			P("La pila esta llena...");
		}
		
		//Indepentiendemente de si esta llena o no, al salir de la condicion regresa al menu principal
		Menu();
	}
	

	//Proximamente
	public void Eliminar() {
		
	}
	
	//Proximamente
	public void Ver() {
		
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
