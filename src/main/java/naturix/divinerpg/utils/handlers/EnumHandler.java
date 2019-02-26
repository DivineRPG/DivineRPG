package naturix.divinerpg.utils.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	
	public static enum OreType implements IStringSerializable {
		OVERWORLD(0, "overworld"),
		NETHER(1, "nether"),
		END(2, "end");

		private static final OreType[] META_LOOKUP = new OreType[values().length];
		private final int meta;
		private final String name, unlocializedName;

		private OreType(int meta, String name)
		{
			this(meta, name, name);
		}

		private OreType(int meta, String name, String unlocializedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}

		@Override
		public String getName()
		{
			return this.name;
		}

		public int getMeta()
		{
			return this.meta;
		}

		public String getUnlocializedName()
		{
			return this.unlocializedName;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static OreType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static
		{
			for(OreType enumtype : values())
			{
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
	//
	public static enum XMasColorType implements IStringSerializable {
		RED("red", 0),
		YELLOW("yellow", 1),
		GREEN("green", 2),
		BLUE("blue", 3),
		PINK("pink", 4);

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
}
