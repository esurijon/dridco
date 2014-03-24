package com.dridco.examen.train;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TrainRouterTest {

	private TrainRouter trainRouter;
	
	@Before
	public void initGraph() {
		trainRouter = new TrainRouter();
		trainRouter.addRoute('A', 'B', 5);
		trainRouter.addRoute('B', 'C', 4);
		trainRouter.addRoute('C', 'D', 8);
		trainRouter.addRoute('D', 'C', 8);
		trainRouter.addRoute('D', 'E', 6);
		trainRouter.addRoute('A', 'D', 5);
		trainRouter.addRoute('C', 'E', 2);
		trainRouter.addRoute('E', 'B', 3);
		trainRouter.addRoute('A', 'E', 7);
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
		Assert.assertEquals(-1, distance);
	}

	@Test
	public void useCase6_Test() {
		int routeCount = trainRouter.countRoutesWithMaxStops('C', 'C', 3);
		Assert.assertEquals(2, routeCount);
	}

	@Test
	public void useCase7_Test() {
		int routeCount = trainRouter.countRoutesWithFixedStops('A', 'C', 4);
		Assert.assertEquals(3, routeCount);
	}

	@Test
	public void useCase8_Test() {
		int routeDistance = trainRouter.calcShortestRoute('A', 'C');
		Assert.assertEquals(9, routeDistance);
	}

	@Test
	public void useCase9_Test() {
		int routeDistance = trainRouter.calcShortestRoute('B', 'B');
		Assert.assertEquals(9, routeDistance);
	}

	@Test
	public void useCase10_Test() {
//		int routeCount = trainRouter.countRoutesWithMaxDistance('C', 'C', 30);
//		Assert.assertEquals(7, routeCount);
	}
}

