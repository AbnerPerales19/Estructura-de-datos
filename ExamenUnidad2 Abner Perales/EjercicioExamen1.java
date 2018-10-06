package Practicas;

public class EjercicioExamen1 {
	
	public static int contador = 1;

	public static void main(String[] args) {
		System.out.println("*** Examen Unidad 2, Estructura de Datos, Ejercicio 1, Perales Niebla Abner Jesus *** \n");
		
		//Se llama al metodo sumar con valor inicial de 0
		System.out.println("Programa para sumar los numeros del 1 al 9");
		Sumar(0);
	}
	
	public static void Sumar(int numero) {
		numero = contador + numero; //El resultado e igual a la anterior suma mas el nuevo numero
		contador++;
		
		if(contador >= 10) {//Cuando se hayan sumado todos los numeros se despliega el resultado
			System.out.println("Resultado de la suma: " + numero);
			System.out.println("Programa terminado...");
			System.out.close();
		} else { //Si aun no suman todos, entonces se vuelve a llamar al metodo
			Sumar(numero);
		}
	}

}
