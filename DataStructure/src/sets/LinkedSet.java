package sets;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LinkedSet<E> implements Set<E> {

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

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return list.listIterator();
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
		if (list.contains(e))
			return false;
		else {
			list.add(e);
			return true;
		}
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return list.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return list.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return list.removeAll(c);
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

	public LinkedSet() {
		list = new LinkedList<>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedSet<Double> set = new LinkedSet<>();
		Random r = new Random(0xD);
		for (int i = 0; i < 0x1F; i++)
			set.add(r.nextDouble());
		System.out.println(set);
		TreeSet<Double> treeSet = new TreeSet<Double>();
		treeSet.addAll(set);
		System.out.println(treeSet);
	}

}
