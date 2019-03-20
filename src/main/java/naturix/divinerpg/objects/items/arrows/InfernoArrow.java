package naturix.divinerpg.objects.items.arrows;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityInfernoArrow;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InfernoArrow extends Item {
	// private ECustomArrow arrow;
	private String name;

	public InfernoArrow(String name) {
		this.setCreativeTab(DRPGCreativeTabs.ranged);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		// RegisterItems.ITEMS.add(this);
		this.name = name;
	}

	public EntityInfernoArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
		EntityInfernoArrow entitytippedarrow = new EntityInfernoArrow(worldIn);
		return entitytippedarrow;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper
		        .getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this.getClass() == InfernoArrow.class;
	}

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}