package com.dridco.examen.graph;

import java.util.Iterator;

public abstract class AbstractGraph<V, E> implements Graph<V, E> {

	@Override
	public void traversePath(V[] path, GraphTraverseHandler<V, E> handler) throws InvalidPathException {
		for (int i = 1; i < path.length; i++) {
			V from = path[i-1];
			V to = path[i];
			E edge = getConnection(from, to);
			if(edge == null) {
				throw new InvalidPathException(from, to);
			} 
			boolean doContinue = handler.visit(to, edge);
			if(!doContinue){
				break;
			} 
		}
	}

	@Override
	public void traverseDepthFirst(V origin, GraphTraverseHandler<V, E> handler) {
		Iterator<Relation<V, E>> adyacents = getAdyacentVertices(origin);
		while (adyacents.hasNext()) {
			Graph.Relation<V,E> relation = adyacents.next();
			V vertex = relation.getVertex();
			E edge = relation.getEdge();
			boolean doContinue = handler.visit(vertex, edge);
			if(doContinue){
				traverseDepthFirst(vertex, handler);
			} 
			handler.stepUp();
		}
	};


	@Override
	public void traverseBreathFirst(V origin, int maxDepth, GraphTraverseHandler<V, E> handler) {
		throw new UnsupportedOperationException();
	};
	
}
