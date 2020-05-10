package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightMageShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntitySunstorm extends EntityDivineRPGBoss implements IRangedAttackMob {
	public EntitySunstorm(World par1World) {
		super(par1World);
		this.setSize(0.9F, 3F);
		this.experienceValue = 1000;
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
    }

	@Override
    public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
		if(this.getDistance(e)<3) {
        	e.setFire(3);
        }
		double y = this.getEntityBoundingBox().minY + 2.7D;
        double tx = e.posX - this.posX;
        double ty = e.getEntityBoundingBox().minY - y;
        double tz = e.posZ - this.posZ;

        for (double h = -1.5; h < 1.5; h += 0.5) {
            for (double r = 0; r < 1.5 - Math.abs(h); r += 0.5) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                    EntityTwilightMageShot shot = new EntityTwilightMageShot(this.world, this, BulletType.SUNSTORM);
                    shot.posX = this.posX + r * Math.cos(theta);
                    shot.posY = this.posY + 5 + h;
                    shot.posZ = this.posZ + r * Math.sin(theta);
                    shot.shoot(tx, ty, tz, 0.9f, 5);
                    world.spawnEntity(shot);
                }
            }
        }
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }
    
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 0.27F, 50, 10));
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SPARKLER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_FIRE_EXTINGUISH;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_FIRE_EXTINGUISH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_SUNSTORM;
    }
}
