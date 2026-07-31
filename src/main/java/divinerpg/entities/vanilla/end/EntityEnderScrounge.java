package divinerpg.entities.vanilla.end;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;

import static net.minecraft.core.Direction.DOWN;
import static net.minecraft.world.entity.EquipmentSlot.FEET;

public class EntityEnderScrounge extends PathfinderMob {
    public EntityEnderScrounge(EntityType<? extends EntityEnderScrounge> type, Level worldIn) {
        super(type, worldIn);
        setPathfindingMalus(PathType.WATER, -1);
    }
    @Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {return false;}
    @Override protected void registerGoals() {
        goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1, 0));
        goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8));
        targetSelector.addGoal(0, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Endermite.class, true, false));
        super.registerGoals();
    }

    @Override public boolean doHurtTarget(ServerLevel level, Entity target) {
        playSound(SoundEvents.RABBIT_ATTACK, 1, (random.nextFloat() - random.nextFloat()) * .2F + 1);
        return super.doHurtTarget(level, target);
    }
    @Override public float maxUpStep() {return .75F;}
    @Override public void tick() {
        super.tick();
        if(!level().isClientSide()) {
            if(level().getNearestPlayer(this, 3) != null) {
                Player player = level().getNearestPlayer(this, 3);
                if(!player.isCreative() && !player.isSpectator()) {
                    if(random.nextInt(50) == 0) {
                        ItemStack boots = player.getItemBySlot(FEET);
                        if(boots != null && !boots.isEmpty()) {
                            ItemEntity item = new ItemEntity(level(), getX(), getY(), getZ(), boots);
                            level().addFreshEntity(item);
                            player.setItemSlot(FEET, new ItemStack(Items.AIR));
                        }
                    }
                }
            }
        }
    }
    @Override public void aiStep() {
        if(level().isClientSide()) for(int i = 0; i < 2; ++i) level().addParticle(ParticleTypes.PORTAL, getRandomX(.5), getRandomY() - .25, getRandomZ(.5), (random.nextDouble() - .5) * 2, -random.nextDouble(), (random.nextDouble() - .5) * 2);
        jumping = false;
        super.aiStep();
    }
    @Override public boolean isSensitiveToWater() {return true;}
    @Override protected void customServerAiStep(ServerLevel level) {
        if(level.getSkyDarken() < 4 && tickCount >= 601) {
            @SuppressWarnings("deprecation")
            float f = getLightLevelDependentMagicValue();
            if(f > .5 && level().canSeeSky(blockPosition()) && random.nextFloat() * 30 < (f - .4) * 2) {
                setTarget(null);
                teleport();
            }
        } super.customServerAiStep(level);
    }
    protected boolean teleport() {
        if(!level().isClientSide() && isAlive()) {
            double d0 = getX() + (random.nextDouble() - .5) * 64;
            double d1 = getY() + (random.nextInt(64) - 32);
            double d2 = getZ() + (random.nextDouble() - .5) * 64;
            return teleport(d0, d1, d2);
        } else return false;
    }
    private boolean teleport(double p_32544_, double p_32545_, double p_32546_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(p_32544_, p_32545_, p_32546_);
        while(blockpos$mutableblockpos.getY() > level().getMinY() && !level().getBlockState(blockpos$mutableblockpos).isCollisionShapeFullBlock(level(), blockpos$mutableblockpos)) blockpos$mutableblockpos.move(DOWN);
        BlockState blockstate = level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.isCollisionShapeFullBlock(level(), blockpos$mutableblockpos);
        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
        if(flag && !flag1) {
            EntityTeleportEvent.EnderEntity event = EventHooks.onEnderTeleport(this, p_32544_, p_32545_, p_32546_);
            if(event.isCanceled()) return false;
            Vec3 vec3 = position();
            boolean flag2 = randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if(flag2) {
                level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                if(!isSilent()) {
                    level().playSound(null, xo, yo, zo, SoundEvents.ENDERMAN_TELEPORT, getSoundSource(), 1, 1);
                    playSound(SoundEvents.ENDERMAN_TELEPORT, 1, 1);
                }
            } return flag2;
        } else return false;
    }
    @Override protected SoundEvent getHurtSound(DamageSource s) {return SoundEvents.RABBIT_HURT;}
    @Override protected SoundEvent getAmbientSound() {return SoundEvents.RABBIT_AMBIENT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.RABBIT_DEATH;}
}