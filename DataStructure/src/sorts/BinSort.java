package sorts;

import java.util.*;

public class BinSort<E extends Comparable<E>> extends AbstractSort<E> {

	public BinSort(ArrayList<E> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		sort(0, getList().size());
	}

	private void sort(int begin, int end) {
		ArrayList<E> list = getList();
		if (begin >= end - 1)
			return;
		else if (begin == end - 2) {
			if (list.get(begin).compareTo(list.get(end - 1)) > 0)
				swap(begin, end - 1);
		} else {
			int mid = (begin + end) / 2;
			sort(begin, mid);
			sort(mid, end);
			merge(begin, mid, mid, end);
		}
	}

	private void merge(int firstBegin, int firstEnd, int secondBegin, int secondEnd) {
		ArrayList<E> list = getList(), tempList = new ArrayList<>(list.size());
		int i = firstBegin, j = secondBegin;
		while (true) {
			while (i < firstEnd && list.get(i).compareTo(list.get(j)) <= 0)
				tempList.add(list.get(i++));
			if (i >= firstEnd) {
				while (j < secondEnd)
					tempList.add(list.get(j++));
				break;
			}
			while (j < secondEnd && list.get(i).compareTo(list.get(j)) > 0)
				tempList.add(list.get(j++));
			if (j >= secondEnd) {
				while (i < firstEnd)
					tempList.add(list.get(i++));
				break;
			}
		}
		for (i = firstBegin; i < secondEnd; i++)
			list.set(i, tempList.get(i - firstBegin));
	}

}
