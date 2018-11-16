
import java.util.Scanner;
public class P20_ListasEnlazadasCirculares_Push {

	/**
	 * @param args
	 */
	//Declaramos los objetos pero no les asignamos ningun puntero a memoria
	public Nodo raiz;
	public Nodo p;
	public Nodo q;
	public Nodo aux;
	public int c;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Iniciamos con el creador de la lista, el cual crea la raiz de primera accion
		P20_ListasEnlazadasCirculares_Push le = new P20_ListasEnlazadasCirculares_Push();
		le.CrearLista();
	}
	
	public  void Menu(){//Este es el menu inicial, despliega todas las opciones que el usuario puede elegir
		Print("--------------------------------------------------------------------------------------------");
		Print("Ingrese la opcion que quiera realizar en la lista circular y cualquier otra cosa para salir.");
		Print("1. Crear nuevo nodo.");
		Print("2. Ver ultimo dato ingresado.");
		Scanner l = new Scanner(System.in);
		String opcion = l.nextLine();
		
		//Aqui se evalua la respuesta del usuario y se llama al indicado
		switch(opcion){
		case "1":
			CrearNodo();
			//Para crear la idea de la lista circular, se debe enlazar el ultimo nodo siempre con la raiz
			break;
		case "2":
			VerNext();
			Menu();
			break;
		default:
			Print("Saliendo del programa...");
			System.out.close();
			break;
		}
	}
	
	//Este metodo crea la raiz de primer tarea, asi como declara el contador general en cero, indicando que es la raiz
	public  void CrearLista(){
		Print("Ingrese el dato de la raiz");
		Scanner leer = new Scanner(System.in);
		String dato = leer.nextLine();
		raiz = new Nodo(dato);
		raiz.next = raiz;
		Print("Se creo el nodo raiz con dato: " + raiz.data);
		c = 0;
		q = raiz;
		p = raiz;
		Menu();
	}
	
	//Este es el metodo para crear nodos, se hace creando objetos de clases mas adelante explicadas
	public  void CrearNodo(){
		
		//En este if, si c == o esta en la raiz, por tanto se crea el siguiente nodo que se enlaza con dicha raiz
		if(c == 0){
			q = raiz;
			Print("Ingrese el dato del nodo.");
			Scanner l2 = new Scanner(System.in);
			String inf = l2.nextLine();
			p = new Nodo(inf);
			raiz.next = p;
		} else { //Mientras c es mayor a cero, ya no esta en la raiz y se usan la variables p y q para recorrer los nodos creando mas y enlazandolos
			q = p;
			Print("Ingrese el dato del nodo.");
			Scanner l3 = new Scanner(System.in);
			String info = l3.nextLine();
			p = new Nodo(info);
			q.next = p;
		}

		p.next = raiz;
		c++; //Se incrementa el contador con cada nodo creado y despues se despliega el dato del nodo con el indice correspondiente
		Print("Nodo: <" + p.data + "> ha sido creado con indice: " + c);
		Menu();
	}
	
	
	//Muestra el dato del nodo p, siendo p el ultimo nodo ingresado
	public void VerNext() {
		Print("Ultimo ingresado es: " + p.data);
	}
	

	//La clase nodo tienen los atributos de nodo y data, los cuales se piden solo la informacion en el constructor y el nodo cuando se enlaza con el siguiente
	public class Nodo{
		String data;
		Nodo next;
		public Nodo(String data){
			this.data = data;
		}
	}
	
	//Este metodo permite imprimer con menos letras y asi da menos flojera gg...
	public  void Print(String i){
		System.out.println(i);
	}

}