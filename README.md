![enum-helper Logo](/logo.png) # enum-helpers

Java enums are vary useful but because they can not be sub-classed it can be hard to avoid repetitive code. This project is a set of helper classes that can be added to enums using a composite pattern to share common code.

Finding enums based on a key is a common use case. Here is a simple example using enum-helpers.
```
import lazyeye.enumHelpers.finder.EnumFinderKey;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringEnumFinders;

public enum CompassPoint {
   NORTH("n"),
   EAST("e"),
   SOUTH("s"),
   WEST("w"),
   UNKNOWN(null);

   @EnumFinderKey("id")
   public final String id;

   CompassPoint(String id_) {
      id = id_;
   }

        
   private static StringEnumFinder<CompassPoint> finder = 
        StringEnumFinders.fromAnnotatedKeyMatchEquals(CompassPoint.class, "id");
        
   public static CompassPoint find(String input){
      return finder.find(input);
   }
        
}
```
Here's a little more interesting example.
```
import lazyeye.enumHelpers.finder.EnumFinderKey;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringEnumFinders;

public enum RegexCompassPoint {
   NORTH("(?i:n|north)"),
   EAST("(?i:e|east)"),
   SOUTH("(?i:s|south)"),
   WEST("(?i:w|west)"), 
   UNKNOWN(null);

   @EnumFinderKey("regex")
   public final String regex;

   RegexCompassPoint(String r) {
      regex = r;
   }

   private static StringEnumFinder<RegexCompassPoint> helper = 
        StringEnumFinders.fromAnnotatedKeyMatchRegex(RegexCompassPoint.class,"regex");

   public static RegexCompassPoint find(String s) {
      return helper.find(s, UNKNOWN);
   }
}
```
Here's an example using the core api's.
Three things to notice:
 1. The id type is different from the type used to find with.
 2. An anonymous inner class is used to to define the matching strategy used.
 3. An anonymous inner class is used to find the id value instead of an annotation.
 ```
 import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinderComposite;
import lazyeye.enumHelpers.finder.core.KeyMatcher;
import lazyeye.enumHelpers.finder.IntegerKeyProvider;

public enum Weekday {
        
        UNKNOWN(null),
        SUNDAY(1),
        MONDAY(2),
        TUESDAY(3),
        WEDNESDAY(4),
        THURSDAY(5),
        FRIDAY(6),
        SATURDAY(7);
        
        public final Integer id;
        
        Weekday(Integer id_){
                id = id_;
        }
        
        private static EnumFinder<Weekday, Date> finder = new EnumFinderComposite<Weekday, Date, Integer>(
                        Weekday.class, new KeyMatcher<Date, Integer>() {

                                public boolean matches(Date input, Integer key) {
                                        if (input != null && key != null) {
                                                GregorianCalendar calendar = new GregorianCalendar();
                                                calendar.setTime(input);
                                                return calendar.get(Calendar.DAY_OF_WEEK) == key.intValue();
                                        }
                                        return false;
                                }
                        }, new IntegerKeyProvider<Weekday>() {

                                public Integer key(Weekday enum1) {
                                        return enum1.id;
                                }
                        });
        
        public static Weekday find(Date d){
                return finder.find(d, UNKNOWN);
        }
}
 ```
