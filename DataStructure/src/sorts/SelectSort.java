package sorts;

import java.util.ArrayList;

public class SelectSort<E extends Comparable<E>> extends AbstractSort<E> {

	public SelectSort(ArrayList<E> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		ArrayList<E> list = getList();
		for (int i = 0, k; i < list.size() - 1; i++) {
			k = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).compareTo(list.get(k)) < 0) {
					k = j;
				}
			}
			swap(i, k);
		}
	}

}
