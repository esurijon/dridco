package com.dridco.examen.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route {

	private List<Integer> path = new ArrayList<Integer>();
	private int distance;
	private int lastDistance;
		
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
		lastDistance = distance;
		this.distance += distance;
		path.add(stop);
	};

	public void removeLastStop() {
		distance -= lastDistance;
		if(path.size()>0) {
			path.remove(path.size()-1);
		}
	};
	
	@Override
	public String toString() {
		return Arrays.toString(path.toArray()) + " : " + distance;
	}
}