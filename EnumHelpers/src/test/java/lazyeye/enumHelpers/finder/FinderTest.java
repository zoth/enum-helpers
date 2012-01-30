package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.example.CompassPoint2;
import lazyeye.enumHelpers.example.RegexCompassPoint;
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
