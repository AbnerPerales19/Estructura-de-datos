import java.util.Scanner;


public class P30_ArbolesBalanceados {

	//Variables que se utilizaran en todo el programa
	Nodo raiz;
	Nodo p;
	Nodo q;
	int niveles = -1;
	int peso = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P30_ArbolesBalanceados AB = new P30_ArbolesBalanceados();
		AB.CrearArbol();
		AB.Menu();
	}
	
	//Se crea el nodo raiz, garantizando que el arbol existe
	public void CrearArbol() {
		P("Ingrese el dato que tendra la raiz.");
		int dat = LeerI();
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
		P("3. Recorrido preorden");
		P("4. Recorrido postorden");
		
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
		case "3":
			Preorden(raiz);
			Menu();
			break;
		case "4":
			Postorden(raiz);
			Menu();
			break;
			default:
				P("Saliendo del programa.");
				System.out.close();
				break;
		}
	}
	
	//Recorrido postorden
	public void Postorden(Nodo nodo) {
		if(nodo == null) {
			return; //si no existe dicho nodo entonces termina el metodo y regresa a la sentencia anterior
		} else {
			Postorden(nodo.left); //recorrer subarbol izquierdo
			Postorden(nodo.right); //Recorrer subarbol derecho
			P(nodo.numero + "");			//Mostrar raiz
		}
	}
	
	//Recorrido inorden
	public void Inorden(Nodo nodo) {
		if(nodo == null) { //Si esta vacio el nodo, entonces nos regresamos a la sentencia anterior
			return;
		} else {
			//Si hay algo en el nodo se ejecutan la siguientes sentencias
			Inorden(nodo.left);		//Se vuelve a ejecutar el metodo para irse lo mas a la izquierda posible
			P(nodo.numero + "");			//Si ya estamos a la izquierda, ahora se imprime ese nodo
			Inorden(nodo.right);	//Ahora se ejecuta el metodo pero con el nodo derecho
		}
		
		/*
		 * Al hacer esto recurivo, permite "dejar" un puntero en cada nodo, pues este se ejecuta una y otra vez
		 * pero queda pendiente por evaluar el nodo anterior, y cuando evaluo el ultimo nodo, se regresa a evaluar
		 * uno por uno los nodos que quedaron pendientes
		 */
	}
	
	//Recorrido preorden
	public void Preorden(Nodo nodo) {
		if(nodo == null) { //Si el nodo no existe entonces se regresa
			return;
		} else {
			/*
			 * Lo que hace es primero imprimir la raiz, luego el nodo izquiero y al final el derecho
			 * 
			 * Que sea recursivo permite irse hasta el ultimo nodo, y regresarse uno por uno evaluando  
			 * raiz, luego izquierda y al final derecha
			 */
			P(nodo.numero + "");
			Preorden(nodo.left);
			Preorden(nodo.right);
		}
	}
	
	//Metodo para crear un nodo, para entender mejor el codigo y no enredarme, dividi este codigo en 3 metodos
	//Este metodo hace las condiciones iniciales
	public void CrearNodos() {
		
		P("Nodo condicion: " + raiz.numero);
		P("Ingrese <salir> para regresar a menu principal, o presione enter para continuar.");
		String z = LeerS();
		if(z.equals("salir")) {
			P("Regresando a menu principal.");
			Menu();
		}
		P("Ingrese el número.");
		int y = LeerI();
		Condicion(raiz, y);
	}
	

	//Este es el metodo recursivo que permite aplicar la condicion en cada nodo
	//Permite agregar a derecha si son mayores al padre y a la izquierda si son menores.
	public void Condicion(Nodo nodo, int y) {
		
		if(y >= nodo.numero) { //Mientras el valor sea mayor igual al padre
			if(nodo.right == null) { //si no existe nada a la derecha, se crea
				niveles = nodo.nivel + 1;
				p = new Nodo(y, niveles);
				nodo.right = p;
				p.padre = nodo;
				peso++;
				P("Nodo " + p.numero + " ha sido ingresado.");
				CrearNodos();
			} else {  //Si ya hay un nodo ahi, se vuelve a preguntar esta vez en el nodo
				Condicion(nodo.right, y);
			}
				
			//Derecha();
		} else {
			if(nodo.left == null) { //si no existe nada a la izquierda, se crea
				niveles = nodo.nivel + 1;
				p = new Nodo(y, niveles);
				nodo.left = p;
				p.padre = nodo;
				peso++;
				P("Nodo " + p.numero + " ha sido ingresado.");
				CrearNodos();
			} else {//Si ya hay un nodo ahi, se vuelve a preguntar esta vez en el nodo
				Condicion(nodo.left, y);
			}
		
			//Izquierda();
		}
	}
	
	
	//Clase nodo, esta nos permite crear nodos solo creando una instancia de esta clase
	public class Nodo {
		Nodo padre = null;
		Nodo right = null;
		Nodo left = null;
		int nivel;
		int numero;
		public Nodo(int numero, int nivel) {
			this.numero = numero;
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