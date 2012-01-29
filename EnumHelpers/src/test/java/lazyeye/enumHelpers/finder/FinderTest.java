package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.example.CompassPoint2;

import org.junit.Assert;
import org.junit.Test;


public class FinderTest {

	@Test
	public void equalsTest(){
		Assert.assertTrue(CompassPoint2.find("e") == CompassPoint2.EAST);
		Assert.assertTrue(CompassPoint2.find("s") == CompassPoint2.SOUTH);
		Assert.assertTrue(CompassPoint2.find("w") == CompassPoint2.WEST);
		Assert.assertTrue(CompassPoint2.find("n") == CompassPoint2.NORTH);
		Assert.assertTrue(CompassPoint2.find("zzz") == null);
		Assert.assertTrue(CompassPoint2.find(null) == null);

	}
	
	
}
