package net.divinerpg.items.vethea;

import net.divinerpg.entities.vethea.projectile.EntityEversightProjectile;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVetheanEversight extends ItemVetheanCannon {
	
    public ItemVetheanEversight(int par1, String name) {
        super(par1, name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) {
        if (!par2.isRemote && (par3.capabilities.isCreativeMode || par3.inventory.hasItem(VetheaItems.acid))) {
            par2.playSoundAtEntity(par3, Sounds.blitz.getPrefixedName(), 1.0F, 1.0F);
            par2.spawnEntityInWorld(new EntityEversightProjectile(par2, par3, this.damage));
        }

        return par1;
    }
}
