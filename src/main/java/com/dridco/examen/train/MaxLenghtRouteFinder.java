package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.List;

class MaxLenghtRouteFinder extends RouteFinder {

	private List<Route> routes = new ArrayList<Route>();
	private int maxStops;

	public MaxLenghtRouteFinder(Integer endVertex, int maxStops) {
		 super(endVertex);
		 this.maxStops = maxStops;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}

	@Override
	protected void routeFound(Route route) {
		routes.add(new Route(route));
	}

	@Override
	protected boolean continueDigging(Integer vertex) {
		return (route.getSize() < maxStops);
	}

}
