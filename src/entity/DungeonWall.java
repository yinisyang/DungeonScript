package entity;

import java.awt.image.BufferedImage;

public class DungeonWall extends AbstractDungeonEntity {

	public DungeonWall(int x, int y, BufferedImage img) {
		super(x, y, true, img);
		super.groups.add("floor");
	}
}
