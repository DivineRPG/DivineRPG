package divinerpg.entities.iceika;

import java.util.UUID;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.google.common.base.Suppliers;
import divinerpg.entities.goals.*;
import divinerpg.registries.TagRegistry;
import divinerpg.utils.Utils;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.animal.polarbear.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;

import static divinerpg.registries.EntityRegistry.MAMOTH;

public class EntityMamoth extends Animal implements NeutralMob {
    public boolean wantsToFly = false;
    private static final Supplier<Ingredient> FOOD = Suppliers.memoize(() ->
            Ingredient.of(BuiltInRegistries.ITEM.getOrThrow(TagRegistry.FOOD_MAMOTH))
    );
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    protected @Nullable Vec3 pathfindPos;
    private UUID persistentAngerTarget;
    private int remainingPersistentAngerTime;

    public EntityMamoth(EntityType<? extends EntityMamoth> type, Level level) {
        super(type, level);
        setPathfindingMalus(PathType.POWDER_SNOW, -1);
        setPathfindingMalus(PathType.ON_TOP_OF_POWDER_SNOW, -1);
    }

    @Override
    public BlockPos adjustSpawnLocation(ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos mut = pos.mutable();
        while (level.getBlockState(mut).is(Blocks.POWDER_SNOW)) mut.move(Direction.UP);
        return mut;
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader level) {
        return level.isUnobstructed(this, Shapes.create(getBoundingBox().deflate(0.2)));
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.25, true));
        goalSelector.addGoal(1, new PanicGoal(this, 2.0) {
            @Override
            protected boolean shouldPanic() {
                return mob.getLastHurtByMob() != null && mob.isBaby() || mob.isOnFire();
            }
        });
        goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> FOOD.get().test(stack), false));
        goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
        goalSelector.addGoal(5, new FollowParentGoal(this, 1.25));
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new AlertingHurtByTargetGoal(this));
        targetSelector.addGoal(2, new ProtectBabyFromPlayerGoal(this));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Fox.class, 10, true, true, null));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PolarBear.class, 10, true, true, null));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntitySeng.class, 10, true, true, null));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntitySabear.class, 10, true, true, null));
        targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    @Override
    public void tick() {
        super.tick();
        if (level() instanceof ServerLevel level) {
            updatePersistentAnger(level, true);
            if (isBaby()) {
                if (getLastHurtByMob() != null || wantsToFly) {
                    if (onGround()) {
                        setDeltaMovement(getDeltaMovement().multiply(1.1, 1, 1.1));
                        if (Math.pow(getDeltaMovement().x, 2) + Math.pow(getDeltaMovement().z, 2) > 8)
                            setDeltaMovement(getDeltaMovement().add(0, 0.5, 0));
                    } else if (!isInWater()) {
                        if (!isNoGravity()) setNoGravity(true);
                        if (getNavigation().isInProgress()) getNavigation().stop();
                        boolean blockedPath = horizontalCollision || verticalCollision;
                        if (!blockedPath) {
                            Vec3 futurePos = position().add(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z);
                            BlockPos pos = new BlockPos((int) futurePos.x, (int) futurePos.y, (int) futurePos.z);
                            BlockState state = level().getBlockState(pos);
                            blockedPath = state.is(Blocks.LAVA) || !state.getCollisionShape(level(), pos).equals(Shapes.empty());
                        }
                        if (pathfindPos == null || blockedPath)
                            pathfindPos = new Vec3(getX() + ((random.nextFloat() - 0.5F) * 14), getY() + ((random.nextFloat() - 0.6F) * 14), getZ() + ((random.nextFloat() - 0.5F) * 14));
                        double speed = getAttributeValue(Attributes.FLYING_SPEED);
                        setDeltaMovement(getDeltaMovement().x + (pathfindPos.x - getX()) / 64 * speed, getDeltaMovement().y + (pathfindPos.y - getY()) / 64 * speed, getDeltaMovement().z + (pathfindPos.z - getZ()) / 64 * speed);
                        double distanceX = pathfindPos.x - getX(), distanceY = pathfindPos.y - getY(), distanceZ = pathfindPos.z - getZ();
                        yHeadRot = Utils.rotlerp(getYRot(), (float) (Mth.atan2(distanceZ, distanceX) * 180 / Math.PI) - 90, 90);
                        xRotO = Utils.rotlerp(getXRot(), (float) -(Mth.atan2(distanceY, Math.sqrt(distanceX * distanceX + distanceZ * distanceZ)) * 180 / Math.PI), 20);
                        if (Math.sqrt(distanceToSqr(pathfindPos)) < 2.0) pathfindPos = null;
                        fallDistance = 0;
                    }
                } else {
                    if (isNoGravity()) setNoGravity(false);
                    if (getDeltaMovement().y < 0) {
                        setDeltaMovement(getDeltaMovement().multiply(1.0, 0.6, 1.0));
                        fallDistance = 0.0F;
                    }
                }
                if (random.nextInt(100) == 0) {
                    wantsToFly = !wantsToFly;
                    setLastHurtByMob(null);
                }
            } else if (isNoGravity()) setNoGravity(false);
        }
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity entity) {
        DamageSource source = damageSources().mobAttack(this);
        boolean hurt = entity.hurtServer(level, source, (int) getAttributeValue(Attributes.ATTACK_DAMAGE));
        if (hurt && entity.level() instanceof ServerLevel)
            EnchantmentHelper.doPostAttackEffects(level, entity, source);
        return hurt;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance instance, EntitySpawnReason type, SpawnGroupData data) {
        if (data == null) data = new AgeableMob.AgeableMobGroupData(1);
        return super.finalizeSpawn(level, instance, type, data);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return MAMOTH.get().create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return FOOD.get().test(stack);
    }

    @Override
    public long getPersistentAngerEndTime() {
        return remainingPersistentAngerTime;
    }

    @Override
    public void setPersistentAngerEndTime(long l) {
        remainingPersistentAngerTime = (int) l;
    }

    @Override
    public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {
        return EntityReference.of(persistentAngerTarget);
    }

    @Override
    public void setPersistentAngerTarget(@Nullable EntityReference<LivingEntity> entityReference) {
        persistentAngerTarget = entityReference != null ? entityReference.getUUID() : null;
    }

    @Override
    public void startPersistentAngerTimer() {
        setPersistentAngerEndTime(PERSISTENT_ANGER_TIME.sample(random));
    }

    @Override
    public void readAdditionalSaveData(ValueInput tag) {
        super.readAdditionalSaveData(tag);
        readPersistentAngerSaveData(level(), tag);
        wantsToFly = tag.getBooleanOr("wants_to_fly", false);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput tag) {
        super.addAdditionalSaveData(tag);
        addPersistentAngerSaveData(tag);
        if (isBaby()) tag.putBoolean("wants_to_fly", wantsToFly);
    }
}