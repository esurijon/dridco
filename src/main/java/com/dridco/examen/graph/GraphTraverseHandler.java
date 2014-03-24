package com.dridco.examen.graph;


public interface GraphTraverseHandler<V, E> {

	boolean visit(V vertex, E cost);
}
