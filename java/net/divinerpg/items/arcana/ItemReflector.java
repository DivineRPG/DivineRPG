package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.entities.arcana.projectile.EntityReflector;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemReflector extends ItemMod {
	
    public ItemReflector(String name) {
        super(name);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
    }
 
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
    	boolean var4 = var3.capabilities.isCreativeMode;
    	if (!var2.isRemote && ArcanaHelper.useBar(20)) {
        	var2.playSoundAtEntity(var3, Sounds.reflector.getPrefixedName(), 1.0F, 1.0F);
    		var2.spawnEntityInWorld(new EntityReflector(var2));
    	}
    	return var1;
    }
    
    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
    	return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("20 Arcana");
        par3List.add("Knocks entities away");
        par3List.add("No damage");
        par3List.add(ChatFormats.DIVINERPG);
    }
}