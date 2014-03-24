package com.dridco.examen.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.dridco.examen.graph.Graph.Relation;


public class MatrixBackedGraph extends AbstractGraph<Integer, Number> {

	private class NullSkipArrayIterator implements Iterator<Relation<Integer,Number>> {
		
		private Number[] array;
		private int currIndex = 0;
		
		public NullSkipArrayIterator(Number[] array) {
			this.array = array;
		}

		@Override
		public boolean hasNext() {
			while (currIndex < array.length && array[currIndex] == null) {
				currIndex++;
			}
			return (currIndex < array.length);
		}

		@Override
		public Relation<Integer,Number> next() {
			while (array[currIndex] == null && currIndex < array.length) {
				currIndex++;
			}
			if(currIndex < array.length) {
				final Number edge = array[currIndex];
				final Integer vertex = currIndex;
				currIndex++;
				return new Relation<Integer, Number>(){

					@Override
					public Integer getVertex() {
						return vertex;
					}

					@Override
					public Number getEdge() {
						return edge;
					}};
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private Number graph[][];
	
	public MatrixBackedGraph(int dimension) {
		graph = new Number[dimension][dimension]; 
	}

	@Override
	public void connectVertices(Integer origin, Integer target, Number edge) {
		graph[origin][target] = edge;
	}

	@Override
	public void unconnectVertices(Integer origin, Integer target) {
		graph[origin][target] = null;
	}

	@Override
	public Iterator<com.dridco.examen.graph.Graph.Relation<Integer, Number>> getAdyacentVertices(Integer vertex) {
		Number[] array = graph[vertex];
		return new NullSkipArrayIterator(array);
	}

	@Override
	public Number getRelation(Integer from, Integer to) {
		return graph[from][to];
	}
	
	private List<Integer> path = new ArrayList<Integer>();
	private int dist = 0;
	public void traverseDepthFirst(Integer origin, int maxDepth, GraphTraverseHandler<Integer, Number> handler) {
		Iterator<Relation<Integer, Number>> adyacents = getAdyacentVertices(origin);
		while (adyacents.hasNext() && maxDepth > 0) {
			Graph.Relation<Integer,Number> relation = adyacents.next();
			Integer vertex = relation.getVertex();
			dist+=relation.getEdge().intValue(); 
			path.add(vertex);
			traverseDepthFirst(vertex, maxDepth-1, handler);
		}
		if(maxDepth == 0){
			System.out.println(Arrays.toString(path.toArray()) + " : " + dist);
			dist = 0;
			path = new ArrayList<Integer>();
		}
	};

}
