package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.example.CompassPoint;
import lazyeye.enumHelpers.example.RegexCompassPoint;
import org.junit.Assert;
import org.junit.Test;


public class FinderTest {

	@Test
	public void equalsTest(){
		Assert.assertTrue(CompassPoint.find("e") == CompassPoint.EAST);
		Assert.assertTrue(CompassPoint.find("s") == CompassPoint.SOUTH);
		Assert.assertTrue(CompassPoint.find("w") == CompassPoint.WEST);
		Assert.assertTrue(CompassPoint.find("n") == CompassPoint.NORTH);
		Assert.assertTrue(CompassPoint.find("zzz") == null);
		Assert.assertTrue(CompassPoint.find(null) == null);
	}
	
	@Test
	public void regexTest(){
		Assert.assertTrue(RegexCompassPoint.find("e") == RegexCompassPoint.EAST);
		Assert.assertTrue(RegexCompassPoint.find("s") == RegexCompassPoint.SOUTH);
		Assert.assertTrue(RegexCompassPoint.find("w") == RegexCompassPoint.WEST);
		Assert.assertTrue(RegexCompassPoint.find("n") == RegexCompassPoint.NORTH);
		Assert.assertTrue(RegexCompassPoint.find("east") == RegexCompassPoint.EAST);
		Assert.assertTrue(RegexCompassPoint.find("south") == RegexCompassPoint.SOUTH);
		Assert.assertTrue(RegexCompassPoint.find("west") == RegexCompassPoint.WEST);
		Assert.assertTrue(RegexCompassPoint.find("north") == RegexCompassPoint.NORTH);
		Assert.assertTrue(RegexCompassPoint.find("zzz") == RegexCompassPoint.UNKNOWN);
		Assert.assertTrue(RegexCompassPoint.find(null) == RegexCompassPoint.UNKNOWN);
	}
}
