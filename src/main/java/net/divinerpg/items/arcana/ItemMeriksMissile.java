package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntityMerikMissile;
import net.divinerpg.items.base.ItemModBow;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMeriksMissile extends ItemModBow { 

	private int arcana;
	private IIcon[] texture;
	private String[] textures = {Reference.PREFIX + "meriksMissile_0", Reference.PREFIX + "meriksMissile_1", Reference.PREFIX + "meriksMissile_2", Reference.PREFIX + "meriksMissile_3"};
	
	public ItemMeriksMissile(String name, int uses, int damage, int arcana) {
        super(name, uses, damage, DEFAULT_MAX_USE_DURATION, null, null);
        this.arcana = arcana;
        this.setMaxStackSize(1);
        bowList.remove(this);
    }
	
	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon(textures[0]);
		texture = new IIcon[textures.length];
		for(int i = 0; i < textures.length; i++)
			texture[i] = par1IconRegister.registerIcon(Reference.PREFIX + "meriksMissile_" + i); 
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int icon) {
        return texture[icon];
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.none;
	}

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (player.getItemInUse() == null) return itemIcon;
        int pulling = stack.getMaxItemUseDuration() - useRemaining;
        if (pulling >= 18) return texture[3];
        if (pulling > 13) return texture[2];
        if (pulling > 0) return texture[1];
        return texture[0];
    }

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
		return var1;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int par4) {
		if(stack.getItem() == ArcanaItems.meriksMissile){
			int var6 = this.getMaxItemUseDuration(stack) - par4;
			boolean var5 = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
			if(ArcanaHelper.getProperties(player).useBar(arcana)) {
				float var7 = (float)var6 / 20.0F;
				var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
				if ((double)var7 < 0.1D) return;
				if (var7 > 1.0F) var7 = 1.0F;
				EntityMerikMissile var8 = new EntityMerikMissile(world, player);
				world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
				if (!world.isRemote)  world.spawnEntityInWorld(var8);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Explosive homing projectile");
		list.add(TooltipLocalizer.rangedDam(22));
		list.add(TooltipLocalizer.arcanaConsumed(arcana));
		list.add(TooltipLocalizer.infiniteUses());
	}
}