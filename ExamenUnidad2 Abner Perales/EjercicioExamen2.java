package Practicas;
import java.util.Scanner;

public class EjercicioExamen2 {
	
	public static int potencia = 0;
	public static int contador = 0;
	
	public static void main(String[] args) {
		System.out.println("*** Examen Unidad 2, Estructura de Datos, Ejercicio 2, Perales Niebla Abner Jesus *** \n");

//Se ingresa el grado de la potencia dada por el usuario
		System.out.println("Programa para elevar el dos a cualquier potencia");
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese la potencia del numero");
		potencia = leer.nextInt();
		
		Elevar(1); //llama al metodo Elevar con el parametro de 1
	}
	
	public static void Elevar(int n) {
		if(contador <= potencia) { //Mientras no se llegue  a potencia dada
			if(contador == 0) { 
				n = 1;
			} else { //Se seguira multiplicando por 2, para dar la idea de la potencia
				n = 2*n;
			}
			contador++;
			Elevar(n);
		} else { //Cuando la potencia ya fue alcanzada, entonces se despliega el resultado
			System.out.println("El resultado de elevar 2 a la potencia " + potencia + " es: " + n);
			System.out.println("Programa terminado...");
			System.out.close();
			}
	}
	
}
