package net.divinerpg.items.base;

import java.util.List;

import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Sound;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModRanged extends ItemMod {

    protected int weaponDamage;
    protected Sound sound;
    protected Class<? extends EntityThrowable> clazz;
    
    public ItemModRanged(String name, int maxDamage, Sound sound, Class<? extends EntityThrowable> clazz) {
        super(name, DivineRPGTabs.ranged);
        this.clazz = clazz;
        setMaxStackSize(1);
        setMaxDamage(maxDamage);
        this.sound = sound;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(!world.isRemote && additionalRightClickChecks(player)){
            if(sound != null)
                world.playSoundAtEntity(player, sound.getPrefixedName(), 1, 1);
            try {
                world.spawnEntityInWorld(clazz.getConstructor(World.class, EntityPlayer.class).newInstance(world, player));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stack;
    }
    
    protected boolean additionalRightClickChecks(EntityPlayer player){
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        addAdditionalInformation(stack, player, list, par4);
        if(getMaxDamage() == -1) list.add(TooltipLocalizer.infiniteUses());
    }
    
    protected void addAdditionalInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) { }

}
