import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hoff3539\\workspace\\StackBasedListHomework\\res\\data.csv"));
			StringBuilder sb = new StringBuilder();
			while (br.ready()) {
				sb.append(br.readLine());
			}
			br.close();
			String raw = sb.toString();
			StringTokenizer st = new StringTokenizer(raw,",");
			StackBasedList<Integer> sbl = new StackBasedTightList<Integer>();
			long startTime = System.nanoTime();
			while (st.hasMoreTokens()) {
				sbl.push(new Integer(st.nextToken(",")));
			}
			System.out.println("operation completed in " + (System.nanoTime() - startTime) + " nanoseconds.");
			System.out.println("size " + sbl.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
