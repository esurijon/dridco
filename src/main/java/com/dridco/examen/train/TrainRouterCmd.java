package com.dridco.examen.train;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;


public class TrainRouterCmd {

	public static void main(String[] args) throws IOException {
		System.out.println("Sistema de trenes.");
		System.out.println("Ingrese el grafo. Ej: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

		LineNumberReader console = new LineNumberReader(new InputStreamReader(System.in));
		String grafo = console.readLine();
		TrainRouter tr = null;
		
		System.out.println("Para obtener distancia de una ruta. D A-B-C. Donde A, B y C son ciudades");
		System.out.println("Para cantidad de rutas entre ciudades. C E-G. Donde E y G son ciudades");
		System.out.println("Para ruta mas corta entre ciudades. R A-B-C. Donde A, B y C son ciudades");
		System.out.println("Para finalizar: exit");

		String command = null;
		while(!command.equals("exit")){
			command = console.readLine();
			
			if(true){
				tr.calcRouteDistance(null);
			} else if(false) {
//				tr.countRoutes('A', 'B', 1);
			}else if(false) {
//				tr.calcShortestRoute(0, 0);
			}else {
				System.out.println("Comando invalido");
			}
		}
		
	}

}
