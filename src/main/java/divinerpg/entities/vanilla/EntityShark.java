package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityShark extends EntityDivineWaterMob {

    public EntityShark(EntityType<? extends EntityShark> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new EntityDivineWaterMob.AttackGoal(this));
        goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 0.75D));
        goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.75D, 80));
        goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        goalSelector.addGoal(4, new LookRandomlyGoal(this));
        targetSelector.addGoal(0, new EntityDivineWaterMob.TargetGoal<>(this, PlayerEntity.class));
        targetSelector.addGoal(3, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new EntityDivineWaterMob.TargetGoal<>(this, LivingEntity.class));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SHARK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SHARK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SHARK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SHARK;
    }
}