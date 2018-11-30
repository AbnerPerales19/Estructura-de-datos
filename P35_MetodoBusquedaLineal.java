import java.util.Scanner;

public class P35_MetodoBusquedaLineal {

	public String[] arreglo = new String[20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P35_MetodoBusquedaLineal MB = new P35_MetodoBusquedaLineal();
		MB.CrearArreglo();
		MB.Buscar();
	}
	
	//Metodo de busqueda lineal, literalmente compara el elemento con todos hasta encontrar el indicado
	public void Buscar() {
		P("Ingresa el elemento a buscar.");
		String elemento = LeerS();
		//Compara individualmente los elementos
		for(int i = 0; i < 20; i++) {
			if(elemento.equals(arreglo[i])) {
				P("Elemento " + elemento + " encontrado, con indice " + i);
				break;
			}
		}
	}
	
	//Método para crear el arreglo
	public void CrearArreglo() {
		P("Ingresa los 20 datos del arreglo, dando un enter entra cada uno.");
		for(int i = 0; i < 20; i++) {
			arreglo[i] = LeerS();
		}
	}
	
	//Metodo auxiliar para leer cadenas
	public String LeerS(){
		Scanner ls = new Scanner(System.in);
		String l = ls.nextLine();
		return l;
	}
		
	//Metodo auxiliar de impresion
	public void P(String mensaje) {
		System.out.println(mensaje);
	}
}
