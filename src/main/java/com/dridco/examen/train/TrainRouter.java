package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.dridco.examen.graph.Graph;
import com.dridco.examen.graph.Graph.Relation;
import com.dridco.examen.graph.InvalidPathException;
import com.dridco.examen.graph.MatrixBackedGraph;

public class TrainRouter {

	public static class Route {
		private List<Integer> path = new ArrayList<Integer>();
		private int distance;
		
		public List<Integer> getPath() {
			return path;
		}
		
		public int getDistance() {
			return distance;
		}
		
		public void addStop(Integer stop, int distance) {
			this.distance += distance;
			path.add(stop);
		};

		public void removeStop(Integer stop, int distance) {
			this.distance -= distance;
			path.remove(path.size()-1);
		};
		
		@Override
		public String toString() {
			return Arrays.toString(path.toArray()) + " : " + distance;
		}
	}
	
	Graph<Integer, Number> graph = new MatrixBackedGraph<Number>(28);
	
	public void addRoute(char from, char to, Number weight) {
		graph.connectVertices(from - 'A', to - 'A', weight);
	}

	public int calcRouteDistance(char[] route){
		RouteMeter handler = new RouteMeter();
		Integer[]path = new Integer[route.length];
		for (int i = 0; i < route.length; i++) {
			path[i]= route[i] - 'A';
		}
		try {
			graph.traversePath(path, handler);
			return handler.getDistance();
		} catch (InvalidPathException e) {
			return -1;
		}
	};

	public int calcShortestRoute(char origin, char end) {
		int from = origin - 'A';
		int to = end - 'A';
		graph.traverseDepthFirst(from, null);
		return 0;
	}

	public int countRoutesWithMaxStops(char origin, char end, int maxDepth){
		return 0;
	}

	public int countRoutesWithFixedStops(char origin, char end, int stopsAmount){
		int from = origin - 'A'; 
		int to = end - 'A'; 
		Route route = new Route();
		findRoutesWithFixedStops(from, to, stopsAmount, route);
		return 0;
	}


	private void findRoutesWithFixedStops(Integer origin, Integer end, int stopsAmount, Route route) {
		Iterator<Relation<Integer, Number>> adyacents = graph.getAdyacentVertices(origin);
		while (adyacents.hasNext() && stopsAmount > 0) {
			Graph.Relation<Integer,Number> relation = adyacents.next();
			Integer vertex = relation.getVertex();
			int distance = relation.getEdge().intValue();
			route.addStop(vertex, distance);
			findRoutesWithFixedStops(vertex, end, stopsAmount-1, route);
			route.removeStop(vertex, distance);
		}
		if(stopsAmount == 0){
			if(origin.equals(end)) {
				System.out.println(route);
			}
		}
	};

	private void findRoutesWithMaxDistance(Integer origin, Integer end, int stopsAmount) {
	};
	
}
