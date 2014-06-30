package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.Sounds;
import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entity.vethea.projectile.EntityVetheanCannonShot;
import net.divinerpg.helper.Util;
import net.divinerpg.helper.items.VetheanItems;
import net.divinerpg.helper.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVetheanCannon extends ItemMod {
    protected int damage;

    public ItemVetheanCannon(int dam, String name) {
    	super(name);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.damage = dam;
        this.setCreativeTab(DivineRPGTabs.vethea);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) {
        if (!par2.isRemote && par3.capabilities.isCreativeMode || par3.inventory.hasItem(VetheanItems.acid)) {
            par2.playSoundAtEntity(par3, Sounds.blitz.getPrefixedName(), 1.0F, 1.0F);
            par2.spawnEntityInWorld(new EntityVetheanCannonShot(par2, par3, this.damage));
        }
        return par1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(damage + " Ranged Damage");
        par3List.add("Ammo: Acidfire");
        par3List.add(Util.GREEN + "Vethean");
    }
}