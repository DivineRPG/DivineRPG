package divinerpg.enums;

import net.minecraft.util.IStringSerializable;

public enum XMasColorType implements IStringSerializable {
    RED("red", 0), YELLOW("yellow", 1), GREEN("green", 2), BLUE("blue", 3), PINK("pink", 4);

    private int ID;
    private String name;

    private XMasColorType(String name, int ID) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return getName();
    }
}
