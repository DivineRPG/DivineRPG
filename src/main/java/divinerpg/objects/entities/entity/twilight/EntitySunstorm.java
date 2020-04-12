package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.ArrowType;
import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightMageShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

public class EntitySunstorm extends EntityDivineRPGBoss implements IRangedAttackMob {
	//TODO - add spawn method
	public EntitySunstorm(World par1World) {
		super(par1World);
		this.setSize(0.9F, 3F);
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12);
    }

	@Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
		this.attackingPlayer = this.world.getNearestAttackablePlayer(this, 16D, 16D);
        if (this.attackingPlayer != null && !this.world.isRemote) {
            double tx = this.attackingPlayer.posX - this.posX;
            double ty = this.attackingPlayer.getEntityBoundingBox().minY - this.posY;
            double tz = this.attackingPlayer.posZ - this.posZ;
            EntityTwilightMageShot shot = new EntityTwilightMageShot(this.world, this, BulletType.SUNSTORM);
            shot.shoot(tx, ty, tz, 1.6f, 0);
            this.world.spawnEntity(shot);
            this.world.playSound((EntityPlayer) null, this.attackingPlayer.posX, this.attackingPlayer.posY,
                    this.attackingPlayer.posZ, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.HOSTILE, 1.0F, 1.0F);
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
