package com.dridco.examen.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MatrixBackedGraph<E> extends AbstractGraph<Integer, E> {

	private class NullSkipArrayIterator implements Iterator<Relation<Integer,E>> {
		
		private E[] array;
		private int currIndex = 0;
		
		public NullSkipArrayIterator(E[] array) {
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
		public Relation<Integer,E> next() {
			while (array[currIndex] == null && currIndex < array.length) {
				currIndex++;
			}
			if(currIndex < array.length) {
				final E edge = array[currIndex];
				final Integer vertex = currIndex;
				currIndex++;
				return new Relation<Integer, E>(){

					@Override
					public Integer getVertex() {
						return vertex;
					}

					@Override
					public E getEdge() {
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

	private Object graph[][];
	
	public MatrixBackedGraph(int dimension) {
		graph = new Object[dimension][dimension]; 
	}

	@Override
	public void connectVertices(Integer origin, Integer target, E edge) {
		graph[origin][target] = edge;
	}

	@Override
	public void unconnectVertices(Integer origin, Integer target) {
		graph[origin][target] = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<com.dridco.examen.graph.Graph.Relation<Integer, E>> getAdyacentVertices(Integer vertex) {
		E[] array = (E[]) graph[vertex];
		return new NullSkipArrayIterator(array);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getConnection(Integer from, Integer to) {
		return (E) graph[from][to];
	}

}
