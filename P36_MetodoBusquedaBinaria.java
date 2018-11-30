import java.util.Scanner;

public class P36_MetodoBusquedaBinaria {

	public String[] Arreglo = new String[20];
	public int longitud = 20;
	public int iteracion = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P36_MetodoBusquedaBinaria MB = new P36_MetodoBusquedaBinaria();
		MB.CrearArreglo();
		MB.Busqueda();
	}
	
	//Metodo auxiliar para comenzar la busqueda
	public void Busqueda() {
		P("Ingresa el elemento a buscar.");
		String l = LeerS();
		Buscar(Arreglo, l);
	}
	
	/*
	 * Metodo de busqueda binaria, consiste en dividir el arreglo en dos partes, 
	 * buscas en la primera mitad, y si no se encuentra el elemento entonces divides la
	 * otra mitad en 2 de nuevo
	 */
	
	//El metodo usado es recursivo por lo que se puede dividir sin problema
		public void Buscar(String[] arr, String elemento) {
			/*
			 * La iteracion permite llevar un conteo de las particiones
			 * la variable x guarda la longitud mitad del arreglo y y la otra mitad.
			 * 
			 * Se cicla la primera mitad a fin de enontrar el elemento y se sabe que se encontro
			 * por una bandera que se volvera true
			 */
			iteracion++;
			int x = arr.length/2;
			int y = arr.length - x;
			boolean ban = false;
			for(int i = 0; i < x + 1; i++) {
				if(elemento.equals(arr[i])) {
					P("Elemento " + arr[i] + " encontrado, en la particion " + iteracion);
					ban = true;
					break;
				}
			}
			
			/*
			 * Si no se ha encontrado en esta primera busqueda y x aun no es cero, o sea, que aun se
			 * puede dividir el arreglo, entonces se vuelve a llamar el metodo esta vez con la mitad 
			 * que no ha sido evaluada.
			 */
			
			if(ban == false && x != 0) {
					String[] a = new String[y];
					int z = -1;
					for(int j = x; j < arr.length; j++) { 
						//Aqui se guardan los datos faltantes en el aarreglo que se enviara como parametro
						z++;
						a[z] = arr[j];
					}
					Buscar(a, elemento); //Se llama al metodo de nuevo pasando nuevo arreglo
			} 
			
			//Si ya no se puede seguir dividiento el arreglo y la bandera no ha cambiado, o sea, que
			// no se han encontrado coincidecias se mandaun mensaje diciendo que no se encontro ele elemento.
			if(x == 0 && ban == false) {
				P("Elemento " + elemento + " no encontrado.");
			}
		}
		
		//Método para crear el arreglo
		public void CrearArreglo() {
			P("Ingresa los 20 datos del arreglo, dando un enter entra cada uno.");
			for(int i = 0; i < 20; i++) {
				Arreglo[i] = LeerS();
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
