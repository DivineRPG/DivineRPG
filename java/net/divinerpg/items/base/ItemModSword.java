package net.divinerpg.items.base;

import java.util.List;

import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModSword extends ItemSword {

    protected String name;
    protected String textureName;
    protected ToolMaterial mat;

    public ItemModSword(ToolMaterial toolMaterial, String name) {
        super(toolMaterial);
        this.name = name;
        this.textureName = Reference.PREFIX + name;
        setUnlocalizedName(name);
        setTextureName(textureName);
        setCreativeTab(DivineRPGTabs.swords);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
        this.mat = toolMaterial;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (canUseSpecialEffect(player)) this.useSpecialEffect(world, player);
        return super.onItemRightClick(stack, world, player);
    }
    
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (canUseSpecialEffect(player)) this.useSpecialEffect(player.worldObj, player);
        return false;
    }

    @Override
    public boolean isItemTool(ItemStack par1ItemStack) {
        return true;
    }
    
    @Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if(stack.getItem() == VanillaItemsWeapons.divineSword) player.triggerAchievement(DivineRPGAchievements.divinePlan);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
    	if((int)this.mat.getDamageVsEntity() == this.mat.getDamageVsEntity())infoList.add((int)this.mat.getDamageVsEntity()+4 + " Melee Damage");
    	else infoList.add(this.mat.getDamageVsEntity()+4 + " Melee Damage");
        addAdditionalInformation(infoList);
        if (item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        else infoList.add(Util.GREEN + "Infinite Uses");
    }
    
    protected boolean canUseSpecialEffect(EntityPlayer player) { return false; }
    protected void useSpecialEffect(World world, EntityPlayer player) {}
    protected void addAdditionalInformation(List list) {}

}
