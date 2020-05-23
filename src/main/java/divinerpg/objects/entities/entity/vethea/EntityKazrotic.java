package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.projectiles.EntityKazroticShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityKazrotic extends VetheaMob implements IRangedAttackMob {
	
    public EntityKazrotic(World par1World) {
        super(par1World);
        this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(7, new EntityAIAttackRanged(this, 0.25F, 15, 40.0F));
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    
    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float par2) {
    	double tx = entity.posX - this.posX;
        double ty = entity.getEntityBoundingBox().minY - this.posY;
        double tz = entity.posZ - this.posZ;
        EntityKazroticShot shot = new EntityKazroticShot(this.world, this);
        shot.shoot(tx, ty, tz, 0.6F, 0.3F);
        world.playSound(attackingPlayer, this.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.HOSTILE, 1, 1);
        this.world.spawnEntity(shot);
    }

    @Override
    public boolean attackEntityFrom(DamageSource par1, float par2) {
        if (par1.isExplosion())
            return false;
        return super.attackEntityFrom(par1, par2);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_KAZROTIC;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.KAZROTIC;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KAZROTIC_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.KAZROTIC_HURT;
    }

	@Override
	public void setSwingingArms(boolean swingingArms) {
		
	}
}
