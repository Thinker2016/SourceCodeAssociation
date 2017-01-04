package enumeration;

import static org.junit.Assert.*;

import java.util.Iterator;

import enumeration.EnumerationQueue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnumerationQueueTest {

	private EnumerationQueue<Double> queue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Test started.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Test finished.");
	}

	@Before
	public void setUp() throws Exception {
		queue = new EnumerationQueue<>();
		for (double d = 0; d < 0x10; d++)
			queue.offer(d);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		if (queue.size() != 0x10)
			fail();
	}

	@Test
	public void testIsEmpty() {
		if (queue.isEmpty())
			fail();
		queue.clear();
		if (!queue.isEmpty())
			fail();
	}

	@Test
	public void testContains() {
		if (queue.contains(0xFF))
			fail();
		if (!queue.contains(0xD + .0))
			fail();
	}

	@Test
	public void testIterator() {
		Iterator<Double> itr = queue.iterator();
		int i = 0;
		while (itr.hasNext()) {
			if (itr.next() != i++)
				fail();
		}
		if (i != 0x10)
			fail();
	}

	@Test
	public void testOffer() {
		queue.offer(new Double(0x1E));
		if (queue.size() != 0x11)
			fail();
	}

	@Test
	public void testPoll() {
		int i = 0;
		while (i < 0x10)
			if (queue.poll() != i++ || queue.size() != 0x10 - i)
				fail();
	}

	@Test
	public void testElement() {
		if (queue.element() != 0x0 || queue.size() != 0x10)
			fail();
	}

	@Test
	public void testPeek() {
		if (queue.peek() != 0x0 || queue.size() != 0x10)
			fail();
		queue.clear();
		if (queue.peek() != null)
			fail();
	}

	@Test
	public void testEnumerationQueue() {
		int i = 0;
		while (i < 0x10)
			if (queue.poll() != i++)
				fail();
	}

}
