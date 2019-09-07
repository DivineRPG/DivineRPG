package divinerpg.objects.entities.entity.vanilla;

import com.google.common.base.Predicate;

import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Wildfire extends EntityDivineRPGMob implements IRangedAttackMob {

    public Wildfire(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2.2F);
        this.isImmuneToFire = true;
    }

    @Override
    public float getEyeHeight() {
        return 1.75F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(7,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, (Predicate) null));
        this.tasks.addTask(7, new EntityAIAttackRanged(this, 0.25F, 15, 10.0F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        EntityDivineArrow arrow = new EntityDivineArrow(this.world, ArrowType.WILDFIRE_ARROW, this, target, 1.6F,
                12.0F);
        arrow.setFire(100);
        this.world.spawnEntity(arrow);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.WILDFIRE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.WILDFIRE_HURT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.WILDFIRE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_WILDFIRE;
    }
}
