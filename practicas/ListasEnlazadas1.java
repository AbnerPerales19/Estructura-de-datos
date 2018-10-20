
import java.util.Scanner;
public class ListasEnlazadas1 {

	/**
	 * @param args
	 */
	//Declaramos los objetos pero no les asignamos ningun puntero a memoria
	public Raiz raiz;
	public Nodo p;
	public Nodo q;
	public int c;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Iniciamos con el creador de la lista, el cual crea la raiz de primera accion
		ListasEnlazadas1 le = new ListasEnlazadas1();
		le.CrearLista();
	}
	
	public  void Menu(){//Este es el menu inicial, despliega todas las opciones que el usuario puede elegir
		Print("Ingrese la opcion que quiera realizar y cualquier otra cosa para salir.");
		Print("1. Crear nuevo nodo.");
		Print("2. Eliminar Nodo.");
		Print("3. Ver la raiz.");
		Print("4. Ver todos los nodos");
		Print("5. Ver dato de algun nodo");
		Scanner l = new Scanner(System.in);
		String opcion = l.nextLine();
		
		//Aqui se evalua la respuesta del usuario y se llama al indicado
		switch(opcion){
		case "1":
			CrearNodo();
			break;
		case "2":
			Print("En construccion");
			break;
		case "3":
			Print("En construccion");
			break;
		case "4":
			Print("En construccion");
			break;
		case "5":
			Print("En construccion");
			break;
		default:
			Print("Saliendo del programa...");
			System.out.close();
			break;
		}
		Menu();
	}
	
	//Este metodo crea la raiz de primer tarea, asi como declara el contador general en cero, indicando que es la raiz
	public  void CrearLista(){
		Print("Ingrese el dato de la raiz");
		Scanner leer = new Scanner(System.in);
		String dato = leer.nextLine();
		raiz = new Raiz(dato);
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

		c++; //Se incrementa el contador con cada nodo creado y despues se despliega el dato del nodo con el indice correspondiente
		Print("Nodo: <" + p.data + "> ha sido creado con indice: " + c);
		Menu();
	}
	
	
	//Clase Raiz, es derivada de Nodo, de esta forma evitamos que ocurra algun error a la hora de tomar el valor una de otra 
	public class Raiz extends Nodo{
		String data;
		Nodo next;
		public Raiz(String data){ //Su constructor pide de primer dato la informacion
			super(data);
			this.data = data;
		}
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
