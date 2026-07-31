package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.entities.boss.EntityKitra;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class EntityAlicanto extends EntityDivineFlyingMonster {
    private int attackTick;

    public EntityAlicanto(EntityType<? extends EntityDivineFlyingMonster> type, Level worldIn) {
        super(type, worldIn, 18F);
        this.fallDistance = 0;
        this.setPathfindingMalus(PathType.WATER, -1.0F);
    }
    @Override
    public void setTarget(LivingEntity entity) {
        super.setTarget(entity != null && entity instanceof EntityKitra ? null : entity);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("AttackTick", this.attackTick);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.attackTick = input.getIntOr("AttackTick", 0);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            if (this.attackTick > 0) {
                --this.attackTick;
            }
        }
    }

    @Override
    public void handleEntityEvent(byte p_33335_) {
        if (p_33335_ == 4) {
            this.attackTick = 10;
        }

        super.handleEntityEvent(p_33335_);
    }

    public int getAttackTick() {
        return this.attackTick;
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity entity) {
        this.attackTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(level, entity);
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 2;
    }

    @Override
    public boolean isMaxGroupSizeReached(int i) {
        return i > 2;
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextInt(4) != 0 ? null : SoundRegistry.ALICANTO.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ALICANTO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ALICANTO_HURT.get();
    }
}