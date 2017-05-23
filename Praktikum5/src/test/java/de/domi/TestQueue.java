package de.domi;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestQueue {
	@Test
	public void testEnqueue(){
		try{
		Queue tmp = new Queue(3);
		tmp.enqueue(1);
		tmp.enqueue(2);
		tmp.enqueue(3);
		tmp.enqueue(4);
		assertEquals(tmp.queue[2],4);
		tmp.dequeue();
		tmp.enqueue(5);
		assertEquals(tmp.queue[0],5);
		Queue tmp1 = new Queue(0);
		fail("Exception mit Konstruktor aufruf kleiner 1 nicht geworfen");
		}catch(IllegalArgumentException e){
			
		}		
	}
	@Test
	public void testDequeue(){
		Queue tmp = new Queue(3);
		try{
		tmp.dequeue();
		fail("erwartete Ausnahme wurde nicht geworfen");
		}catch(IllegalStateException e){
			
		}
	}
}
