import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) {
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
	}
}
