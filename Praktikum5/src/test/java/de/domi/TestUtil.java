package de.domi;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestUtil{
	@Test
	public void testIstErstesHalbjahr(){
		assertTrue(Util.istErstesHalbjahr(6));
		assertFalse(Util.istErstesHalbjahr(7));
	}
}
