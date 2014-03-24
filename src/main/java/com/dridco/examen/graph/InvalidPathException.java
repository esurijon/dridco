package com.dridco.examen.graph;

public class InvalidPathException extends Exception {

	public <V> InvalidPathException(V from, V to) {
		super(String.format("Vertices %1s and %2s are not connected", from, to));
	}

	
}
