package sorts;

import java.util.ArrayList;

public abstract class AbstractSort<E extends Comparable<E>> {
	private ArrayList<E> list;

	public ArrayList<E> getList() {
		return list;
	}

	public AbstractSort(ArrayList<E> list) {
		this.list = list;
	}

	public abstract void sort();

	protected void swap(int i, int j) {
		if(i==j)
			return;
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}
