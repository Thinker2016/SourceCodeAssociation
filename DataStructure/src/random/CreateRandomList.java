package random;

import java.util.ArrayList;
import java.util.Random;;

public class CreateRandomList {

	public static ArrayList<Integer> createList(int size) {
		ArrayList<Integer> list = new ArrayList<>(size);
		Random random = new Random(20);
		for (int i = 0; i < size; i++) {
			list.add(random.nextInt() % size);
		}
		return list;
	}

}
