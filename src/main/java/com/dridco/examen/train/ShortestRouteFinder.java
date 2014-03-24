package com.dridco.examen.train;

import java.util.logging.Logger;

import com.dridco.examen.graph.GraphTraverseHandler;

class ShortestRouteFinder implements GraphTraverseHandler<Integer, Number> {

	private static Logger logger = Logger.getLogger(FixedLenghtRouteFinder.class.getName());

	private Route route = new Route();
	private Route shortestRoute;

	private Integer endVertex;
	
	public ShortestRouteFinder(Integer endVertex) {
		 this.endVertex = endVertex;
	}
	
	public Route getRoute() {
		return shortestRoute;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost) {
		boolean alreadyVisited = route.getPath().contains(vertex);
		boolean continueInDepth = !alreadyVisited;
		if(!alreadyVisited) {
			route.addStop(vertex, cost.intValue());
			boolean hasLessDistance = shortestRoute == null || shortestRoute.getDistance() > route.getDistance();
			if(endVertex == vertex && hasLessDistance ) {
				logger.fine("Route found: " + route.toString());
				shortestRoute = new Route(route);
				continueInDepth = false;
			}
		} 
		return continueInDepth;
	}

	@Override
	public void stepUp() {
		route.removeLastStop();
	}

}
