package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.List;

class MaxDistanceRouteFinder extends RouteFinder {

	private List<Route> routes = new ArrayList<Route>();
	private int maxDistance;
	
	public MaxDistanceRouteFinder(Integer endVertex, int maxDistance) {
		 super(endVertex);
		 this.maxDistance = maxDistance;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	@Override
	protected void routeFound(Route route) {
		if(route.getDistance() < maxDistance) {
			routes.add(new Route(route));
		}
	}

	@Override
	protected boolean continueDigging(Integer vertex) {
		return route.getDistance() < maxDistance;
	}

}
