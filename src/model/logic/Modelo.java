package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import model.data_structures.BinarySearchTree;
import model.data_structures.RedBlackTree;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	/**
	 * Datos
	 */
	private RedBlackTree <String, Accidente> datosRBT;
	
	private BinarySearchTree<String, Accidente> datosBST;

	/**
	 * Ruta de los datos
	 */
	private String ruta;

	/**
	 * Ruta del año 2016
	 */
	private static final String ruta2016 = "data/us_accidents_dis_2016.csv";

	/**
	 * Ruta del año 2017
	 */
	private static final String ruta2017 = "data/us_accidents_dis_2017.csv";

	/**
	 * Ruta del año 2018
	 */
	private static final String ruta2018 = "data/us_accidents_dis_2018.csv";

	/**
	 * Ruta del año 2019
	 */
	private static final String ruta2019 = "data/us_accidents_dis_2019.csv";

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datosRBT = new RedBlackTree<String, Accidente>();
		datosBST = new BinarySearchTree<String, Accidente>();
	}


	/**
	 * Req1: Conocer los accidentes en una fecha
	 */
	public void conocerAccidentesFechaRBT(String fecha)
	{	
		long tiempoI;
		long tiempoF;
		double tiempoT;

		
		
		int totalAccidentes = 0;
		int gradoUno = 0;
		int gradoDos = 0;
		int gradoTres = 0;
		int gradoCuatro = 0;
		
		tiempoI = System.nanoTime();
		for (Accidente actual : datosRBT.get(fecha)) {
			totalAccidentes++;
			if(actual.getSeverity().equals("1"))
				gradoUno++;
			else if(actual.getSeverity().equals("2"))
				gradoDos++;
			else if(actual.getSeverity().equals("3"))
				gradoTres++;
			else
				gradoCuatro++;
		}
		
		tiempoF = System.nanoTime();
		tiempoT = (double) (tiempoF-tiempoI)/1000000;
		
		System.out.println("El total de accidentes ocurridos el " + fecha + " es de:" + totalAccidentes);
		System.out.println("La cantidad de accidentes de severidad 1 es de: " + gradoUno);
		System.out.println("La cantidad de accidentes de severidad 2 es de: " + gradoDos);
		System.out.println("La cantidad de accidentes de severidad 3 es de: " + gradoTres);
		System.out.println("La cantidad de accidentes de severidad 4 es de: " + gradoCuatro);
		System.out.println("El tiempo de ejecucion fue de: " + tiempoT + " milisegundos" + "\n");

	}
	
	public void conocerAccidentesFechaBST(String fecha)
	{	
		long tiempoI;
		long tiempoF;
		double tiempoT;

		
		
		int totalAccidentes = 0;
		int gradoUno = 0;
		int gradoDos = 0;
		int gradoTres = 0;
		int gradoCuatro = 0;
		
		tiempoI = System.nanoTime();
		for (Accidente actual: datosBST.get(fecha)) {
			totalAccidentes++;
			if(actual.getSeverity().equals("1"))
				gradoUno++;
			else if(actual.getSeverity().equals("2"))
				gradoDos++;
			else if(actual.getSeverity().equals("3"))
				gradoTres++;
			else
				gradoCuatro++;
		}
		
		tiempoF = System.nanoTime();
		tiempoT = (double) (tiempoF-tiempoI)/1000000;
		
		System.out.println("El total de accidentes ocurridos el " + fecha + " es de:" + totalAccidentes);
		System.out.println("La cantidad de accidentes de severidad 1 es de: " + gradoUno);
		System.out.println("La cantidad de accidentes de severidad 2 es de: " + gradoDos);
		System.out.println("La cantidad de accidentes de severidad 3 es de: " + gradoTres);
		System.out.println("La cantidad de accidentes de severidad 4 es de: " + gradoCuatro);
		System.out.println("El tiempo de ejecucion fue de: " + tiempoT + " milisegundos" + "\n");

	}

	/**
	 * Importa, lee y guarda los datos necesarios
	 */
	public void leerDatos(String anno)
	{	
		if (anno.equals("2016")) { ruta = ruta2016; }
		if (anno.equals("2017")) { ruta = ruta2017; }
		if (anno.equals("2018")) { ruta = ruta2018; }
		if (anno.equals("2019")) { ruta = ruta2019; }

		String lineaDatos;
		int contador = 0;

		try
		{	
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);

			// lectura de datos
			br.readLine();
			while ( (lineaDatos = br.readLine()) != null )
			{
				String[] camposDatos = lineaDatos.split(",");

				// ------
				// CAMPOS
				// ------
				// id
				String id = camposDatos[0];
				// severity
				String severity = camposDatos[3];
				// startTime
				String startTime = camposDatos[4].substring(0, 10);
				// endTime
				String endTime = camposDatos[5].substring(0, 10);

				Accidente accidente = new Accidente(id, severity, startTime, endTime);

				datosRBT.put(startTime,accidente);
				datosBST.put(startTime, accidente);
				
				contador ++;
			}

			// Cierra el lector
			br.close();
			System.out.println();
			System.out.println("Existen " + contador + " accidentes en el anno " + anno + "\n");
			// Imprime la información del arbol RBT
			System.out.println("***** INFORMACION DE LA LECTURA DE DATOS (RBT) *****");
			System.out.println("El numero total de llaves ingresadas en el arbol fueron: " + (((LinkedList<String>) datosRBT.keySet()).size()));
			System.out.println("La altura del arbol es: " + datosRBT.height());
			System.out.println("Valor minimo de llave en el arbol: " + datosRBT.min());
			System.out.println("Valor maximo de llave en el arbol: " + datosRBT.max()+ "\n");
			// Imprimne la informacion del arbol BST
			System.out.println("***** INFORMACION DEL BinarySearchTree (BST) *****");
			System.out.println("El numero total de llaves ingresadas en el arbol fueron: " + (((LinkedList<String>) datosBST.keySet()).size()));
			System.out.println("La altura del arbol es: " + datosBST.height());
			System.out.println("Valor minimo de llave en el arbol: " + datosBST.min());
			System.out.println("Valor maximo de llave en el arbol: " + datosBST.max() + "\n");


		} catch (Exception e)
		{
			System.out.println("Error al cargar los datos: " + e.getMessage());
		}
	}
}