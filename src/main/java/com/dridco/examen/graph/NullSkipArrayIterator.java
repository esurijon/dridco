package com.dridco.examen.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullSkipArrayIterator<E> implements Iterator<E> {
	
	private E[] array;
	private int currIndex = 0;
	
	public NullSkipArrayIterator(E[] array) {
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		while (array[currIndex] == null && currIndex < array.length) {
			currIndex++;
		}
		return (currIndex < array.length);
	}

	@Override
	public E next() {
		while (array[currIndex] == null && currIndex < array.length) {
			currIndex++;
		}
		if(currIndex < array.length) {
			return array[currIndex];
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
