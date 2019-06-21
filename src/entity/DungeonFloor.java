package entity;

import java.awt.image.BufferedImage;

public class DungeonFloor extends AbstractDungeonEntity {
	
	public DungeonFloor(int x, int y, BufferedImage img) {
		super(x, y, false, img);
		super.groups.add("wall");
	}
}
