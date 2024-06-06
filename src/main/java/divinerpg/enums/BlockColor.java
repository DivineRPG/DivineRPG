package divinerpg.enums;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public enum BlockColor implements StringRepresentable {
    BLUE("blue"),
    GREEN("green"),
	PINK("pink"),
    PURPLE("purple"),
    RED("red"),
    YELLOW("yellow"),
    WHITE("white");
	public static final EnumProperty<BlockColor> COLOR = EnumProperty.create("color", BlockColor.class);
	private final String name;
	BlockColor(String name) {this.name = name;}
	@Override public String toString() {return this.getSerializedName();}
    @Override public String getSerializedName() {return this.name;}
}