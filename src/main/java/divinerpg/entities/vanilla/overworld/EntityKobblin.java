package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.core.particles.*;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class EntityKobblin extends EntityDivineMonster {
    public EntityKobblin(EntityType<? extends EntityKobblin> type, Level worldIn) {
        super(type, worldIn);
    }
    public static boolean kobblinSpawnRule(LevelAccessor worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).is(BlockTags.DIRT);
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true) {@Override public boolean canUse() {return super.canUse() && !isEmerging();}});
        goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1) {@Override public boolean canUse() {return super.canUse() && !isEmerging();}});
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        targetSelector.addGoal(0, new HurtByTargetGoal(this) {@Override public boolean canUse() {return super.canUse() && !isEmerging();}});
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true) {@Override public boolean canUse() {return super.canUse() && !isEmerging();}});
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KOBBLIN.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.KOBBLIN.get();
    }
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity entity) {
        return new ClientboundAddEntityPacket(this, entity, hasPose(Pose.EMERGING) ? 1 : 0);
    }
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        if(packet.getData() == 1) setPose(Pose.EMERGING);
    }
    public boolean isInvulnerableTo(DamageSource source) {
        return isEmerging() || super.isInvulnerableTo(source);
    }
    boolean isEmerging() {
        return hasPose(Pose.EMERGING);
    }
    @Override public void tick() {
        super.tick();
        if(hasPose(Pose.EMERGING)) {
            if(level().isClientSide) {
                clientDiggingParticles();
                if((tickCount & 3) == 0) level().playLocalSound(this, SoundEvents.ROOTED_DIRT_PLACE, SoundSource.HOSTILE, 1F, 1F);
            } if(tickCount > 20) setPose(Pose.STANDING);
        }
    }
    private void clientDiggingParticles() {
        RandomSource randomsource = getRandom();
        BlockState blockstate = getBlockStateOn();
        if(blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            double dx, dy, dz;
            for(int i = 0; i < 8; ++i) {
                dx = getX() + Mth.randomBetween(randomsource, -0.3F, 0.3F);
                dy = getY();
                dz = getZ() + Mth.randomBetween(randomsource, -0.3F, 0.3F);
                level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), dx, dy, dz, 0D, 0D, 0D);
            }
        }
    }
    public boolean ignoreExplosion(Explosion explosion) {
        return isEmerging();
    }
    @Override public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        if(spawnType == MobSpawnType.TRIGGERED && level.getBlockState(getOnPos()).is(BlockTags.DIRT)) setPose(Pose.EMERGING);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
    public EntityDimensions getDefaultDimensions(Pose pose) {
        EntityDimensions entitydimensions = super.getDefaultDimensions(pose);
        return isEmerging() ? EntityDimensions.fixed(entitydimensions.width(), 1F) : entitydimensions;
    }
    public boolean isPushable() {
        return !isEmerging() && super.isPushable();
    }
}