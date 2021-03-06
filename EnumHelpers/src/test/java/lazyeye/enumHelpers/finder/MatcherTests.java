package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.KeyMatcher;
import lazyeye.enumHelpers.finder.core.KeyProvider;
import lazyeye.enumHelpers.finder.matchers.AndMatcher;
import lazyeye.enumHelpers.finder.matchers.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.OrMatcher;
import lazyeye.enumHelpers.finder.matchers.PostfixMatcher;
import lazyeye.enumHelpers.finder.matchers.PrefixMatcher;
import lazyeye.enumHelpers.finder.matchers.RegexMatcher;
import lazyeye.enumHelpers.finder.matchers.ToUpperMatcherFilter;

import org.junit.Assert;
import org.junit.Test;


public class MatcherTests {

	@Test
	public void equalsTest(){
		KeyMatcher<String, String> matcher = new EqualsMatcher<String, String>();	
		Assert.assertTrue(matcher.matches("1", "1"));
		Assert.assertTrue(matcher.matches(null, null));
		Assert.assertFalse(matcher.matches("1", null));
		Assert.assertFalse(matcher.matches(null, "1"));
	}
	
	@Test
	public void equalsIgnoreTest(){
		KeyMatcher<String, String> matcher = new EqualsIgnoreCaseMatcher();
		Assert.assertTrue(matcher.matches("a", "a"));
		Assert.assertTrue(matcher.matches("A", "a"));
		Assert.assertTrue(matcher.matches("a", "A"));
		Assert.assertTrue(matcher.matches(null, null));
		Assert.assertFalse(matcher.matches("a", null));
		Assert.assertFalse(matcher.matches(null, "a"));
	}
	
	@Test
	public void prefixTest(){
		KeyMatcher<String, String> matcher = new PrefixMatcher();
		Assert.assertTrue(matcher.matches("a123", "a"));
		Assert.assertFalse(matcher.matches("a123", null));
		Assert.assertFalse(matcher.matches(null, null));
		Assert.assertFalse(matcher.matches(null, "a"));
		Assert.assertFalse(matcher.matches("a123", "b"));
		Assert.assertFalse(matcher.matches("a123", "A"));
	}
	
	@Test
	public void postfixTest(){
		KeyMatcher<String, String> matcher = new PostfixMatcher();
		Assert.assertTrue(matcher.matches("123a", "a"));
		Assert.assertFalse(matcher.matches("123a", null));
		Assert.assertFalse(matcher.matches(null, null));
		Assert.assertFalse(matcher.matches(null, "a"));
		Assert.assertFalse(matcher.matches("123a", "b"));
	}
	
	@Test
	public void filterTest(){
		KeyMatcher<String, String> m = new EqualsMatcher<String, String>();
		KeyMatcher<String, String> matcher = new ToUpperMatcherFilter<String>(m);
		Assert.assertTrue(matcher.matches("a", "A"));
		Assert.assertTrue(matcher.matches(null, null));
		Assert.assertTrue(matcher.matches("A", "A"));
		Assert.assertFalse(matcher.matches("A", "a"));
	}

	@Test
	public void orTest(){
		KeyMatcher<String, String> m1 = new EqualsMatcher<String, String>();
		KeyMatcher<String, String> m2 = new ToUpperMatcherFilter<String>(m1);
		KeyMatcher<String, String> matcher = new OrMatcher<String, String>(m1,m2);		
		Assert.assertTrue(matcher.matches("a", "A"));
		Assert.assertTrue(matcher.matches(null, null));
		Assert.assertTrue(matcher.matches("A", "A"));
		Assert.assertFalse(matcher.matches("A", "a"));
		Assert.assertFalse(matcher.matches(null, "a"));
	}
	
	@Test
	public void andTest(){
		KeyMatcher<String, String> m1 = new PrefixMatcher();
		KeyMatcher<String, String> m2 = new PostfixMatcher();
		KeyMatcher<String, String> matcher = new AndMatcher<String, String>(m1,m2);	
		Assert.assertTrue(matcher.matches("a123a", "a"));
		Assert.assertFalse(matcher.matches("a123b", "a"));
		
	}
	
	public enum TestEnum{
		TRUE("[tT]rue"),FALSE("[fF]alse"),UNKNOWN(null);
		
		final String id;
		
		TestEnum(String s){
			id = s;
		}

	}

	@Test
	public void regexTest() {
		RegexMatcher<TestEnum> matcher = new RegexMatcher<TestEnum>(
				TestEnum.class, new KeyProvider<TestEnum, String>() {
					public String key(TestEnum enum1) {
						return enum1.id;
					}
				});

		Assert.assertTrue(matcher.matches("true", TestEnum.TRUE.id));
		Assert.assertTrue(matcher.matches("True", TestEnum.TRUE.id));
		Assert.assertFalse(matcher.matches("blue", TestEnum.TRUE.id));
		Assert.assertFalse(matcher.matches(null, TestEnum.TRUE.id));
		Assert.assertFalse(matcher.matches(null, null));
		Assert.assertFalse(matcher.matches("true", null));
	}

}
