package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntityFirefly;
import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFirefly extends ItemMod {

    private int arcana = 5;

    public ItemFirefly() {
        super("firefly", DivineRPGTabs.ranged);
        setMaxStackSize(1);
        setFull3D();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(!world.isRemote && ArcanaHelper.getProperties(player).useBar(arcana)){
            Sounds.playSound(player, world, Sounds.firefly);
            EntityFirefly e = new EntityFirefly(world, player);
            world.spawnEntityInWorld(e);
        }
        return stack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(TooltipLocalizer.homingShots());
        list.add(TooltipLocalizer.infiniteAmmo());
        list.add(TooltipLocalizer.arcanaConsumed(arcana));
        list.add(TooltipLocalizer.rangedDam(15));
        list.add(TooltipLocalizer.infiniteUses());
    }
}