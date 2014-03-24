package com.dridco.examen.train;

import com.dridco.examen.graph.GraphTraverseHandler;

class ShortestRouteFinder implements GraphTraverseHandler<Integer, Number> {

	private Route route = new Route();
	private Route shortestRoute = new Route();

	private Integer endVertex;
	
	public ShortestRouteFinder(Integer endVertex) {
		 this.endVertex = endVertex;
	}
	
	public Route getRoute() {
		return route;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost) {
		route.addStop(vertex, cost.intValue());
		boolean continueInDepth = route.getPath().contains(vertex);
		if(endVertex == vertex && shortestRoute.getDistance() > route.getDistance()) {
			System.out.println(route);
			shortestRoute = new Route(route);
		}
		return continueInDepth;
	}

	@Override
	public void stepUp() {
		route.removeLastStop();
	}

}
