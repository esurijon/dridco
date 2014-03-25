package com.dridco.examen.train;

import java.util.logging.Logger;

import com.dridco.examen.graph.GraphTraverseHandler;

abstract class RouteFinder implements GraphTraverseHandler<Integer, Number> {

	private static Logger logger = Logger.getLogger(RouteFinder.class.getName());

	protected Route route = new Route();

	protected Integer endVertex;
	
	public RouteFinder(Integer endVertex) {
		 this.endVertex = endVertex;
	}
		
	@Override
	public boolean visit(Integer vertex, Number cost, int depth) {
		while(depth < route.getSize()) {
			route.removeLastStop();
		}
		route.addStop(vertex, cost.intValue());

		if(endVertex == vertex) {
			Route foundedRoute = new Route(route);
			logger.fine("Route found: " + route.toString());
			routeFound(foundedRoute);
		}
		return continueDigging(vertex);
	}

	abstract protected void routeFound(Route route);

	abstract protected boolean continueDigging(Integer vertex);

}
