package rule.predicate;

public class KeyboardPredicate implements Predicate {

	private Character toMatch;
	
	private static Character incoming = null;
	
	public KeyboardPredicate(Character toMatch) {
		this.toMatch = toMatch;
	}
	
	public static void updateIncoming(Character incoming) {
		KeyboardPredicate.incoming = incoming;
	}
	
	public void clear() {
		updateIncoming(null);
	}
	
	@Override
	public boolean isTrue() {
		return toMatch.equals(incoming);
	}

}
