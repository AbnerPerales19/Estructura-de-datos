package practicas;

public class PracticaNumerosNaturales {
	
	

	public static void main(String[] args) { //Metodo principal, inicializa el metodo mostrar en 1
		System.out.println("Desplegar los primeros 100 numeros naturales: ");
		Mostrar(1);
	}
	
	public static void Mostrar(int numero) { //Metodo mostrar, , recibe un numero como parametro
		
		if(numero <= 100) { 			//Mientras el numero es menor o igual a 100 hace lo siguiente
			System.out.println(numero); //Primero despliega el numero que se ingreso
			Mostrar(numero + 1);        //Despues llama de nuevo al metodo con el numero que imprimio, mas 1
		} else {
			System.out.println("Programa terminado..."); //Si el numero recibido ya es 101 entonces el programa termina
			System.out.close();
		}
		
	}

}
