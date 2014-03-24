package com.dridco.examen.train;


public class TrainRouter2 {
	
	
	private int[][] graph = new int[5][5];
	
	public TrainRouter2() {
		add('A', 'B', 5);
		add('B', 'C', 4);
		add('C', 'D', 8);
		add('D', 'C', 8);
		add('D', 'E', 6);
		add('A', 'D', 5);
		add('C', 'E', 2);
		add('E', 'B', 3);
		add('A', 'E', 7);
	}

	private int seq(char c) {
		return c - 'A';
	}
	
	private void add(char from, char to, int weight) {
		graph[seq(from)][seq(to)] = weight;
	}

	public int calcRouteDistance(char[] route){
		int d = 0;
		for (int i = 1; i < route.length; i++) {
			int from = seq(route[i-1]);
			int to = seq(route[i]);
			int weight = graph[from][to];
			if(weight == 0){
				d=0;
				break;
			} 
			d+=weight;
		}
		return d;
	};

	public int[] calcShortestRoute(int origin, int target){
		return null;
		
	};

	public int countRoutes(char origin, char end){
		int count = 0;

		int[] adyacents = graph[seq(origin)];
		for (int i = 0; i < adyacents.length; i++) {
			boolean isRelated = adyacents[i]>0;
			if(isRelated) {
				
				if(seq(end) == i) {
					return 0;
				}
			}
		}
		
		return count;
	};
}
