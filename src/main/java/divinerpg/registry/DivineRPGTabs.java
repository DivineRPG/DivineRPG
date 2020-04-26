package divinerpg.registry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DivineRPGTabs extends CreativeTabs {

	public static final CreativeTabs BlocksTab = new CreativeTabs("Blocks") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModBlocks.edenOre);
		}
	};
	public static DivineRPGTabs ranged = new DivineRPGTabs("Ranged", "Ranged Weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.vileStorm);
        }
	};
	public static DivineRPGTabs swords = new DivineRPGTabs("Swords", "Melee Weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.aquaton);
        }
	};
	public static DivineRPGTabs tools = new DivineRPGTabs("Tools") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.rupeeShickaxe);
        }
	};
	public static DivineRPGTabs items = new DivineRPGTabs("Materials", "Raw Materials") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.rupeeIngot);
		}
	};
	public static DivineRPGTabs armor = new DivineRPGTabs("Armor") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.divineHelmet);
		}
	};
	public static DivineRPGTabs spawner = new DivineRPGTabs("Spawner") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.callOfTheWatcher);
		}
	};
	public static DivineRPGTabs utility = new DivineRPGTabs("Utility") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.snowGlobe);
		}
	};
	public static DivineRPGTabs food = new DivineRPGTabs("Herbalism") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.bacon);
		}
	};
	public static DivineRPGTabs vethea = new DivineRPGTabs("Vethea") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() { return new ItemStack(ModItems.dreamCake); }
	};

	public static void init() {
	}

	private Item icon;

	private String name;

	public DivineRPGTabs(String label) {
		this(label, label);
	}

	public DivineRPGTabs(String label, String name) {
		super(getNextID(), label);

	}

	public String getName() {
		return name;
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(icon);
	}

	public void setIcon(Block icon) {
		this.icon = Item.getItemFromBlock(icon);
	}

	public void setIcon(Item icon) {
		this.icon = icon;
	}
}