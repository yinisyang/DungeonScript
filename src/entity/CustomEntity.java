package entity;

import java.awt.image.BufferedImage;
import java.util.Set;

public class CustomEntity extends AbstractDungeonEntity {
	
	public CustomEntity(int x, int y, boolean solid, BufferedImage img, Set<String> groups) {
		super(x, y, solid ,img);
		super.groups.addAll(groups);
	}
}
