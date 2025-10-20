package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityMadivel extends EntityDivineMonster {
    private int attackAnimationTick;
    public EntityMadivel(EntityType<? extends EntityMadivel> type, Level worldIn) {super(type, worldIn);}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public void aiStep() {
        super.aiStep();
        if(attackAnimationTick > 0) --attackAnimationTick;
    }
    @Override public boolean doHurtTarget(Entity entity) {
        attackAnimationTick = 10;
        level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }
    @Override public void handleEntityEvent(byte id) {
        if(id == 4) attackAnimationTick = 10;
        super.handleEntityEvent(id);
    }
    public int getAttackAnimationTick() {return this.attackAnimationTick;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.MADIVEL.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.MADIVEL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.MADIVEL_HURT.get();}
}