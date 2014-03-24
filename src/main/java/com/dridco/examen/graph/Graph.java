package com.dridco.examen.graph;

import java.util.Iterator;

public interface Graph<V, E> {

	public interface Relation<V, E> {
		V getVertex();
		E getEdge();
	};

	void traversePath(V[] path, GraphTraverseHandler<V, E> handler) throws InvalidPathException;
	void traverseDepthFirst(V origin, int maxDepth, GraphTraverseHandler<V, E> handler);
	void traverseBreathFirst(V origin, int maxDepth, GraphTraverseHandler<V, E> handler);

	Iterator<Relation<V, E>> getAdyacentVertices(V vertex);
	E getRelation(V from, V to);
	
	void connectVertices(V origin, V target, E edge);
	void unconnectVertices(V origin, V target);
}
