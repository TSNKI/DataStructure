import java.util.ArrayList;

public class Combination {

	public static ArrayList<Integer> list;

	public static void main(String[] args) {
		list = new ArrayList<Integer>();
		new Combination().combine(5, 3);
	}

	void combine(int n, int r) {
		if (n < r)
			return;
		if (r == 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		} else {
			list.add(n);
			combine(n - 1, r - 1);
			list.remove(list.size() - 1);
			combine(n - 1, r);
		}
	}
}
