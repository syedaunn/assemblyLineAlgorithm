package assemblyLine.algorithm;

import java.util.LinkedList;
/*
*	Dynammic Programming
*	Assembly Line Problem
*	Fastest Way Algorithm
*	Author: Aunn Raza
*/

public class AssemblyLineAlgorithm {

	public static void main(String[] args) {
		int entryTimes[] = {2,4};
		int exitTimes[] = {3,2};
		int stationTimes[][]={{7,9,3,4,8,4},{8,5,6,4,5,7}};
		int transTimes[][]={{2,3,1,3,4},{2,1,2,2,1}};
		int n = 6;
		LinkedList<Object> ret = FastestWayAlgo(entryTimes,exitTimes,stationTimes,transTimes,n);
		displayPath(ret);

	}

	/*	Method: FastestWay
	 *  Arguments:
	 *  	entryTimes[] : Integer Array having entry times of respective assembly lines
	 * 		exitTimes[]	 : Integer Array having exit times of respective assembly lines
	 * 		timeStation  : Array of Integer Array containing station times in ascending order of stations
	 * 		timeStation  : Array of Integer Array containing station times in ascending order of stations
	 * 		transferTime : Array of Integer Array containing station transfer times in ascending order of stations
	 * 		numOfSations : Number of Stations in both assembly line
	 * */	
	public static LinkedList<Object> FastestWayAlgo(int entryTimes[],int exitTimes[], int timeStation[][], int transferTime[][], int numOfStations) throws IllegalArgumentException{
		if(entryTimes.length != exitTimes.length ){
			throw new IllegalArgumentException("Length(exit times) != Length(entry times) ");
		}
		if(timeStation[0].length != timeStation[1].length){
			throw new IllegalArgumentException("Number of station times mismatch ");
		}
		if(timeStation[0].length != numOfStations){
			throw new IllegalArgumentException("Invalid Number of Stations");
		}		
		if(transferTime[0].length != transferTime[1].length){
			throw new IllegalArgumentException("Number of transfer times mismatch ");
		}
		
		
		int numOfLines = entryTimes.length;
		if(numOfLines != 2){
			throw new IllegalArgumentException("Currently implemented for two assembly lines only");	
		}
		int costs[][] = new int[numOfLines][numOfStations+1];
		int trace[][] = new int[numOfLines][numOfStations+1];

		int finishCost = -1;


		for (int i = 0; i < entryTimes.length; i++) {
			costs[i][0] = entryTimes[i]+timeStation[i][0];	//Get the first station time = entry plus first time
		}

		for (int j = 1; j < numOfStations; j++) {


			if((costs[0][j-1] + timeStation[0][j]) <= (costs[1][j-1]+ transferTime[1][j-1]+timeStation[0][j])){
				costs[0][j]= costs[0][j-1]+ timeStation[0][j];
				trace[0][j] = 0;
			}else{
				costs[0][j]= costs[1][j-1]+ transferTime[1][j-1]+timeStation[0][j];
				trace[0][j]=1;
			}


			if(costs[1][j-1] + timeStation[1][j] <= costs[0][j-1]+ transferTime[0][j-1]+timeStation[1][j]){
				costs[1][j]= costs[1][j-1]+ timeStation[1][j];
				trace[1][j] = 1;
			}else{
				costs[1][j]= costs[0][j-1]+ transferTime[0][j-1]+timeStation[1][j];
				trace[1][j] = 0;
			}

		}

		if(costs[0][numOfStations-1]+exitTimes[0] <= costs[1][numOfStations-1]+exitTimes[1] ){
			finishCost =  costs[0][numOfStations-1]+exitTimes[0];
			trace[0][numOfStations] = 0;
		}else{
			finishCost = costs[1][numOfStations-1]+exitTimes[1] ;
			trace[0][numOfStations] = 1;
		}	
		String path[] = constructPath(trace, numOfStations);

		LinkedList<Object> ret = new LinkedList<>();
		ret.add(new Integer(finishCost));
		ret.add(path);
		return ret;
	}

	public static void displayPath(String pathp[]){
		for (String station : pathp) {
			System.out.println(station);
		}
	}

	public static void displayPath(LinkedList<Object> list ){
		System.out.println("Fastest Path Cost:\t"+(Integer)list.get(0));
		System.out.println("Path Taken:");
		String[]  path= (String[])list.get(1);
		for (String station : path) {
			System.out.println(station);
		}
	}

	public static String[] constructPath(int trace[][], int n){
		String path[] = new String[n];
		for (int j = n, i=0; j > 0; j--) {
			i = trace[i][j];
			path[j-1] = ("LINE("+(i+1)+")STATION("+(j)+")");
		}
		return path;
	}
}
