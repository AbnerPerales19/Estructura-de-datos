package practicas;

import java.util.Scanner;

public class MenuPracticas {

	public static void main(String[] args) { //Modulo principal
		System.out.println("Menu de practicas: Numeros naturales, factorial, fibonacci");
		MenuClases();
	}
	
	public static void MenuClases() { //Este es el menu de las practicas, en este el usuario elije que programa desea ejecutar
		Scanner l2 = new Scanner(System.in);
		System.out.println("____________________________________________________________________________________");
		System.out.println("Elija el programa que desea, cualquier otro caracter para salir");
		System.out.println("1. Primeros 100 numeros naturales");
		System.out.println("2. Factorial");
		System.out.println("3. Fibonacci");
		String opcion = l2.nextLine();
		
		switch(opcion) {//Aqui se crea un objeto de clase que la persona eligio, y se ejecuta su metodo principal
		case "1":
			MenuPracticas.PracticaNumerosNaturales PNN = new MenuPracticas.PracticaNumerosNaturales();
			PNN.Mostrar(1);
			break;
		case "2":
			MenuPracticas.PracticaFactorial PFa = new MenuPracticas.PracticaFactorial();
			PFa.Menu();
			break;
		case "3":
			MenuPracticas.PracticaFibonacci PFi = new MenuPracticas.PracticaFibonacci();
			PFi.Menu();
			break;
		default:
			System.out.close();
			break;
		}
	}

	public static class PracticaFibonacci { //Esta es la clase del fibonacci
		//Tiene un menu para que el usuario elija la opcion deseada
		public  void Menu() {
			Scanner l = new Scanner(System.in);
			Scanner l2 = new Scanner(System.in);
			
			System.out.println("Ingrese el numero: ");
			int n = l.nextInt();
			System.out.println("____________________________________________________________________________________");
			System.out.println("Elija el metodo ingresando el numero de la opcion, y cualquier otro valor para volver a menu principal");
			System.out.println("1. Metodo de iteracion");
			System.out.println("2. Metodo de recursividad");
			String opcion = l2.nextLine();
			
			switch(opcion) { //Se elije la opcion y ejecuta el metodo corresondiente
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
				MenuClases();
				break;
			}
		}
		
		public  int Iteracion(int n) { //Se ejecuta el metodo de iteracion implementando un for
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
		
		public  void Recursividad(int n, int faa, int fa, int f, int contador) {
			//Cuando se elije utilizar recursividad este metodo se itera a si mismo una y otra vez con nuevos parametros hasta que cumpla cierta condicion
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

	public static class PracticaFactorial { //Cuando se elije factorial se crea un objeto de esta clase

		public  void Menu() { //Se ejecuta el menu de este subprograma
			Scanner l = new Scanner(System.in);
			Scanner l2 = new Scanner(System.in);
			
			System.out.println("Ingrese el numero: ");
			int n = l.nextInt();
			System.out.println("____________________________________________________________________________________");
			System.out.println("Elija el metodo ingresando el numero de la opcion, y cualquier otro valor para volver a menu principal");
			System.out.println("1. Metodo de iteracion");
			System.out.println("2. Metodo de recursividad");
			String opcion = l2.nextLine();
			
			switch(opcion) { //Se evalua la respuesta del usuario y se ejecuta el metodo o funcion adecuada segun la opcion elejida
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
				MenuClases();
				break;
			}
		}
		
		public  int Iteracion(int n) { //Cuando es por iteracion entonces se ejecuta una funcion con un for que obtiene el reultado y lo regresa
			int factorial = 1;
			for(int i = 1; i <= n; i++) {
				factorial = factorial*i;
			}
			return factorial;
		}
		
		public  void Recursividad(int n, int factorial, int contador) {
			//Cuando se elige recursividad este metodo se ejecuta y se llama a si mismo hasta obtener el resultado
			if(contador <= n) {
				factorial = factorial*contador;
				contador++;
				Recursividad(n, factorial, contador);
			}else {
				System.out.println(factorial);
			}
			
		}

	}

	public static class PracticaNumerosNaturales {
		//Cuando se elige esta opcion se crea un objeto de la clase y se ejecuta el metodo mostrar
		public  void Mostrar(int numero) { //Se itera llamandose a si mismo con nuevos parametros hasta que se cumpla la condicion
			
			if(numero <= 100) {
				System.out.println(numero);
				Mostrar(numero + 1);
			} else {
				System.out.println("Programa terminado...Regresando a menu principal...");
				MenuClases();
			}
			
		}

	}
}


