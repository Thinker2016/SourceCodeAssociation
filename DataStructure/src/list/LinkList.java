package list;

import java.util.*;

public class LinkList<E> extends AbstractList<E> {

	private Node head;
	private int size;

	private class Node {
		E data;
		Node next;
		Node previous;
	}

	public LinkList() {
		size = 0;
		head = new Node();
		head.next = head.previous = head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList<Integer> list = new LinkList<>();
		for (int i = 0; i < 100; i++)
			list.add(i);
		System.out.println(list + "," + list.size());
		LinkedList<Integer> list_02 = new LinkedList<>();
		for (int i = 0; i < 100; i++)
			list_02.add(i);
		System.out.println(list_02 + "," + list_02.size());
		list.set(20, 2020);
		System.out.println(list + "," + list.size());
		list = new LinkList<>();
		System.out.println(list + "," + list.size());
		list.add(15);
		System.out.println(list);
	}

	@Override
	public E set(int index, E element) {
		Node node = head.next;
		for (int i = 0; i < index; i++)
			node = node.next;
		node.data = element;
		return node.data;
	}

	@Override
	public boolean add(E e) {
		Node node = new Node();
		node.data = e;
		node.next = head;
		node.previous = head.previous;
		head.previous.next = node;
		head.previous = node;
		size++;
		return true;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size)
			return null;
		Node node = head;
		for (int i = 0; i < index; i++)
			node = node.next;
		node.previous.next = node.next;
		node.next.previous = node.previous;
		size--;
		return node.data;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size)
			return null;

		Node node = head.next;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		Node node;
		for (node = head.next; node.next != head; node = node.next) {
			buffer.append(node.data.toString() + ", ");
		}
		if (node != head)
			buffer.append(node.data.toString());
		buffer.append("]");
		return buffer.toString();
	}

}
