package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.dridco.examen.graph.GraphTraverseHandler;

class MaxDistanceRouteFinder implements GraphTraverseHandler<Integer, Number> {

	private static Logger logger = Logger.getLogger(FixedLenghtRouteFinder.class.getName());

	private List<Route> routes = new ArrayList<Route>();
	private Route route = new Route();

	private Integer endVertex;
	private int maxDistance;
	
	public MaxDistanceRouteFinder(Integer endVertex, int maxDistance) {
		 this.endVertex = endVertex;
		 this.maxDistance = maxDistance;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost) {
		route.addStop(vertex, cost.intValue());
		boolean continueInDepth = (route.getDistance() < maxDistance);
		if(endVertex == vertex) {
			logger.fine("Route found: " + route.toString());
			routes.add(new Route(route));
		}
		return continueInDepth;
	}

	@Override
	public void stepUp() {
		route.removeLastStop();
	}

}
