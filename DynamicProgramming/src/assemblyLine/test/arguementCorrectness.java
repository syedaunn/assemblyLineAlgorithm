package assemblyLine.test;

import static org.junit.Assert.*;
import org.junit.Test;
import assemblyLine.algorithm.AssemblyLineAlgorithm;

public class arguementCorrectness {

	@Test
	public void IncorrectEntryTimes() {
		
		int entryTimes[] = {2,4,9};
		int exitTimes[] = {3,2};
		int stationTimes[][]={{7,9,3,4,8,4},{8,5,6,4,5,7}};
		int transTimes[][]={{2,3,1,3,4},{2,1,2,2,1}};
		int n = 6;
		try{
			AssemblyLineAlgorithm.FastestWayAlgo(entryTimes,exitTimes,stationTimes,transTimes,n);
			fail("Incorrect Arguments taken granted");
		}catch(IllegalArgumentException e){
			;
		}
		int entryTimes_[] = {2,4};
		int exitTimes_[] = {3,2,9};
		try{
			AssemblyLineAlgorithm.FastestWayAlgo(entryTimes_,exitTimes_,stationTimes,transTimes,n);
			fail("Incorrect Arguments taken granted");
		}catch(IllegalArgumentException e){
			;
		}

	}

	@Test
	public void IncorrectStationTimes() {
		
		int entryTimes[] = {2,4};
		int exitTimes[] = {3,2};
		int stationTimes[][]={{7,9,3,4,8,4,7},{8,5,6,4,5,7}};
		int stationTimes_[][]={{7,9,3,4,8,4},{8,5,6,4,5,7,9}};
		int transTimes[][]={{2,3,1,3,4},{2,1,2,2,1}};
		int n = 6;
		try{
			AssemblyLineAlgorithm.FastestWayAlgo(entryTimes,exitTimes,stationTimes,transTimes,n);
			fail("Incorrect Arguments taken granted");
		}catch(IllegalArgumentException e){
			;
		}
		try{
			AssemblyLineAlgorithm.FastestWayAlgo(entryTimes,exitTimes,stationTimes_,transTimes,n);
			fail("Incorrect Arguments taken granted");
		}catch(IllegalArgumentException e){
			;
		}

	}

	@Test
	public void IncorrectNumStation() {
		
		int entryTimes[] = {2,4};
		int exitTimes[] = {3,2};
		int stationTimes[][]={{7,9,3,4,8,4},{8,5,6,4,5,7}};
		int transTimes[][]={{2,3,1,3,4},{2,1,2,2,1}};
		int n = 3;
		try{
			AssemblyLineAlgorithm.FastestWayAlgo(entryTimes,exitTimes,stationTimes,transTimes,n);
			fail("Incorrect Arguments taken granted");
		}catch(IllegalArgumentException e){
			;
		}
		

	}

}
