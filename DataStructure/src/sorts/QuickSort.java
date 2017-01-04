package sorts;

import java.util.ArrayList;

public class QuickSort<E extends Comparable<E>> extends AbstractSort<E> {

	public QuickSort(ArrayList<E> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		sort(0, getList().size());
	}

	private void sort(int begin, int end) {
		if (begin >= end - 1)
			return;
		ArrayList<E> list = getList();
		int mid = (begin + end - 1) / 2;
		swap(begin, mid);
		int i = begin + 1, j = end - 1;
		while (i < j) {
			while (i < end && list.get(i).compareTo(list.get(begin)) <= 0 && i < j)
				i++;
			while (j > begin && list.get(j).compareTo(list.get(begin)) >= 0 && i < j)
				j--;
			if (i < j) {
				swap(i++, j--);
			}
		}
		if (list.get(i).compareTo(list.get(begin)) < 0)
			mid = i;
		else
			mid = i - 1;
		swap(begin, mid);
		if (begin < mid - 1)
			sort(begin, mid);
		if (mid < end - 2)
			sort(mid + 1, end);
	}

}
