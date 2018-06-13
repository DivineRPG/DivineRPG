package naturix.divinerpg.bases;

import naturix.divinerpg.DivineRPG;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CannonAmmo extends Item
{
protected String name;
	
	public CannonAmmo(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DivineRPG.CombatTab);
    }
	public void registerItemModel() {
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
        return enchant <= 0 ? false : this.getClass() == CannonAmmo.class;
    }
}