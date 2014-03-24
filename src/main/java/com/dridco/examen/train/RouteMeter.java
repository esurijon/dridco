package com.dridco.examen.train;

import com.dridco.examen.graph.GraphTraverseHandler;

class RouteMeter implements GraphTraverseHandler<Integer, Number> {

	private int distance = 0;

	public int getDistance() {
		return distance;
	}

	@Override
	public boolean visit(Integer vertex, Number cost) {
		distance += cost.intValue();
		return true;
	}

	@Override
	public void stepUp() {}

}
