package net.divinerpg.entities.vethea;

import net.divinerpg.entities.vethea.projectile.EntityMandragoraProjectile;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMandragora extends VetheaMob {

    public EntityMandragora(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.mandragoraHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.mandragoraDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.mandragoraSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.mandragoraFollowRange);
    }

    @Override
    public int getSpawnLayer() {
        return 2;
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.mandragora.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.mandragora.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        EntityPlayer target = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16);
        if(!worldObj.isRemote && target != null && this.ticksExisted%20 == 0) attackEntity(target);
    }

    public void attackEntity(EntityLivingBase e) {
        double tx = e.posX - this.posX;
        double ty = e.boundingBox.minY - this.posY;
        double tz = e.posZ - this.posZ;
        EntityMandragoraProjectile p = new EntityMandragoraProjectile(this.worldObj, this);
        p.setThrowableHeading(tx, ty, tz, 1.3f, 15);
        this.playSound(Sounds.mandragora.getPrefixedName(), 2.0F, 2.0F);
        if(!worldObj.isRemote)this.worldObj.spawnEntityInWorld(p);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.cleanPearls, 1);
    }

    @Override
    public String mobName() {
        return "Mandragora";
    }
}
