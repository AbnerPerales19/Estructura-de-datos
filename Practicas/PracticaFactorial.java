package practicas;
import java.util.Scanner;

public class PracticaFactorial {

	public static void main(String[] args) {
		System.out.println("Programa para calcular factoriale."); //Llama el menu principal
		Menu();
	}
	
	public static void Menu() {
		Scanner l = new Scanner(System.in); //objeto para leer los datos del usuario
		Scanner l2 = new Scanner(System.in);
		
		System.out.println("Ingrese el numero: "); //Opciones que tiene el usuario
		int n = l.nextInt();
		System.out.println("____________________________________________________________________________________");
		System.out.println("Elija el metodo ingresando el numero de la opcion, y cualquier otro valor para salir");
		System.out.println("1. Metodo de iteracion");
		System.out.println("2. Metodo de recursividad");
		String opcion = l2.nextLine();
		
		switch(opcion) { //Dependiendo de la opcion, se ejecuta cierto metodo
		case "1":
			System.out.println(n + "! = " + Iteracion(n));
			Menu();
			break;
		case "2":
			int contador = 1;
			System.out.print(n + "! = ");
			Recursividad(n, 1, contador);
			Menu();
			break;
		default:
			System.out.close();
			break;
		}
	}
	
	public static int Iteracion(int n) {//Cuando se elije por iteraciones entonces se ejecuta este metodo con un for
		int factorial = 1;
		for(int i = 1; i <= n; i++) {
			factorial = factorial*i;
		}
		return factorial;
	}
	
	public static void Recursividad(int n, int factorial, int contador) { 
		// Si elije recursividad entonces se ejecuta este metodo una y otra vez hasta llegar al valor deseado
		
		if(contador <= n) {
			factorial = factorial*contador;
			contador++;
			Recursividad(n, factorial, contador);
		}else {
			System.out.println(factorial);
		}
		
	}

}
