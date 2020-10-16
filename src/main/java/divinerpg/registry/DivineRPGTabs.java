package divinerpg.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DivineRPGTabs {

	public static final CreativeTabs BLOCKS = new CreativeTabs("divinerpg_blocks") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(BlockRegistry.edenOre);
		}
	};
	public static final CreativeTabs RANGED_WEAPONS = new CreativeTabs("divinerpg_ranged_weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(WeaponRegistry.vileStorm);
		}
	};
	public static final CreativeTabs MELEE_WEAPONS = new CreativeTabs("divinerpg_melee_weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(WeaponRegistry.aquaton);
		}
	};
	public static final CreativeTabs TOOLS = new CreativeTabs("divinerpg_tools") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ToolRegistry.rupeeShickaxe);
		}
	};
	public static final CreativeTabs MATERIALS = new CreativeTabs("divinerpg_materials") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.rupeeIngot);
		}
	};
	public static final CreativeTabs ARMOR = new CreativeTabs("divinerpg_armor") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ArmorRegistry.divineHelmet);
		}
	};
	public static final CreativeTabs BOSS_SPAWNERS = new CreativeTabs("divinerpg_boss_spawners") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.callOfTheWatcher);
		}
	};
	public static final CreativeTabs UTILITY = new CreativeTabs("divinerpg_utility") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.snowGlobe);
		}
	};
	public static final CreativeTabs FOOD_AND_AGRICULTURE = new CreativeTabs("divinerpg_food_and_agriculture") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.bacon);
		}
	};
	public static final CreativeTabs VETHEA = new CreativeTabs("divinerpg_vethea") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.dreamCake);
		}
	};

}