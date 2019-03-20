package naturix.divinerpg.registry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DRPGCreativeTabs extends CreativeTabs {

	public static final CreativeTabs BlocksTab = new CreativeTabs("Blocks") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModBlocks.edenOre);
		}
	};
	public static DRPGCreativeTabs ranged = new DRPGCreativeTabs("Ranged", "Ranged Weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.vileStorm);
		}
	};
	public static DRPGCreativeTabs swords = new DRPGCreativeTabs("Swords", "Melee Weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.aquaton);
		}
	};
	public static DRPGCreativeTabs tools = new DRPGCreativeTabs("Tools") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.rupeeShickaxe);
		}
	};
	public static DRPGCreativeTabs items = new DRPGCreativeTabs("Materials", "Raw Materials") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.rupeeIngot);
		}
	};
	public static DRPGCreativeTabs armor = new DRPGCreativeTabs("Armor") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.divineHelmet);
		}
	};
	public static DRPGCreativeTabs spawner = new DRPGCreativeTabs("Spawner") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.callOfTheWatcher);
		}
	};
	public static DRPGCreativeTabs utility = new DRPGCreativeTabs("Utility") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.snowGlobe);
		}
	};
	public static DRPGCreativeTabs food = new DRPGCreativeTabs("Herbalism") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.bacon);
		}
	};
	public static DRPGCreativeTabs vethea = new DRPGCreativeTabs("Vethea") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.karosStaff);
		}
	};

	public static void init() {
	}

	private Item icon;

	private String name;

	public DRPGCreativeTabs(String lable) {
		this(lable, lable);
	}

	public DRPGCreativeTabs(String lable, String name) {
		super(getNextID(), lable);

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