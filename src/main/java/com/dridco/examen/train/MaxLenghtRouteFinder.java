package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.dridco.examen.graph.GraphTraverseHandler;

class MaxLenghtRouteFinder implements GraphTraverseHandler<Integer, Number> {

	private static Logger logger = Logger.getLogger(FixedLenghtRouteFinder.class.getName());

	private List<Route> routes = new ArrayList<Route>();
	private Route route = new Route();
	private int currDepth = 0;

	private Integer endVertex;
	private int maxStops;
	
	public MaxLenghtRouteFinder(Integer endVertex, int maxStops) {
		 this.endVertex = endVertex;
		 this.maxStops = maxStops;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost) {
		route.addStop(vertex, cost.intValue());
		currDepth++;
		boolean continueInDepth = (currDepth < maxStops);
		if(endVertex == vertex) {
			logger.fine("Route found: " + route.toString());
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
