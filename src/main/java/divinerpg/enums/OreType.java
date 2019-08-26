package divinerpg.enums;

import net.minecraft.util.IStringSerializable;

public enum OreType implements IStringSerializable {
    OVERWORLD(0, "overworld"), NETHER(1, "nether"), END(2, "end");

    private static final OreType[] META_LOOKUP = new OreType[values().length];
    private final int meta;
    private final String name, unlocializedName;

    private OreType(int meta, String name) {
        this(meta, name, name);
    }

    private OreType(int meta, String name, String unlocializedName) {
        this.meta = meta;
        this.name = name;
        this.unlocializedName = unlocializedName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getMeta() {
        return this.meta;
    }

    public String getUnlocializedName() {
        return this.unlocializedName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static OreType byMetadata(int meta) {
        return META_LOOKUP[meta];
    }

    static {
        for (OreType enumtype : values()) {
            META_LOOKUP[enumtype.getMeta()] = enumtype;
        }
    }
}
