package sorts;

import java.util.ArrayList;

public class InsertSort<E extends Comparable<E>> extends AbstractSort<E> {

	public InsertSort(ArrayList<E> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		ArrayList<E> list = getList();
		for (int i = 1; i < list.size(); i++) {
			int j;
			E temp = list.get(i);
			for (j = i - 1; j >= 0 && list.get(j).compareTo(temp) > 0; j--)
				list.set(j + 1, list.get(j));
			list.set(j + 1, temp);
		}
	}

}
