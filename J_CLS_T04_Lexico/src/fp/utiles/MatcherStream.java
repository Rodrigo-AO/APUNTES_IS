package fp.utiles;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MatcherStream {
	private MatcherStream() {}

	  public static Stream<String> find(Pattern pattern, CharSequence input) {
	    return findMatches(pattern, input).map(MatchResult::group);
	  }

	  public static Stream<MatchResult> findMatches(
	      Pattern pattern, CharSequence input) {
	    Matcher matcher = pattern.matcher(input);

	    Spliterator<MatchResult> spliterator = new Spliterators.AbstractSpliterator<MatchResult>(
	        Long.MAX_VALUE, Spliterator.ORDERED|Spliterator.NONNULL) {
	      @Override
	      public boolean tryAdvance(Consumer<? super MatchResult> action) {
	        if(!matcher.find()) return false;
	        action.accept(matcher.toMatchResult());
	        return true;
	      }};

	    return StreamSupport.stream(spliterator, false);
	  }
}
