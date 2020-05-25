package divinerpg.objects.entities.entity.arcana;

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

public class EntityLivingStatue extends EntityDivineMob implements IRangedAttackMob {

    public EntityLivingStatue(World world) {
        super(world);
        this.setSize(0.8F, 2.0F);
    }

    @Override
    public float getEyeHeight() {
        return 1.725F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(1,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
        this.tasks.addTask(1, new EntityAIAttackRanged(this, 0.27D, 10, 60));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.HIGH_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HIGH_HIT;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.world.spawnEntity(
                new EntityDivineArrow(this.world, ArrowType.LIVING_STATUE_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_LIVING_STATUE;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}