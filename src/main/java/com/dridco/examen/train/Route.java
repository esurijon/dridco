package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route {

	private List<Integer> path = new ArrayList<Integer>();
	private List<Integer> weights = new ArrayList<Integer>();
	private int distance;
		
	public Route() {
	}
	
	public Route(Route src) {
		this.path.addAll(src.path);
		this.distance = src.distance;
	}
	
	public List<Integer> getPath() {
		return path;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void addStop(Integer stop, int distance) {
		path.add(stop);
		weights.add(distance);
		this.distance += distance;
	};

	public void removeLastStop() {
		path.remove(path.size()-1);
		distance -= weights.remove(weights.size()-1);
	};
	
	public int getSize() {
		return path.size();
	}
	
	public boolean contains(Integer stop) {
		return path.contains(stop);
	}
	
	@Override
	public String toString() {
		return Arrays.toString(path.toArray()) + " : " + distance;
	}
}