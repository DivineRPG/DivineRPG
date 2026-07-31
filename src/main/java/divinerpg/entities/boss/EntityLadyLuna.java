package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.magic.EntityLadyLunaSparkler;
import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityLadyLuna extends EntityDivineBoss {
    private int protectionTimer;
    private final List<BlockPos> acidPositions = new ArrayList<>();

    public EntityLadyLuna(EntityType<? extends EntityLadyLuna> type, Level worldIn) {
        super(type, worldIn);
        setProtectionTimer(200 + random.nextInt(200));
    }

    public int getProtection() {
        return this.getData(AttachmentRegistry.VARIANT.attachment.get());
    }

    public void setProtectionType(int i) {
        this.setData(AttachmentRegistry.VARIANT.attachment.get(), (byte)i);
        AttributeInstance speedAttribute = getAttribute(Attributes.MOVEMENT_SPEED);
        if (speedAttribute != null) {
            if (i == 0) {
                speedAttribute.setBaseValue(0.0D);
            } else {
                speedAttribute.setBaseValue(0.32D);
            }
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(8, new FollowMobGoal(this, 1.0D, 1.0F, 1.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, Piglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        Level level = level();
        if (level.isClientSide()) return;

        BlockPos currentPos = BlockPos.containing(getX(), getY(), getZ());

        // Break surrounding leaves and logs
        if (tickCount % 5 == 0) {
            for (int x = currentPos.getX() - 2; x <= currentPos.getX() + 2; x++) {
                for (int y = (int) getBoundingBox().minY; y < (int) getBoundingBox().minY + 4; y++) {
                    for (int z = currentPos.getZ() - 2; z <= currentPos.getZ() + 2; z++) {
                        BlockPos pos = new BlockPos(x, y, z);
                        BlockState state = level.getBlockState(pos);
                        if (state.is(BlockTags.LEAVES) || state.is(BlockTags.LOGS)) {
                            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);
                        }
                    }
                }
            }
        }

        // Place lunic acid trail below
        BlockPos current = BlockPos.containing(getX() - 1, getY(), getZ() - 1);
        BlockPos below = BlockPos.containing(getX() - 1, getY() - 1, getZ() - 1);
        BlockState belowState = level.getBlockState(below);

        if (level.getBlockState(current).isAir() && belowState.canOcclude() && belowState.hasLargeCollisionShape()) {
            level.setBlock(current, BlockRegistry.lunicAcid.get().defaultBlockState(), 1);
            acidPositions.add(current);
        }

        // Spawn sparklers when in protection state 0
        if (getProtection() == 0 && tickCount % 30 == 0) {
            Iterator<BlockPos> iter = acidPositions.iterator();
            while (iter.hasNext()) {
                BlockPos pos = iter.next();
                if (!level.getBlockState(pos).is(BlockRegistry.lunicAcid.get())) {
                    iter.remove();
                } else if (random.nextInt(4) == 0) {
                    EntityLadyLunaSparkler e = EntityRegistry.LADY_LUNA_SPARKLER.get().create(level, EntitySpawnReason.EVENT);
                    if (e != null) {
                        e.setOwner(this);
                        e.moveOrInterpolateTo(new Vec3(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D));
                        level.addFreshEntity(e);
                    }
                }
            }
        }

        if (getProtectionTimer() <= 0) {
            setRandomProtectionValues();
        } else {
            setProtectionTimer(getProtectionTimer() - 1);
        }
    }

    public void setProtectionTimer(int i) {
        protectionTimer = i;
    }

    public int getProtectionTimer() {
        return protectionTimer;
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if (source.is(DamageTypes.EXPLOSION)) return false;
        if (source.is(DamageTypes.MAGIC) && getProtection() == 0) return false;
        if ((source.is(DamageTypes.MOB_PROJECTILE) || source.getMsgId().equals("thrown")) && getProtection() == 1) return false;
        if (!source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC) && getProtection() == 2) return false;

        return super.hurtServer(level, source, amount);
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity target) {
        int damage = 20;
        boolean hurt = target.hurtServer(level, level.damageSources().mobAttack(this), damage);
        if (hurt) {
            level.explode(this, target.getX(), target.getY(), target.getZ(), 2.0F, Level.ExplosionInteraction.BLOCK);
            setDeltaMovement(getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));

            int fireAspect = EnchantmentHelper.getEnchantmentLevel(
                    level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT),
                    this
            );
            if (fireAspect > 0) {
                target.igniteForSeconds(fireAspect * 4);
            }
        }
        return hurt;
    }



    @Override
    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("ImmunityCooldown", getProtectionTimer());
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        setProtectionTimer(input.getIntOr("ImmunityCooldown", 0));
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LADY_LUNA.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LADY_LUNA_HURT.get();
    }

    private void setRandomProtectionValues() {
        setProtectionType(random.nextInt(3));
        setProtectionTimer(200 + random.nextInt(200));
    }
}