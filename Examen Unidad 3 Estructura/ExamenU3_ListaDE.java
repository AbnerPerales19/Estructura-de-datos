import java.util.Scanner;



public class ExamenU3_ListaDE {
	
	public Nodo raiz;
	public Nodo p;
	public Nodo q;
	public int contador;
	public boolean m = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExamenU3_ListaDE E3 = new ExamenU3_ListaDE();
		E3.Instrucciones();
	}
	
	public void Instrucciones() {
		CrearLista();
		P("--------------------------------------------------------------");
		P("\nLeer la raiz de izquierda a derecha...............");
		VerNodosIaD();
		P("\nLeer la raiz de derecha a izquierda...............");
		VerNodosDaI();
		P("\nInsertar: 10, 11, 13...............");
		CrearNodo("10");
		CrearNodo("11");
		CrearNodo("13");
		P("\nEliminar: 8, 1...............");
		Pop("8");
		Pop("1");
		P("\nLeer Raiz...............");
		VerRaiz();
		P("\nLeer Final de la lista lado derecha y lado izquierdo...............");
		P("Final de la lista lado derecho");
		P(p.data);
		P("Final de la lista lado izquierdo");
		P(raiz.data);
		P("\nBuscar: 0, 7, 8, 1...............");
		Peek("0");
		Peek("7");
		Peek("8");
		Peek("1");
		P("\nFin...............");
	}
	
	//Busca un dato especifico y despliega el mensaje del metodo buscardato cuando no hay y despliega el dato cuando si
	public void Peek(String x) {
		Nodo l = BuscarDato(x);
		
		if(m == true) {
			P(l.data);
		}
	}
	
	//Este metodo crea la raiz de primer tarea, asi como declara el contador general en cero, indicando que es la raiz
		public  void CrearLista(){
			raiz = new Nodo("1");
			P("Se creo el nodo raiz con dato: " + raiz.data);
			contador = 0;
			q = raiz; //En dado caso que quieran ver los nodos, no deben estar null para no crear error. por eso igual a la raiz
			p = raiz;
			
			for(int i = 2; i <= 9; i++) {
				CrearNodo("" + i);
			}
		}
		
		
		//Este es el metodo para crear nodos, se hace creando objetos de clases mas adelante explicadas
		public  void CrearNodo(String d){
			
			//En este if, si contador == o esta en la raiz, por tanto se crea el siguiente nodo que se enlaza con dicha raiz
			if(contador == 0){
				String inf = d;
				p = new Nodo(inf);
				raiz.next = p;
				p.previous = raiz;
			} else { //Mientras c es mayor a cero, ya no esta en la raiz y se usan la variables p y q para recorrer los nodos creando mas y enlazandolos
				q = p;
				String info = d;
				p = new Nodo(info);
				q.next = p;
				p.previous = q;
			}
			contador++; //Se incrementa el contador con cada nodo creado y despues se despliega el dato del nodo con el indice correspondiente
			P("Nodo: <" + p.data + "> ha sido creado ");
		}
		
		public void Pop(String e) {
			Nodo nodo = BuscarDato(e);
			
			if(m == true) { //Si hay un nodo con esa caracteristica
				
				if(nodo == raiz) {
					q = raiz;
					raiz = q.next;
				} else {
					q = nodo.previous;
					q.next = nodo.next;
				}
				
				
				P("Se ha eliminado nodo con dato " + nodo.data);
				contador--;
				//Los nodos que quedan en el limbo son eliminados por el recolector de basura
				q = null;
				nodo = null; 
				//El recolector de basura de java se encarga de eliminar todos los objetos que no estan senalados con algun puntero, de igual forma lo vuelvo null aunque el GC lo borrara
			} else {
				P("No existe ese nodo.");
			}
		}
		
		//Cuando buscas el nodo por el dato se pide por parametro y se incia la comparacion
		public Nodo BuscarDato(String yy) {
			m = false;
			q = raiz.next;
			if(yy.equals(raiz.data)) { //Si el dato es igual a la raiz la devuelve
				m = true;
				return raiz;
			} else {
				for(int d = 1; d <= contador; d++) { //si no es igual a la raiz entonces se busca entre los nodos y se regresa el nodo
					if(yy.equals(q.data) && m == false) {
						m = true;
						break;
					}
					
					q = q.next;
					if(d == contador && m == false) { //Si no existe ningun dato con ese criterio se despliega el mensaje.
						P("No se encontro ningun dato con el criterio.");
					}
				}
				return q;
			}
		}
		
		//Para ver todos los nodos se imprime primero la raiz y se usa un for para recorrer todos los demas nodos de izquierda a derecha
		public void VerNodosIaD() {
			P("Nodo 0: " + raiz.data);
			q = raiz.next;
			for(int a = 1; a <= contador; a++) { //Una vez desplegada la raiz, cosa que siempre hara se hace este for
				//Este imprime el dato del siguiente nodo a la raiz si es que existiera y luego avanza al siguiente nodo al mismo tiempo que se incrementa el contador
				P("Nodo " + a + ": " + q.data);
				q = q.next;
			}
		}
		
		//Para ver todos los nodos se imprime primero la raiz y se usa un for para recorrer todos los demas nodos de derecha a izquierda
		public void VerNodosDaI() {
			q = p;
			for(int b = contador; b >= 0; b--) { //Una vez desplegada la raiz, cosa que siempre hara se hace este for
				//Este imprime el dato del ultimo nodo hacia la raiz
				P("Nodo " + b + ": " + q.data);
				q = q.previous;
			}
		}
		
		public void VerRaiz() {
			P("Raiz: " + raiz.data);
		}

	//clase nodo
	public class Nodo {
		Nodo next;
		Nodo previous;
		String data;
		int c;
		
		public Nodo(String data) {
			this.data = data;
		}
	}
	
//	//Clase raiz, derivada de clase Nodo
//	public class Raiz extends Nodo{
//		Nodo next;
//		Nodo previous;
//		String data;
//		int c;
//		
//		public Raiz(String data) {
//			super(data);
//			this.data = data;
//		}
//	}
	
	//Metodos auxiliares de lectura e impresion
	//Mostrar mensaje
	public void P(String mensaje) {
		System.out.println(mensaje);
	}
	
	//Leer cadenas
	public String LeerS() {
		Scanner LS = new Scanner(System.in);
		String s = LS.nextLine();
		return s;
	}
	
	//Leer enteros
	public int LeerI() {
		Scanner LI = new Scanner(System.in);
		int i = LI.nextInt();
		return i;
	}

}
