package net.divinerpg.entities.vethea.projectile;

import java.awt.Color;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.entities.base.EntityHeatSeekingProjectile;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.entities.fx.EntityColoredFX;
import net.divinerpg.entities.vethea.EntityMandragora;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMandragoraProjectile extends EntityHeatSeekingProjectile {
	private EntityLiving thrower;
	
    public EntityMandragoraProjectile(World w) {
        super(w);
        this.setPlayersOnly();
    }

    public EntityMandragoraProjectile(World w, EntityLiving e) {
        super(w, e);
        this.thrower = e;
        this.setPlayersOnly();
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();
        for (int var3 = 0; var3 < 8; ++var3) {
            EntityColoredFX e = new EntityColoredFX(this.worldObj, this.posX+(rand.nextDouble()-rand.nextDouble())/6, this.posY+(rand.nextDouble()-rand.nextDouble())/6, this.posZ+(rand.nextDouble()-rand.nextDouble())/6, 0, 0, 0, new Color(48, 179, 95));
            e.bigger = true;
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(e);
        }
    }

    @Override
    protected void onImpact(MovingObjectPosition pos) {
    	if (pos.entityHit != null && pos.entityHit instanceof EntityPlayer) {
    		pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), (float)EntityStats.mandragoraDamage);
        }
    	
    	if (!this.worldObj.isRemote) {
    		this.setDead();
    	}
    }
}