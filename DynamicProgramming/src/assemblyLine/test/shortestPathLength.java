package assemblyLine.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import assemblyLine.algorithm.AssemblyLineAlgorithm;

public class shortestPathLength {

	@Test
	public void test() {
		int entryTimes[] = {2,4};
		int exitTimes[] = {3,2};
		int stationTimes[][]={{7,9,3,4,8,4},{8,5,6,4,5,7}};
		int transTimes[][]={{2,3,1,3,4},{2,1,2,2,1}};
		int n = 6;
		LinkedList<Object> ret = AssemblyLineAlgorithm.FastestWayAlgo(entryTimes,exitTimes,stationTimes,transTimes,n);
		int actualCost = 38;
		int expectedCost = (Integer)ret.get(0);
		if(actualCost != expectedCost)
			fail("Incorrect Shortest Path Cost");
		
		
	}

}
