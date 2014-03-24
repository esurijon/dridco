package com.dridco.examen.train;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TrainRouter2Test {

	private TrainRouter2 trainRouter = new TrainRouter2();

	@Before
	public void initGraph() {

	}

	@Test
	public void useCase1_Test() {
		char[] route = new char[] { 'A', 'B', 'C' };
		int distance = trainRouter.calcRouteDistance(route);
		Assert.assertEquals(9, distance);
	}

	@Test
	public void useCase2_Test() {
		char[] route = new char[] { 'A', 'D' };
		int distance = trainRouter.calcRouteDistance(route);
		Assert.assertEquals(5, distance);
	}

	@Test
	public void useCase3_Test() {
		char[] route = new char[] { 'A', 'D', 'C' };
		int distance = trainRouter.calcRouteDistance(route);
		Assert.assertEquals(13, distance);
	}

	@Test
	public void useCase4_Test() {
		char[] route = new char[] { 'A', 'E', 'B', 'C', 'D' };
		int distance = trainRouter.calcRouteDistance(route);
		Assert.assertEquals(22, distance);
	}
	@Test
	public void useCase5_Test() {
		char[] route = new char[] { 'A', 'E', 'D' };
		int distance = trainRouter.calcRouteDistance(route);
		Assert.assertEquals(0, distance);
	}
}
