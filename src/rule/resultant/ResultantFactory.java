package rule.resultant;

import main.EntityStore;

public class ResultantFactory {
	
	private static final String move_r = "MOVE \\w+ (UP|DOWN|LEFT|RIGHT) \\d+";
	private static final String move_absolute_r = "MOVE \\w+ TO \\d+,\\d+";
	
	public static Resultant buildResultant(String resultant) throws UnsupportedOperationException {
		
		if(resultant.matches(move_r)) {
			return buildMoveEntityResultant(resultant, false);
		} else if (resultant.matches(move_absolute_r)) {
			return buildMoveEntityResultant(resultant, true);
		}
		
		throw new UnsupportedOperationException();
	}
	
	private static MoveEntityResultant buildMoveEntityResultant(String resultant, boolean absolutePosition) {
		String[] temp = resultant.split("\\s+");
		String group = temp[1].trim();
		Integer x, y;
		
		if (absolutePosition) {
			x = Integer.parseInt(temp[3]);
			y = Integer.parseInt(temp[4]);
		} else {
			String dir = temp[2].trim();
			Integer amount = Integer.parseInt(temp[3].trim());
			switch(dir) {
				case "UP": y = -amount; x = 0; break;
				case "DOWN": y = amount; x = 0; break;
				case "LEFT": y = 0; x = -amount; break;
				default: y = 0; x = amount; break;
			}
		}
		
		return new MoveEntityResultant(EntityStore.getGroup(group), x, y, absolutePosition);
	}
}
