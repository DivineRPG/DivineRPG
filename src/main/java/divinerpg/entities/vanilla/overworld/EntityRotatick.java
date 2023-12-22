package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;
import net.minecraftforge.event.ForgeEventFactory;

public class EntityRotatick extends EntityDivineMonster {
    private static final EntityDataAccessor<Boolean> SPECIAL = SynchedEntityData.defineId(EntityRotatick.class, EntityDataSerializers.BOOLEAN);
	public EntityRotatick(EntityType<? extends Monster> type, Level level) {super(type, level);}
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance p_146747_, MobSpawnType p_146748_, @org.jetbrains.annotations.Nullable SpawnGroupData p_146749_, @org.jetbrains.annotations.Nullable CompoundTag p_146750_) {
        if(random.nextInt(10) == 1) entityData.set(SPECIAL, true);
        return p_146749_;
    }
    @Override
	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {return 0.5F;}
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SPECIAL, false);
    }
    public boolean isSpecialAlt() {
        return this.entityData.get(SPECIAL);
    }
    @Override
    protected SoundEvent getAmbientSound() {return SoundRegistry.ROTATICK.get();}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ROTATICK_HURT.get();}
    @Override
    protected SoundEvent getDeathSound() {return SoundRegistry.ROTATICK_HURT.get();}
    @Override public boolean isAggressive() {return true;}
    public static boolean rotatickSpawnRule(EntityType<? extends Monster> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return Monster.checkMonsterSpawnRules(typeIn, worldIn, reason, pos, randomIn) && pos.getY() < 0;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        boolean special = entityData.get(SPECIAL);
        if(special) tag.putBoolean("Special", true);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if(tag.contains("Special")) entityData.set(SPECIAL, tag.getBoolean("Special"));
    }
    @Override
    public MobType getMobType() {return MobType.ARTHROPOD;}
}
