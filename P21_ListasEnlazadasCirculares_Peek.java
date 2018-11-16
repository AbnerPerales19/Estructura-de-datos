
import java.util.Scanner;
public class P21_ListasEnlazadasCirculares_Peek {

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
		P21_ListasEnlazadasCirculares_Peek le = new P21_ListasEnlazadasCirculares_Peek();
		le.CrearLista();
	}
	
	public  void Menu(){//Este es el menu inicial, despliega todas las opciones que el usuario puede elegir
		Print("--------------------------------------------------------------------------------------------");
		Print("Ingrese la opcion que quiera realizar en la lista circular y cualquier otra cosa para salir.");
		Print("1. Crear nuevo nodo.");
		Print("2. Eliminar Nodo.");
		Print("3. Ver la raiz.");
		Print("4. Ver todos los nodos");
		Print("5. Ver dato de algun nodo");
		Print("6. Ver dato del next, del ultimo dato ingresado.");
		Scanner l = new Scanner(System.in);
		String opcion = l.nextLine();
		
		//Aqui se evalua la respuesta del usuario y se llama al indicado
		switch(opcion){
		case "1":
			CrearNodo();
			//Para crear la idea de la lista circular, se debe enlazar el ultimo nodo siempre con la raiz
			break;
		case "2":
			//EliminarNodo();
			Print("Por el momento no esta disponible, consulte el siguiente programa");
			Menu();
			break;
		case "3":
			VerRaiz();
			break;
		case "4":
			VerNodos();
			break;
		case "5":
			VerDato();
			break;
		case "6":
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
	
	
	//Muestra el siguiente nodo de p, siendo p el ultimo nodo ingresado
	public void VerNext() {
		Print("Comprobacion de la lista circular. Siguiente nodo al ultimo ingresado es: " + p.next.data);
	}
	
	//Aqui pueden ver la raiz con una impresion del dato de dicha raiz
	public  void VerRaiz(){
		Print("La raiz contiene indice 0, y su informacion es: || " + raiz.data + " ||");
		Menu();
	}
	
	//Para ver todos los nodos se imprime primero la raiz y se usa un for para recorrer todos los demas nodos
	public void VerNodos() {
		Print("Raiz: " + raiz.data);
		q = raiz.next;
		for(int a = 1; a <= c; a++) { //Una vez desplegada la raiz, cosa que siempre hara se hace este for
			//Este imprime el dato del siguiente nodo a la raiz si es que existiera y luego avanza al siguiente nodo al mismo tiempo que se incrementa el contador
			Print("Nodo " + a + ": " + q.data);
			q = q.next;
		}
		Menu();
	}
	
	//Para ver un nodo ya sea por indice o dato se llama a este metodo, el cual llama a los dos correspondientes
	public  void VerDato(){
		Print("Elija la opcion que desee y cualquier otra cosa para regresar al menu principal...");
		Print("1. Ver la posicion del nodo segun su informacion.");
		Print("2. Ver la informacion del nodo segun su posicion.");
		Scanner s = new Scanner(System.in);
		String n = s.nextLine();
		
		//Segun la evaluacion del uuario se llama al metodo correcto
		switch(n) {
		case "1":
			BuscarDato();
			break;
		case "2":
			BuscarIndice();
			break;
			default:
				Print("Regresando a menu principal...");
				Menu();
				break;
		}
		
		Menu();
	}
	
	//Primero se pide el indice  a buscar y se pone una excepcion en caso de algun error
	public void BuscarIndice() {
		Print("Ingrese el indice del nodo a buscar.");
		Scanner x = new Scanner(System.in);
		
		try { //Aqui se evalua el indice y se despliega la raiz en caso de ser indice igual a cero
			int xx = x.nextInt();
			q = raiz.next;
			if(xx == 0) {
				Print("Raiz: " + raiz.data);
			} else if(xx <= c && xx > 0) { //Si el indice es mayor a cero se evalua si existe dicho indice
				for(int z = 1; z <= xx; z++) { //Luego se busca mediante el recorrido de la lista
					
					if(z == xx) {
						Print("El nodo de indice " + xx + " tiene la siguiente informacion: " + q.data);
					}
					q = q.next;
				}
			} else {
				Print("indice no valido...");
			}
			
		} catch (NumberFormatException e) {
			Print("Valor ingresado no valido...");
			BuscarIndice();
		}
		
		//Cuando se produce un else o una excepcion simplemente se vuelve a llamar el metodo
		
		VerDato();
	}
	
	//Cuando buscas el nodo por el dato se pide el dato a el usuario llamando a este metodo
	public void BuscarDato() {
		Print("Ingrese el dato del nodo a buscar.");
		Scanner y = new Scanner(System.in);
		
		String yy = y.nextLine();
		q = raiz.next;
		if(yy.equals(raiz.data)) { //Si el dato es igual a la raiz se despliega el mensae
			Print("Raiz: " + raiz.data + " con indice 0");
		} else {
			boolean m = false;
			for(int d = 1; d <= c; d++) { //si no es igual a la raiz entonces se busca entre los nodos y se despliega el correcto
				if(yy.equals(q.data)) {
					Print("Nodo: " + q.data + " con indice " + d);
					m = true;
				}
				q = q.next;
				if(d == c && m == false) { //Si no existe ningun dato con ese criterio se despliega el mensaje.
					Print("No se encontro ningun dato con el criterio.");
				}
			}
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