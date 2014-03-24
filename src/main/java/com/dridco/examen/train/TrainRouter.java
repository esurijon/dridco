package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dridco.examen.graph.Graph;
import com.dridco.examen.graph.GraphTraverseHandler;
import com.dridco.examen.graph.InvalidPathException;
import com.dridco.examen.graph.MatrixBackedGraph;

public class TrainRouter {
	
	Graph<Integer, Number> graph = new MatrixBackedGraph(28);
	
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

	public int countRoutes(char origin, char end, int maxDepth){
		int from = origin - 'A'; 
		int to = end - 'A'; 
		RouteCounter handler = new RouteCounter(to);
		graph.traverseDepthFirst(from, maxDepth, handler);
		return 0;
	}
	
	public int[] calcShortestRoute(int origin, int target){
		GraphTraverseHandler<Integer, Integer> handler = null;
//		g.traverseDepthFirst(origin, 0, handler);
		return null;
	};

}
