package controller;

import java.util.Objects;
import java.util.Scanner;

import javafx.scene.shape.Line;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	/** 
	 * método run de la Clase Controller
	 * inicia la aplicación
	 */
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin )
		{
			view.printMenu();
			
			int option=1;
			try {
				 option = lector.nextInt();
			}
			catch(Exception e)
			{
				view.printMessage("Opcion invalida. Debe digitar un número. Vuelva a intentar");
				lector.nextLine();
				 option = lector.nextInt();
			}
			
			switch(option)
			{
			// Importa los datos
			case 1:
				System.out.print("¿De que año desea la información de los accidentes?");
				String anno = lector.next();
				System.out.println("Importando datos del año " + anno + "...");
				modelo.leerDatos(anno);
				System.out.println("Datos importados correctamente.");
				break;
			// resuelve requerimiento 1
			case 2:
				System.out.println("Ingrese la fecha que desea consultar");
				String st = lector.next();
				
				try {
					modelo.conocerAccidentesFechaRBT(st);
					modelo.conocerAccidentesFechaBST(st);
				}
				catch (Exception e){
					
					System.out.println("La fecha que desea consultar no existe en la base de datos. Vuelva a intentarlo. " + "\n");
				}

				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				fin = true;
				break;
			}
		}

		lector.close();

	}	
}