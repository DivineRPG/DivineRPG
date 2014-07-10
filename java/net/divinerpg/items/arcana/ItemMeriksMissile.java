package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.entities.arcana.projectile.EntityMerikMissile;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
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
        super(name, uses, damage, DEFAULT_MAX_USE_DURACTION, null, null);
        this.arcana = arcana;
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
		if(var1.getItem() == ArcanaItems.meriksMissile){
			if(var3.capabilities.isCreativeMode || var3.inventory.hasItem(ArcanaItems.meriksMissile)) {
				var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
			}
		}
		return var1;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
		if(par1ItemStack.getItem() == ArcanaItems.meriksMissile){
			int var6 = this.getMaxItemUseDuration(par1ItemStack) - par4;
			boolean var5 = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
			if(ArcanaHelper.useBar(arcana)) {
				float var7 = (float)var6 / 20.0F;
				var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
				if ((double)var7 < 0.1D) return;
				if (var7 > 1.0F) var7 = 1.0F;
				EntityMerikMissile var8 = new EntityMerikMissile(par2World, par3EntityPlayer, 0.6F, 300);
				int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
				if (var9 > 0) var8.setDamage((int) ((var7 * (double)var9 * 0.5D + 0.5D) * 2));
				par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
				if (!par2World.isRemote)  par2World.spawnEntityInWorld(var8);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Explosive homing projectile");
		par3List.add("Uses " + arcana + " arcana");
		par3List.add("Unlimited uses");
		par3List.add(ChatFormats.DIVINERPG);
	}
}