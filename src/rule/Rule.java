package rule;

import rule.predicate.Predicate;
import rule.resultant.Resultant;

public class Rule {
	
	private Predicate predicate;
	private Resultant resultant;
	
	public Rule(Predicate predicate, Resultant resultant) {
		this.predicate = predicate;
		this.resultant = resultant;
	}
	
	public void apply() {
		if(this.predicate.isTrue()) {
			this.resultant.enact();
		}
	}
}
