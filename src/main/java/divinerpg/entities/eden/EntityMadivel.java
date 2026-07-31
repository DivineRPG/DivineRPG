package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class EntityMadivel extends EntityDivineMonster {
    private int attackAnimationTick;
    public EntityMadivel(EntityType<? extends EntityMadivel> type, Level worldIn) {super(type, worldIn);}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public void aiStep() {
        super.aiStep();
        if(attackAnimationTick > 0) --attackAnimationTick;
    }
    @Override public boolean doHurtTarget(ServerLevel level, Entity entity) {
        attackAnimationTick = 10;
        level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(level, entity);
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