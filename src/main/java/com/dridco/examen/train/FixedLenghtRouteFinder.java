package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.List;

class FixedLenghtRouteFinder extends RouteFinder {

	private List<Route> routes = new ArrayList<Route>();
	private int stops;
	
	public FixedLenghtRouteFinder(Integer endVertex, int stops) {
		 super(endVertex);
		 this.stops = stops;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	@Override
	protected void routeFound(Route route) {
		if(route.getSize() == stops) {
			routes.add(new Route(route));
		}
	}

	@Override
	protected boolean continueDigging(Integer vertex) {
		return (route.getSize() < stops);
	}

}
