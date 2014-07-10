package net.divinerpg.api.items;

import java.util.List;

import net.divinerpg.api.Sound;
import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
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
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(!world.isRemote && additionalRightClickChecks()){
            if(sound != null)
                Sounds.getSoundName(sound);
            try {
                world.spawnEntityInWorld(clazz.getConstructor(World.class, EntityPlayer.class).newInstance(world, player));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stack;
    }
    
    protected boolean additionalRightClickChecks(){
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        addAdditionalInformation(stack, player, list, par4);
        //TODO GET RANGED DAMAGE FROM PROJECTILE ENTITY
        if(getMaxDamage() == -1) list.add(Util.GREEN + "Infinite Uses");
        list.add(Util.DARK_AQUA + Reference.MOD_NAME);
    }
    
    protected void addAdditionalInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) { }

}
