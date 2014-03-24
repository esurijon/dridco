package com.dridco.examen.train;

import java.util.Iterator;
import java.util.List;

import com.dridco.examen.graph.Graph;
import com.dridco.examen.graph.Graph.Relation;
import com.dridco.examen.graph.InvalidPathException;
import com.dridco.examen.graph.MatrixBackedGraph;

public class TrainRouter {

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

	public int countRoutesWithFixedStops(char origin, char end, int stopsAmount){
		int from = origin - 'A';
		int to = end - 'A';
		FixedLenghtRouteFinder routeFinder = new FixedLenghtRouteFinder(to, stopsAmount); 
		graph.traverseDepthFirst(from, routeFinder);
		List<Route> routes = routeFinder.getRoutes();
		return routes.size();
	}

	public int countRoutesWithMaxStops(char origin, char end, int maxStops){
		int from = origin - 'A';
		int to = end - 'A';
		MaxLenghtRouteFinder routeFinder = new MaxLenghtRouteFinder(to, maxStops); 
		graph.traverseDepthFirst(from, routeFinder);
		List<Route> routes = routeFinder.getRoutes();
		return routes.size();
	}

	public int calcShortestRouteDistance(char origin, char end) {
		int from = origin - 'A';
		int to = end - 'A';
		ShortestRouteFinder routeFinder = new ShortestRouteFinder(to);
		graph.traverseDepthFirst(from, routeFinder);
		Route route = routeFinder.getRoute();
		return route.getDistance();
	}

	public int countRoutesWithMaxDistance(char origin, char end, int maxDistance) {
		int from = origin - 'A';
		int to = end - 'A';
		MaxDistanceRouteFinder routeFinder = new MaxDistanceRouteFinder(to, maxDistance); 
		graph.traverseDepthFirst(from, routeFinder);
		List<Route> routes = routeFinder.getRoutes();
		return routes.size();
	}
}
