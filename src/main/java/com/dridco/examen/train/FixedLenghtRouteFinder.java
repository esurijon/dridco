package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.List;

import com.dridco.examen.graph.GraphTraverseHandler;

class FixedLenghtRouteFinder implements GraphTraverseHandler<Integer, Number> {

	private List<Route> routes = new ArrayList<Route>();
	private Route route = new Route();
	private int currDepth = 0;

	private Integer endVertex;
	private int stops;
	
	public FixedLenghtRouteFinder(Integer endVertex, int stops) {
		 this.endVertex = endVertex;
		 this.stops = stops;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost) {
		route.addStop(vertex, cost.intValue());
		currDepth++;
		boolean continueInDepth = (currDepth < stops);
		if(!continueInDepth && endVertex == vertex) {
			System.out.println(route);
			routes.add(new Route(route));
		}
		return continueInDepth;
	}

	@Override
	public void stepUp() {
		currDepth--;
		route.removeLastStop();
	}

}
