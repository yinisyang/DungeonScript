package rule.resultant;

import java.util.ArrayList;

import entity.AbstractDungeonEntity;

public class MoveEntityResultant implements Resultant{
	
	private ArrayList<AbstractDungeonEntity> entities;
	private boolean useAbsolutePositioning;
	private int x, y;
	
	public MoveEntityResultant(ArrayList<AbstractDungeonEntity> entities, int x, 
			int y, boolean useAbsolutePositioning) {
		this.entities = entities;
		this.x = x;
		this.y = y;
		this.useAbsolutePositioning = useAbsolutePositioning;
	}
	
	@Override
	public void enact() {
		for(AbstractDungeonEntity entity: this.entities) {
			int offsetX = 0;
			int offsetY = 0;
			if (this.useAbsolutePositioning) {
				offsetX = entity.getX();
				offsetY = entity.getY();
			}
			entity.setX(offsetX + this.x);
			entity.setY(offsetY + this.y);
		}
	}
}
