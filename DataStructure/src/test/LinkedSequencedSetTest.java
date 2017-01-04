package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sets.LinkedSequencedSet;

public class LinkedSequencedSetTest {

	private LinkedSequencedSet<Integer> set;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("测试开始。");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("测试结束。");
	}

	@Before
	public void setUp() throws Exception {
		set = new LinkedSequencedSet<>();
		Random r = new Random(0xF);
		for (int i = 0; i < 0x100; i++)
			set.add(Math.abs(r.nextInt()) % 0xE);
	}

	@After
	public void tearDown() throws Exception {
		set = null;
	}

	@Test
	public void testSize() {
		if (set.size() != 0xE)
			fail();
	}

	@Test
	public void testIsEmpty() {
		if (set.isEmpty())
			fail();
		set.clear();
		if (!set.isEmpty())
			fail();
	}

	@Test
	public void testContains() {
		if (set.contains(0x11))
			fail();
		if (!set.contains(0xC))
			fail();
	}

	@Test
	public void testIterator() {
		Iterator<Integer> itr = set.iterator();
		for (int i = 0; i < 0xE; i++)
			if (itr.next() != i)
				fail();
	}

	@Test
	public void testToArray() {
		Object[] arr = set.toArray();
		int i = 0;
		for (Object elem : arr) {
			if ((int) elem != i++)
				fail();
		}
	}

	@Test
	public void testToArrayTArray() {
		Integer[] arr = new Integer[0];
		arr = set.toArray(arr);
		int i = 0;
		for (int elem : arr) {
			if (elem != i++)
				fail();
		}
	}

	@Test
	public void testAdd() {
		set.add(0xDEF);
		System.out.println(set);
	}

	@Test
	public void testRemove() {
		set.remove(0x8);
		if (set.contains(0x8))
			fail();
	}

	@Test
	public void testContainsAll() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 0xD; i++)
			list.add(i);
		if (!set.containsAll(list))
			fail();
		for (int i = 0x1000; i < 0x1002; i++)
			list.add(i);
		if (set.containsAll(list))
			fail();
	}

	@Test
	public void testAddAll() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0xC; i < 0x1F; i++)
			list.add(i);
		set.addAll(list);
		System.out.println(set);
	}

	@Test
	public void testRetainAll() {
		ArrayList<Double> list = new ArrayList<>();
		for (int i = 0; i < 0xE; i++)
			list.add(new Double(i));
		set.retainAll(list);
		System.out.println(set);
	}

	@Test
	public void testRemoveAll() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 0xE; i++)
			list.add(i);
		set.removeAll(list);
		System.out.println(set);
	}

	@Test
	public void testClear() {
		set.clear();
		System.out.println(set);
	}

	@Test
	public void testToString() {
		System.out.println(set);
	}

	@Test
	public void testLinkedSequencedSet() {
		if (set.size() != 0xE)
			fail();
	}

}
