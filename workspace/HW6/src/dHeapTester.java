import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;
import java.util.*;

public class dHeapTester {
	dHeap<Integer> thisHeap = new dHeap(5);
	dHeap<Integer> thisHeap2 = new dHeap(5);
	dHeap<Integer> thisHeap3 = new dHeap(4, 20);
	dHeap<Integer> thisHeap4 = new dHeap(4, 20);
	@Before
	public void start(){
		thisHeap.add(new Integer(10));
		thisHeap3.add(new Integer(3));
		
		
	}

	@Test
	public void testConstructor(){
		assertEquals(0, thisHeap2.size());
		assertEquals(1, thisHeap.size());
	}
	@Test
	public void testConstructor2(){
		assertEquals(0, thisHeap4.size());
		assertEquals(1, thisHeap3.size());
		
	}
	@Test
	public void testSize(){
		assertEquals(1, thisHeap.size());
		assertEquals(1, thisHeap3.size());
		thisHeap.removeSmallest();
		thisHeap3.removeSmallest();
		assertEquals(0, thisHeap.size());
		assertEquals(0, thisHeap3.size());
	}
	@Test
	public void testAdd(){
		thisHeap.add(new Integer(11));
		thisHeap3.add(new Integer(4));
		thisHeap.add(new Integer(9));
		thisHeap3.add(new Integer(2));
		assertEquals(new Integer(9), thisHeap.removeSmallest());
		assertEquals(new Integer(10), thisHeap.removeSmallest());
		assertEquals(new Integer(11), thisHeap.removeSmallest());
		assertEquals(new Integer(2), thisHeap3.removeSmallest());
		assertEquals(new Integer(3), thisHeap3.removeSmallest());
		assertEquals(new Integer(4), thisHeap3.removeSmallest());
		
		
	}
	@Test
	public void testRemoveSmallest(){
		thisHeap.add(new Integer(11));
		thisHeap3.add(new Integer(4));
		thisHeap.add(new Integer(9));
		thisHeap3.add(new Integer(2));
		thisHeap.removeSmallest();
		assertEquals(2, thisHeap.size());
		thisHeap.removeSmallest();
		assertEquals(1, thisHeap.size());
		thisHeap.removeSmallest();
		assertEquals(0, thisHeap.size());
		thisHeap3.removeSmallest();
		assertEquals(2, thisHeap3.size());
		thisHeap3.removeSmallest();
		assertEquals(1, thisHeap3.size());
		thisHeap3.removeSmallest();
		assertEquals(0, thisHeap3.size());
		
	}
	@Test
	public void testException1(){
		try{
			thisHeap2.removeSmallest();
			fail();
		}
		catch(NoSuchElementException e){
				
		}
			
		
		
	}
	@Test
	public void testException2(){
		try{
			thisHeap4.add(null);
			fail();
		}
		catch(NullPointerException e){
				
		}
			
		
	}

}
