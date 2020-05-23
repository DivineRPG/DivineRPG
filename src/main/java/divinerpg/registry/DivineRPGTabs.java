package divinerpg.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DivineRPGTabs {

	public static final CreativeTabs BlocksTab = new CreativeTabs("divinerpg_blocks") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(BlockRegistry.edenOre);
		}
	};
	public static final CreativeTabs ranged = new CreativeTabs("divinerpg_ranged_weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(WeaponRegistry.vileStorm);
		}
	};
	public static final CreativeTabs swords = new CreativeTabs("divinerpg_melee_weapons") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(WeaponRegistry.aquaton);
		}
	};
	public static final CreativeTabs tools = new CreativeTabs("divinerpg_tools") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ToolRegistry.rupeeShickaxe);
		}
	};
	public static final CreativeTabs items = new CreativeTabs("divinerpg_materials") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.rupeeIngot);
		}
	};
	public static final CreativeTabs armor = new CreativeTabs("divinerpg_armor") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ArmorRegistry.divineHelmet);
		}
	};
	public static final CreativeTabs spawner = new CreativeTabs("divinerpg_boss_spawners") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.callOfTheWatcher);
		}
	};
	public static final CreativeTabs utility = new CreativeTabs("divinerpg_utility") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.snowGlobe);
		}
	};
	public static final CreativeTabs food = new CreativeTabs("divinerpg_food_and_agriculture") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.bacon);
		}
	};
	public static final CreativeTabs vethea = new CreativeTabs("divinerpg_vethea") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.dreamCake);
		}
	};

}