package naturix.divinerpg.objects.items.base;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBase extends Item implements IHasModel {
	protected int healAmount = 0;
	protected String name;

	public ItemBase(String name) {
		this(name, DRPGCreativeTabs.items);
	}

	public ItemBase(String name, CreativeTabs tab) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(tab);

		ModItems.ITEMS.add(this);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (healAmount != 0 && player.getHealth() < player.getMaxHealth()) {
			ItemStack stack = new ItemStack(this.getContainerItem());
			if (!player.capabilities.isCreativeMode) {
				stack.shrink(1);
			}
			player.heal(healAmount);
		}
		return super.onItemRightClick(world, player, hand);
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

	public ItemBase setHealAmount(int healAmount) {
		this.healAmount = healAmount;
		return this;
	}
}