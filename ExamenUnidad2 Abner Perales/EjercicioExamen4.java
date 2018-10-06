package Practicas;

import java.util.Scanner;

public class EjercicioExamen4 {
	
	public static String[] fila = new String[5]; //esta estructura representa la fila de clientes
	public static int contador = 0; //lleva el control de la cantidad de elementos en la fila

	public static void main(String[] args) {
		for(int a = 0; a < 5; a++) { //Asigna los valores de toda a fila a espacios vacios
			fila[a] = "Espacio en fila";
		}
		Menu(); //Llama al menu
	}
	
	public static void Menu() { //Aqui el usuario elije las opciones a tomar
		System.out.println("----------------------------------------------------------------");
		System.out.println("Ingrese el numero de la opcion o cualquier otra cosa para salir.");
		System.out.println("1. Entrar en la fila.");
		System.out.println("2. Atender a un cliente.");
		System.out.println("3. Ver si hay espacio en la fila.");
		
		Scanner leer = new Scanner(System.in);
		String opc = leer.nextLine();
		
		switch(opc) { //Aqui se llama al metodo correcto segun la respuesta del usuario
		case "1":
			Entrar();
			break;
		case "2":
			Atender();
			break;
		case "3":
			Ver();
			break;
		default:
			System.out.println("Saliendo del programa.");
			System.out.close();
		break;
		}
	}
	
	public static void Entrar() { //Aqui se ingresan personas a la fila
		
		if(contador < 5) { //pasa cuando hay espacios en la fila
			Scanner l = new Scanner(System.in);
			
			System.out.println("Nombre de la persona en la fila: ");
			String persona = l.nextLine();
			fila[contador] = persona;
			contador++; //Contador esta en el proximo elemento que puede ingresar
		} else {//Cuando ya no hay espacios se muestra en mensaje
			System.out.println("La fila esta llena.");
		}
		Menu(); //Se regresa a menu
	}
	
	public static void Atender() {//Se atienden a clientes y estos salen de la fila
		if(contador == 0) {//Cuando no hay clientes 
			System.out.println("No hay ningun cliente formado.");
		} else { //Cuando hay clientes pasa el siguiente y todos se recorren
			System.out.println(fila[0] + " ha sido atendido");
			for(int i = 0; i < 4; i++) {
				fila[i] = fila[i+1];
			}
			fila[4] = "0";
			
			contador--;
		}
		Menu(); //Regresa a menu
	}
	
	public static void Ver() { //Observar cuantos clientes hay en la fila
		System.out.println("Personas en la fila");
		
		for(String i: fila) {
			if(i.equals("0")) {
				System.out.println("Espacio en fila");
			} else {

				System.out.println(i);
				
			}
		}
		
		Menu(); //Regresar a menu
	}

}
