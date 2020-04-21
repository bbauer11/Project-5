import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTestStudent {

	LinkedConverterTreeInterface<String> tree1;
	
	
	@Before
	public void setUp() throws Exception {
		tree1 = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree1 = null;
	}

	@Test
	public void testInsertAndAdd() {
		assertTrue(tree1.fetch("..--") == null);
		tree1.addNode(tree1.getRoot(), "..--", "test");
		assertTrue(tree1.fetch("..--").equals("test"));
	}
	
	@Test
	public void testFetchAndFetchNode() {
		assertTrue(tree1.fetch("--").equals("m"));
		assertTrue(tree1.fetch("..-").equals("u"));
	}
	
	@Test
	public void testDeleteAndUpdate() {
		try {
			tree1.delete("b");
			assertTrue("Did not throw UnsupportedOperationException.", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw UnsupportedOperationException.", true); 
		} catch (Exception e) {
			assertTrue("Threw a different exception.", false);
		}
		
		try {
			tree1.update();
			assertTrue("Did not throw UnsupportedOperationException.", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw UnsupportedOperationException.", true); 
		} catch (Exception e) {
			assertTrue("Threw a different exception.", false);
		}
	}
	
	

}
