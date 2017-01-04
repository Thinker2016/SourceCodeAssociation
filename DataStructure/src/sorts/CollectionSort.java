package sorts;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionSort<E extends Comparable<E>> extends AbstractSort<E> {

	public CollectionSort(ArrayList<E> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		Collections.sort(getList());
	}

}
