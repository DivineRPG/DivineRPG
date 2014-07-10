package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemShadowSword extends ItemModSword {

    public ItemShadowSword(String name, ToolMaterial mat) {
        super(mat, name);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
    }

    @Override
    public boolean hitEntity(ItemStack var1, EntityLivingBase var2, EntityLivingBase var3) {
        if(ArcanaHelper.useBar(12)) {
    		var3.worldObj.playSoundAtEntity(var3, Sounds.shadowSaber.getPrefixedName(), 1.0F, 1.0F);
        	var3.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5 * 20, 1));
        }
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack i, World w, Block b, int x, int y, int z, EntityLivingBase e) {
        if(ArcanaHelper.useBar(12))
        	return true;
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	par3List.add("12 Arcana");
    	par3List.add("Speeds up player when used");
    	par3List.add(ChatFormats.DIVINERPG);
    }
}