import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class Main{
	public static int[] towers;
	public static final int TOWER1 = 0;
	public static final int TOWER2 = 1;
	public static final int TOWER3 = 2;
	public static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("data/Hanoi_input.txt");
		FileWriter fw = new FileWriter("data/Hanoi_output.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int m = Integer.parseInt(line);
		bw = new BufferedWriter(fw);
		for (int i = 0; i < m; i++){
			line = br.readLine();
			int disks = Integer.parseInt(line);
			towers = new int[3];
			towers[0] = disks;
			bw.write(towers[0]+" "+towers[1]+" "+towers[2]);
			bw.newLine();
			hanoi(disks, 0, 2, 1);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
	public static void hanoi(int k, int o, int d, int a) throws Exception{
		if (k>0) {
			hanoi(k-1,o,a,d);
			towers[o]--;
			towers[d]++;
			bw.write(towers[0]+" "+towers[1]+" "+towers[2]);
			bw.newLine();
			hanoi(k-1,a,d,o);
		}
	}
}