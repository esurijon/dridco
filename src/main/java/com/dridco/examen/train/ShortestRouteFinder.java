package com.dridco.examen.train;


class ShortestRouteFinder extends RouteFinder {

	private Route shortestRoute;

	public ShortestRouteFinder(Integer endVertex) {
		 super(endVertex);
	}
	
	public Route getRoute() {
		return shortestRoute;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost, int depth) {
		while(depth < route.getSize()) {
			route.removeLastStop();
		}
		boolean alreadyVisited = route.contains(vertex);
		boolean continueInDepth = !alreadyVisited;
		if(!alreadyVisited) {
			route.addStop(vertex, cost.intValue());
			boolean hasLessDistance = shortestRoute == null || shortestRoute.getDistance() > route.getDistance();
			if(endVertex == vertex && hasLessDistance ) {
				shortestRoute = new Route(route);
				continueInDepth = false;
			}
		} 
		return continueInDepth;
	}

	@Override
	protected void routeFound(Route route) {
	}

	@Override
	protected boolean continueDigging(Integer vertex) {
		return false;
	}

}
