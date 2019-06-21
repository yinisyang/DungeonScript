package entity;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDungeonEntity {
	
	private int x, y;
	private boolean solid;
	private BufferedImage img;
	protected Set<String> groups;
	
	public AbstractDungeonEntity(int x, int y, boolean solid, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.solid = solid;
		this.img = img;
		this.groups = new HashSet<>();
	}
	
	public boolean isInGroup(String group) {
		return this.groups.contains(group);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
