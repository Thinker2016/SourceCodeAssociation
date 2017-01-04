package enumeration;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class EnumerationImpl<E> implements Enumeration<E> {

	private ListIterator<E> listIterator;

	@Override
	public boolean hasMoreElements() {
		// TODO Auto-generated method stub
		return listIterator.hasNext();
	}

	@Override
	public E nextElement() {
		// TODO Auto-generated method stub
		return listIterator.next();
	}

	public EnumerationImpl(LinkedList<E> list) {
		this.listIterator = list.listIterator();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Double> list = new LinkedList<>();
		for (double d = 0; d < 0x1F; d++) {
			list.add(d);
		}
		EnumerationImpl<Double> ei = new EnumerationImpl<>(list);
		while (ei.hasMoreElements())
			System.out.printf("%.0f ", ei.nextElement());

		System.out.print('\n');

		StringTokenizer stringToken = new StringTokenizer("Computers are computing machines.");
		while (stringToken.hasMoreTokens())
			System.out.println(stringToken.nextToken());
	}

}
