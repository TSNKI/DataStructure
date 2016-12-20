import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {

	public static void main(String[] args) {
		System.out.println("Enter number of disks:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 1;
		try {
			n = Integer.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Steps are:");
		moveDISKs(n, 'A', 'B', 'C');
	}

	public static void moveDISKs(int n, char fromTower, char toTower, char auxTower) {
		if (n == 1) {
			System.out.println("Move disk 1 from " + fromTower + " to " + toTower + ".");
		} else {
			moveDISKs(n - 1, fromTower, auxTower, toTower);
			System.out.println(("Move disk " + n + " from " + fromTower + " to " + toTower + "."));
			moveDISKs(n - 1, auxTower, toTower, fromTower);
		}
	}
}
