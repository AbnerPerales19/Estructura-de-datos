package Practicas;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioExamen3 {
	
	public static ArrayList<String> versiones = new ArrayList<String>(); //Lista de elementos, contendra la versiones
	public static int contador = 0;

	public static void main(String[] args) {
		System.out.println("*** Examen Unidad 2, Estructura de Datos, Ejercicio 3, Perales Niebla Abner Jesus *** \n");
		
		System.out.println("Programa para control de versiones");
		Menu();
	}
	
	public static void Menu() { //Menu de opciones
		System.out.println("----------------------------------------------------------------");
		System.out.println("Ingrese el numero de la opcion o cualquier otra cosa para salir.");
		System.out.println("1. Agregar una version.");
		System.out.println("2. Sacar la ultima version agregada.");
		System.out.println("3. Ver todas la versiones.");
		
		Scanner leer = new Scanner(System.in);
		String opc = leer.nextLine();
		
		switch(opc) { //Se evalua las opcion del usuario y se llama al repectivo metodo
		case "1":
			Agregar();
			break;
		case "2":
			Sacar();
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
	
	public static void Agregar() { //En este se agrega una nueva version
		System.out.println("Ingrese la version: ");
		Scanner l = new Scanner(System.in);
		String elemento = l.nextLine();
		versiones.add(elemento);
		System.out.println("Se agrego la version " + elemento + " con el indice " + contador);
		contador++; //El contador equivale al siguiente indice a guardar
		Menu();
	}
	
	public static void Sacar() { //Se elimina una version, la ultima ingresada
		if(contador == 0) {
			System.out.println("No hay ninguna version guardada.");
		} else {
			String eliminado = versiones.remove(contador - 1);
			System.out.println("Version " + eliminado + " ha sido removida");
			contador--;
		}
		Menu();
	}
	
	public static void Ver() { //Pueden verse todas las versiones del proyecto
		System.out.println("Lista de versiones empezando en posicion 0 ");
		
		for(String i: versiones) {
			System.out.println(i);
		}
		
		Menu();
	}

}
