package sets;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class LinkedSequencedSet<E extends Comparable<E>> implements Set<E> {

	private LinkedList<E> list;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if (o == null)
			return false;
		ListIterator<E> listItr = list.listIterator();
		E elem;
		while (listItr.hasNext())
			if ((elem = listItr.next()).equals(o))
				return true;
			else if (elem.compareTo((E) o) > 0)
				return false;
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return list.toArray(a);
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		ListIterator<E> listItr = list.listIterator();
		if (e == null)
			return false;
		while (listItr.hasNext()) {
			E element = listItr.next();
			if (e.compareTo(element) == 0)
				return false;
			else if (e.compareTo(element) < 0) {
				listItr.previous();
				listItr.add(e);
				return true;
			}
		}
		listItr.add(e);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if (o == null)
			return false;
		ListIterator<E> listItr = list.listIterator();
		E elem;
		while (listItr.hasNext())
			if ((elem = listItr.next()).equals(o)) {
				listItr.remove();
				return true;
			} else if (elem.compareTo((E) o) > 0)
				return false;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		if (c == null)
			return false;
		for (Object elem : c)
			if (!contains(elem))
				return false;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (E e : c) {
			if (add(e))
				flag = true;
		}
		return flag;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		if (c == null)
			return false;
		ListIterator<E> listItr = list.listIterator();
		boolean flag = false;
		while (listItr.hasNext()) {
			if (!c.contains(listItr.next())) {
				listItr.remove();
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (Object elem : c) {
			if (this.contains(elem)) {
				remove(elem);
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public String toString() {
		return list.toString();
	}

	public LinkedSequencedSet() {
		list = new LinkedList<>();
	}

}
