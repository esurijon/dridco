package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dridco.examen.graph.GraphTraverseHandler;

class MaxDistanceRouteFinder implements GraphTraverseHandler<Integer, Number> {

	private List<List<Integer>> routes = new ArrayList<List<Integer>>();
	private List<Integer> path = new ArrayList<Integer>();
	private int distance = 0;
	private int currDepth = 0;

	private Integer endVertex;
	private int l;
	
	public MaxDistanceRouteFinder(Integer endVertex, int l) {
		 this.endVertex = endVertex;
		 this.l = l;
	}
	
	@Override
	public boolean visit(Integer vertex, Number cost) {
		currDepth++;
		path.add(vertex);
		distance += cost.intValue();
		if(endVertex == vertex && currDepth == l) {
			System.out.println(Arrays.toString(path.toArray()) + " : " + distance);
			routes.add(path);
			path = new ArrayList<Integer>();
		}
		return true;
	}

	@Override
	public void stepUp() {
		currDepth--;
		Integer last = path.remove(path.size()-1);
		distance -= last.intValue();
	}

}
