package naturix.divinerpg.objects.entities.entity.twilight;

import com.google.common.base.Predicate;

import naturix.divinerpg.enums.ArrowType;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class Reyvor extends EntityDivineRPGBoss implements IRangedAttackMob {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/reyvor");

    public Reyvor(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(6,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, (Predicate) null));
        this.tasks.addTask(7, new EntityAIAttackRanged(this, 0.25, 40, 64));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        EntityDivineArrow arrow = new EntityDivineArrow(this.world, ArrowType.REYVOR_ARROW, this);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - arrow.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        arrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 12.0F);
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(arrow);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.REYVOR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.REYVOR_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
