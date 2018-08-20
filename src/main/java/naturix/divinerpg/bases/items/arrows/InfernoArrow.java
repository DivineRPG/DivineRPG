package naturix.divinerpg.bases.items.arrows;

import naturix.divinerpg.DivineRPG;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InfernoArrow extends ItemArrow {
    //private ECustomArrow arrow;
    private String name;
	public InfernoArrow(String name) {
        this.setCreativeTab(DivineRPG.CombatTab);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        //RegisterItems.ITEMS.add(this);
        this.name = name;
        this.registerItemModel(this);
    }
	public void registerItemModel(Item item) {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(worldIn, shooter);
        entitytippedarrow.setPotionEffect(stack);
        return entitytippedarrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == InfernoArrow.class;
    }
}