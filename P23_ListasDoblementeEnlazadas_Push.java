
import java.util.Scanner;
public class P23_ListasDoblementeEnlazadas_Push {

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
		P23_ListasDoblementeEnlazadas_Push le = new P23_ListasDoblementeEnlazadas_Push();
		le.CrearLista();
	}
	
	public  void Menu(){//Este es el menu inicial, despliega todas las opciones que el usuario puede elegir
		Print("-----------------------------------------------------------------------");
		Print("Ingrese la opcion que quiera realizar y cualquier otra cosa para salir.");
		Print("1. Crear nuevo nodo.");
		Print("2. Ver todos los nodos en retroceso.");
		Scanner l = new Scanner(System.in);
		String opcion = l.nextLine();
		
		//Aqui se evalua la respuesta del usuario y se llama al indicado
		switch(opcion){
		case "1":
			CrearNodo();
			break;
		case "2":
			Retroceso(); //Se muestran los nodos del final al inicio
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
		raiz.previous = raiz;
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
			p.previous = raiz;
			raiz.next = p;
		} else { //Mientras c es mayor a cero, ya no esta en la raiz y se usan la variables p y q para recorrer los nodos creando mas y enlazandolos
			q = p;
			Print("Ingrese el dato del nodo.");
			Scanner l3 = new Scanner(System.in);
			String info = l3.nextLine();
			p = new Nodo(info);
			q.next = p;
			p.previous = q;
		}

		c++; //Se incrementa el contador con cada nodo creado y despues se despliega el dato del nodo con el indice correspondiente
		Print("Nodo: <" + p.data + "> ha sido creado con indice: " + c);
		Menu();
	}

	//Para ver todos los nodos se imprime primero la raiz y se usa un for para recorrer todos los demas nodos
	public void Retroceso() {
		
		q = p;
		
		for(int a = 0; a <= c; a++) { //Una vez desplegada la raiz, cosa que siempre hara se hace este for
			//Este imprime el dato del siguiente nodo a la raiz si es que existiera y luego avanza al siguiente nodo al mismo tiempo que se incrementa el contador
			Print(q.data);
			q = q.previous;
		}
		Menu();
	}	


	
	//La clase nodo tienen los atributos de nodo y data, los cuales se piden solo la informacion en el constructor y el nodo cuando se enlaza con el siguiente
	public class Nodo{
		String data;
		Nodo next;
		Nodo previous;
		public Nodo(String data){
			this.data = data;
		}
	}
	
	//Este metodo permite imprimer con menos letras y asi da menos flojera gg...
	public  void Print(String i){
		System.out.println(i);
	}

}