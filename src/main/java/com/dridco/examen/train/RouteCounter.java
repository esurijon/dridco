package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dridco.examen.graph.GraphTraverseHandler;

class RouteCounter implements GraphTraverseHandler<Integer, Number> {

	private List<List<Integer>> routes = new ArrayList<List<Integer>>();
	private List<Integer> path = new ArrayList<Integer>();
	private int distance = 0;
	private Integer endVertex;
	
	public RouteCounter( Integer endVertex) {
		 this.endVertex = endVertex;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost) {
		path.add(vertex);
		distance += cost.intValue();
		if(endVertex == vertex) {
			System.out.println(Arrays.toString(path.toArray()) + " : " + distance);
			routes.add(path);
			path = new ArrayList<Integer>();
		}
		return true;
	}

}
