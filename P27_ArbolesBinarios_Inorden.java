import java.util.Scanner;


public class P27_ArbolesBinarios_Inorden {

	//Variables que se utilizaran en todo el programa
	Nodo raiz;
	Nodo p;
	Nodo q;
	int niveles = -1;
	int peso = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P27_ArbolesBinarios_Inorden AB = new P27_ArbolesBinarios_Inorden();
		AB.CrearArbol();
		AB.Menu();
	}
	
	//Se crea el nodo raiz, garantizando que el arbol existe
	public void CrearArbol() {
		P("Ingrese el dato que tendra la raiz.");
		String dat = LeerS();
		niveles++;
		raiz = new Nodo(dat, niveles);
		p = raiz;
		q = raiz;
		peso++;
	}
	
	//Menu que te presenta las opciones a elegir para el arbol
	public void Menu() {
		P("-----------------------------------------------------");
		P("Ingrese la opcion deseada y cualquier otra para salir");
		P("1. Agregar nodos al arbol.");
		P("2. Recorrido inorden");
		
		String opc = LeerS();
		
		switch(opc) {
		case "1":
			P("******************************************************************************");
			P("Seleccione la opcion deseada y cualquier otra para regresar al menu principal.");
			P("Si ingresas un nodo te posicionara en la raiz despues de ingresar.");
			P("");
			q = raiz;
			CrearNodos();
			break;
		case "2":
			Inorden(raiz);
			Menu();
			break;
			default:
				P("Saliendo del programa.");
				System.out.close();
				break;
		}
	}
	
	//Recorrido inorden
	public void Inorden(Nodo nodo) {
		if(nodo == null) { //Si esta vacio el nodo, entonces nos regresamos a la sentencia anterior
			return;
		} else {
			//Si hay algo en el nodo se ejecutan la siguientes sentencias
			Inorden(nodo.left);		//Se vuelve a ejecutar el metodo para irse lo mas a la izquierda posible
			P(nodo.dato);			//Si ya estamos a la izquierda, ahora se imprime ese nodo
			Inorden(nodo.right);	//Ahora se ejecuta el metodo pero con el nodo derecho
		}
		
		/*
		 * Al hacer esto recurivo, permite "dejar" un puntero en cada nodo, pues este se ejecuta una y otra vez
		 * pero queda pendiente por evaluar el nodo anterior, y cuando evaluo el ultimo nodo, se regresa a evaluar
		 * uno por uno los nodos que quedaron pendientes
		 */
	}
	
	//Metodo para crear un nodo, para entender mejor el codigo y no enredarme, dividi este codigo en 3 metodos
	//Este metodo hace las condiciones iniciales
	public void CrearNodos() {
		
		P("Nodo actual: " + q.dato);
		P("1. Agregar un nodo a la derecha.");
		P("2. Agregar un nodo a la izquierda.");
		
		String op = LeerS();
		
		switch(op) {
		case "1":
			CrearDerecha();
			CrearNodos();
			break;
		case "2":
			CrearIzquierda();
			CrearNodos();
			break;
			default:
				P("Regresando a menu principal...");
				Menu();
				break;
		}
	}
	
	//Crear por derecha, realmente pude haber hecho todo en un mismo metodo, o que reciba un boolean de parametro 
	//Para diferenciar de derecha o izquierdo, pero entre menos condiciones tenga juntas, mas entendible
	public void CrearDerecha() {
		if(q.right == null) {
			P("Ingese el elemento.");
			String x = LeerS();
			niveles = q.nivel + 1;
			p = new Nodo(x, niveles);
			q.right = p;
			p.padre = q;
			peso++;
			q = raiz;
			P("Nodo " + p.dato + " ha sido agregado al arbol");
		} else {

			P("Nodo ocupado por <<" + q.dato + ">>, se avanza al siguiente nodo");
			q = q.right;
		}
	}
	
	/*
	 * Aqui se crean los nodos izquierdos, bueno, se avanza a la izquierda
	 * Es innecesario sacar el nivel, nisiquiera del arbol, pero lo puedo lograr con una variable global 
	 * que se compare con los niveles de los arboles y en base a eso tenga un nuevo valor 
	 */
	public void CrearIzquierda() {
		if(q.left == null) {
			P("Ingese el elemento.");
			String x = LeerS();
			niveles = q.nivel + 1;
			p = new Nodo(x, niveles);
			q.left = p;
			p.padre = q;
			peso++;
			q = raiz;
			P("Nodo " + p.dato + " ha sido agregado al arbol");
		} else {

			P("Nodo ocupado por <<" + q.dato + ">>, se avanza al siguiente nodo");
			q = q.left;
		}
	}
	
	
	//Clase nodo, esta nos permite crear nodos solo creando una instancia de esta clase
	public class Nodo {
		Nodo padre = null;
		Nodo right = null;
		Nodo left = null;
		int nivel;
		String dato;
		public Nodo(String dato, int nivel) {
			this.dato = dato;
			this.nivel = nivel;
		}
	}

	//Metodos auxiliares para leer e imprimir con menos lineas de codigo *******************************
	public String LeerS() {
		Scanner ls = new Scanner(System.in);
		String l = ls.nextLine();
		return l;
	}
	
	public int LeerI() {
		Scanner li = new Scanner(System.in);
		int l = li.nextInt();
		return l;
	}
	
	public void P(String mensaje) {
		System.out.println(mensaje);
	}
}
