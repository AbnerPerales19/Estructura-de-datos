package practicas;

import java.util.Scanner;

public class PracticaFibonacci {

	public static void main(String[] args) {
		System.out.println("Programa para calcular fibonacci."); //Modulo principal, llama al menu
		Menu();
	}
	
	public static void Menu() { //Este menu pregunta que accion se realizara al usuario
		Scanner l = new Scanner(System.in); //Objetos para leer datos ingresados por el usario
		Scanner l2 = new Scanner(System.in);
		
		System.out.println("Ingrese el numero: "); //Mensajes del menu
		int n = l.nextInt();
		System.out.println("____________________________________________________________________________________");
		System.out.println("Elija el metodo ingresando el numero de la opcion, y cualquier otro valor para salir");
		System.out.println("1. Metodo de iteracion");
		System.out.println("2. Metodo de recursividad");
		String opcion = l2.nextLine();
		
		switch(opcion) { //Se evalua la opcion del usuario y en base a esto se ejecuta un metodo
		case "1":
			System.out.println("fibonacci de " + n + " = " + Iteracion(n));
			Menu();
			break;
		case "2":
			int contador = 0;
			System.out.print("fibonacci de " + n + " = ");
			Recursividad(n, 0, 0, 0, contador);
			Menu();
			break;
		default:
			System.out.close();
			break;
		}
	}
	
	public static int Iteracion(int n) { //Si el usuario escoje iteraciones, de ejecuta este metodo que utiliza un for para realizar la operacion
		int f = 0;
		int fa = 0;
		int faa = 0;
		
		for(int i = 0; i <= n; i++) {
			faa = fa;
			fa = f;
			f = fa + faa;
			
			
			if(f == 0 && i == 1) {
				f = 1;
			}
			
		}
		return f;
	}
	
	public static void Recursividad(int n, int faa, int fa, int f, int contador) {
		//En caso de usar recursividad se ejecuta este metodo una y otra vez con nuevos parametros y valores hasta que se obtenga el valor deseado, entonce se despliega
		if(contador <= n) {
			faa = fa;
			fa = f;
			f = faa + fa;
			
			if(contador == 1) {
				f = 1;

				contador++;
				Recursividad(n, faa, fa, 1, contador);
			} else {

				contador++;
				Recursividad(n, faa, fa, f, contador);
			}
			
		}
		else {
			System.out.println(f);
		}
		
	}

}
