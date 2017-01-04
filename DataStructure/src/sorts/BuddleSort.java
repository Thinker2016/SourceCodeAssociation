package sorts;

import java.util.ArrayList;

public class BuddleSort<E extends Comparable<E>> extends AbstractSort<E> {

	public BuddleSort(ArrayList<E> list) {
		super(list);
	}

	public void sort() {
		ArrayList<E> list = getList();
		for (int i = 1; i < list.size(); i++)
			for (int j = i; j > 0 && list.get(j).compareTo(list.get(j - 1)) < 0; j--)
				swap(j, j - 1);
	}

}
