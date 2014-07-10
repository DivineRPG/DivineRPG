package net.divinerpg.entities.arcana.projectile;

import net.divinerpg.entities.vanilla.projectile.EntitySparklerFX;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySparkler extends EntityThrowable {
	
    public EntitySparkler(World var1) {
        super(var1);
    }

    public EntitySparkler(World var1, EntityPlayer var2) {
        super(var1, var2);
    }

    public EntitySparkler(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onUpdate() {
        super.onUpdate();
        for (int var3 = 0; var3 < 8; ++var3) {
            EntitySparklerFX var20 = new EntitySparklerFX(this.worldObj, this.posX, this.posY, this.posZ, 0.25*this.rand.nextGaussian(), 0.25*this.rand.nextGaussian(), 0.25*this.rand.nextGaussian());
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
        }
    }
    
    protected void onImpact(MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            byte var2 = 26;
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}