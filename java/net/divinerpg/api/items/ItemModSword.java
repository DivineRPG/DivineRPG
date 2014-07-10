package net.divinerpg.api.items;

import java.util.List;

import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
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

    public ItemModSword(ToolMaterial toolMaterial, String name) {
        super(toolMaterial);
        this.name = name;
        this.textureName = Reference.PREFIX + name;
        setUnlocalizedName(name);
        setTextureName(textureName);
        setCreativeTab(DivineRPGTabs.swords);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (canUseSpecialEffect()) this.useSpecialEffect(world, player);
        return super.onItemRightClick(stack, world, player);
    }
    
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (canUseSpecialEffect()) this.useSpecialEffect(player.worldObj, player);
        return false;
    }

    @Override
    public boolean isItemTool(ItemStack par1ItemStack) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
        addAdditionalInformation(infoList);
        if (item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        else infoList.add(Util.GREEN + "Infinite Uses");
        infoList.add(ChatFormats.DIVINERPG);
    }
    
    protected boolean canUseSpecialEffect() { return false; }
    protected void useSpecialEffect(World world, EntityPlayer player) {}
    protected void addAdditionalInformation(List list) {}

}
