package main;
import java.util.ArrayList;

import entity.AbstractDungeonEntity;

public class EntityStore {
	private static ArrayList<AbstractDungeonEntity> entities = new ArrayList<>();
	
	public static ArrayList<AbstractDungeonEntity> getGroup(String group) {
		ArrayList<AbstractDungeonEntity> toReturn = new ArrayList<>();
		
		for(AbstractDungeonEntity entity: entities) {
			if (entity.isInGroup(group)) {
				toReturn.add(entity);
			}
		}
		
		return toReturn;
	}
	
	public static void registerEntity(AbstractDungeonEntity entity) {
		entities.add(entity);
	}
}
