package divinerpg.objects.entities.entity.nether;

import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWildfire extends EntityDivineMob implements IRangedAttackMob {

    public EntityWildfire(World worldIn) {
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


    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(7,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
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
        return SoundRegistry.WILDFIRE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WILDFIRE_HURT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.WILDFIRE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_WILDFIRE;
    }
}
