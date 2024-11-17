package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVetheanEversight extends ItemProjectileShooter {
	
    public ItemVetheanEversight(String name) {
        super(name, 42, Sounds.blitz.getPrefixedName(), VetheaItems.acid, EntityResourceLocation.eversight.toString(), -1, 0);
        setCreativeTab(DivineRPGTabs.vethea);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(TooltipLocalizer.rangedDam(damage));
        list.add(TooltipLocalizer.infiniteUses());
        list.add(TooltipLocalizer.ammo(VetheaItems.acid));
        list.add(TooltipLocalizer.vethean());
    }
}
