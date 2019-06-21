package rule.predicate;

public class PredicateFactory {
	
	private static final String key_r = "Key\\.([a-zA-Z])";
	
	public static Predicate buildPredicate(String pred) throws UnsupportedOperationException {
		if(pred.matches(key_r)) {
			return buildKeyboardPredicate(pred);
		}
		
		throw new UnsupportedOperationException();
	}
	
	private static KeyboardPredicate buildKeyboardPredicate(String pred) {
		Character key = pred.split("\\.")[1].toLowerCase().charAt(0);
		return new KeyboardPredicate(key);
	}
}
