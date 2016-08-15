package net.divinerpg.entities.vethea.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCermileDisk extends EntityDisk {
    public EntityCermileDisk(World par1World) {
        super(par1World);
    }

    public EntityCermileDisk(World par1World, EntityLivingBase entity, int par3, Item i) {
        super(par1World, entity, par3, i);
    }

    public EntityCermileDisk(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }
}