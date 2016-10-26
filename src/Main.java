import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) {
		// Method 1
		/*
		String integers = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("res\\data.csv"));
			StringBuilder sb = new StringBuilder();
			while (br.ready()) {
				sb.append(br.readLine());
			}
			br.close();
			integers = sb.toString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Growth
		StringTokenizer st1 = new StringTokenizer(integers,",");
		StackBasedList<Integer> sbl1 = new StackBasedGrowthList<Integer>();
		long startTime1 = System.nanoTime();
		while (st1.hasMoreTokens()) {
			sbl1.push(new Integer(st1.nextToken(",")));
		}
		System.out.println("pushed " + sbl1.size() + " in " + (System.nanoTime() - startTime1) + " nanoseconds using Growth.");

		// Tight
		StringTokenizer st2 = new StringTokenizer(integers,",");
		StackBasedList<Integer> sbl2 = new StackBasedTightList<Integer>();
		long startTime2 = System.nanoTime();
		while (st2.hasMoreTokens()) {
			sbl2.push(new Integer(st2.nextToken(",")));
		}
		System.out.println("pushed " + sbl2.size() + " in " + (System.nanoTime() - startTime2) + " nanoseconds using Tight.");
		*/
		
		// Method 2
		final int TRIALS = 32;
		final int MAX_ARRAY_SIZE = 100000; // Integer.MAX_VALUE - 5;
		final int MAX_RANDOM_NUMBER = Integer.MAX_VALUE;
		int[] array;
		String[][] results = new String[4][TRIALS+1];
		int longestNumberLength = 8;
		
		for (int i = 0; i <= TRIALS; i++) {
			StackBasedList<Integer> myArray;
			long timeStart, timeStop, timeGrowth, timeTight;
			array = new int[(MAX_ARRAY_SIZE / TRIALS)*i];
			System.out.println("Test " + (i+1) + " with " + array.length + " data points:");
			for (int j = 0; j < array.length; j++) {
				array[j] = (int)(Math.random()*MAX_RANDOM_NUMBER);
			}
			System.out.println("\tfinished generating random numbers.");
			
			// Growth
			myArray = new StackBasedGrowthList<Integer>();
			System.out.println("\tmeasuring Growth style");
			timeStart = System.nanoTime();
			for (int k : array) {
				myArray.push(k);
			}
			timeStop = System.nanoTime();
			timeGrowth = timeStop - timeStart;
			
			// Tight
			myArray = new StackBasedTightList<Integer>();
			System.out.println("\tmeasuring Tight style");
			timeStart = System.nanoTime();
			for (int k : array) {
				myArray.push(k);
			}
			timeStop = System.nanoTime();
			timeTight = timeStop - timeStart;

			results[0][i] = new Long(array.length).toString();
			results[1][i] = new Long(timeGrowth).toString();
			results[2][i] = new Long(timeTight-timeGrowth).toString();
			results[3][i] = new Long(timeTight).toString();
		}
		
		// Display Results
		for (int i = 0; i < results.length; i++) {
			for (int j = 0; j < results[0].length; j++) {
				longestNumberLength = Math.max(longestNumberLength, results[i][j].length());
			}
		}
		System.out.println();
		
		// 		Header
		for (int i = 0; i < Math.floor((longestNumberLength - 8) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.print("elements");
		for (int i = 0; i < Math.ceil((longestNumberLength - 8) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.print("||");
		for (int i = 0; i < Math.floor((longestNumberLength - 6) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.print("GROWTH");
		for (int i = 0; i < Math.ceil((longestNumberLength - 6) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.print("|");
		for (int i = 0; i < Math.floor((longestNumberLength - 5) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.print("DELTA");
		for (int i = 0; i < Math.ceil((longestNumberLength - 5) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.print("|");
		for (int i = 0; i < Math.floor((longestNumberLength - 5) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.print("TIGHT");
		for (int i = 0; i < Math.ceil((longestNumberLength - 5) / 2.0); i++) {
			System.out.print(" ");
		}
		System.out.println();
		
		// 		Data
		for (int i = 0; i < results[0].length; i++) {
			for (int j = 0; j < results.length; j++) {
				for (int k = 0; k < (longestNumberLength - results[j][i].length()); k++) {
					System.out.print(" ");
				}
				System.out.print(results[j][i]);
				if (j == 0) {
					System.out.print("||");
				}
				else if (j < results.length-1) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}
}
