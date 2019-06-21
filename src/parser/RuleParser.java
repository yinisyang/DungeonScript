package parser;

import java.util.ArrayList;

import rule.Rule;
import rule.predicate.Predicate;
import rule.predicate.PredicateFactory;
import rule.resultant.Resultant;
import rule.resultant.ResultantFactory;

public class RuleParser {
	
	private ArrayList<String> ruleStrings;
	
	public RuleParser(ArrayList<String> ruleStrings) {
		this.ruleStrings = ruleStrings;
	}
	
	public ArrayList<Rule> parse() throws IllegalArgumentException {
		ArrayList<Rule> rules = new ArrayList<>();
		
		for(String rule: this.ruleStrings) {
			if (!rule.contains(" => ")) {
				throw new IllegalArgumentException("Rule must contain separator '=>'");
			}
			
			String pred = rule.split("=>")[0].trim();
			String result = rule.split("=>")[1].trim();
			
			Predicate p = PredicateFactory.buildPredicate(pred);
			Resultant r = ResultantFactory.buildResultant(result);
			
			rules.add(new Rule(p, r));
		}
		
		return rules;
	}
}
