package divinerpg.entities.boss;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.EntityLadyLunaSparkler;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.*;

public class EntityLadyLuna extends EntityDivineBoss {
    public static final EntityDataAccessor<Integer> PROTECTION = SynchedEntityData.defineId(EntityLadyLuna.class, EntityDataSerializers.INT);
    public EntityLadyLuna(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.setRandomProtectionValues();
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.90625F;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(PROTECTION, 0);
    }
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance instance, MobSpawnType type, @org.jetbrains.annotations.Nullable SpawnGroupData data, @org.jetbrains.annotations.Nullable CompoundTag tag) {
        entityData.set(PROTECTION, random.nextInt(2));
        return data;
    }

    public int getProtection() {
        return this.entityData.get(PROTECTION);
    }

    private int protectionTimer;

    private List<BlockPos> acidPositions = new ArrayList<BlockPos>();

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, Piglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide() && this.tickCount % 5 == 0) {
            for (int x = (int) this.getX() - 2; x < (int) this.getX() + 2; x++) {
                for (int y = (int) this.getBoundingBox().minY; y < (int) this.getBoundingBox().minY + 4; y++) {
                    for (int z = (int) this.getZ() - 2; z < (int) this.getZ() + 2; z++) {
                        if (this.level().getBlockState(new BlockPos(x, y, z)).is(BlockTags.LEAVES) || this.level().getBlockState(new BlockPos(x, y, z)).is(BlockTags.LOGS))
                            this.level().setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 1);
                    }
                }
            }
        }

        BlockPos current = new BlockPos((int)getX() - 1, (int)getY(), (int)getZ() - 1);
        BlockPos below = new BlockPos((int)getX() - 1, (int)getY() - 1, (int)getZ() - 1);
        BlockState belowState = this.level().getBlockState(below);

        if(this.level().getBlockState(current).getBlock() == Blocks.AIR) {
            if(belowState.canOcclude() && belowState.hasLargeCollisionShape()) {
                this.level().setBlock(current, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "lunic_acid")).defaultBlockState(), 1);
                acidPositions.add(current);
            }
        }

        if (!this.level().isClientSide() && getProtection() == 0 && this.tickCount % 30 == 0) {
            Iterator<BlockPos> iter = this.acidPositions.iterator();
            while (iter.hasNext()) {
                BlockPos pos = iter.next();

                if (this.level().getBlockState(pos).getBlock() != ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "lunic_acid"))) iter.remove();
                else if (this.random.nextInt(4) == 0) {
                    EntityLadyLunaSparkler e = new EntityLadyLunaSparkler(EntityRegistry.LADY_LUNA_SPARKLER.get(), this.level(), this);
                    e.moveTo(pos.getX() + 0.5, pos.getY() + 0, pos.getZ() + 0.5);
                    this.level().addFreshEntity(e);
                }
            }
        }

        if (this.getProtectionTimer() == 0) {
            this.setRandomProtectionValues();
        } else if (this.getProtectionTimer() > 0) {
            this.setProtectionTimer(getProtectionTimer() - 1);
        }
    }

    public void setProtectionType(int i) {
        this.entityData.set(PROTECTION, i);
        if(i == 0) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
        }
        else
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32D);
    }

    public void setProtectionTimer(int i) {
        this.protectionTimer = i;
    }

    public int getProtectionTimer() {
        return this.protectionTimer;
    }

    @Override
    public boolean hurt(DamageSource source, float par2) {
        if (source.is(DamageTypes.EXPLOSION)) return false;

        if (source.is(DamageTypes.MAGIC) && getProtection() == 0)
            return false;
        else if ((source.is(DamageTypes.MOB_PROJECTILE) || source.getMsgId().equals("thrown")) && getProtection() == 1)
            return false;
        else if (!source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC) && getProtection() == 2)
            return false;
        return super.hurt(source, par2);
    }

    @Override
    public boolean doHurtTarget(Entity e) {
        int dam = 20;

        boolean var4 = e.hurt(e.level().damageSources().mobAttack(this), dam);
        if (var4) {
            this.level().explode(this, e.getX(), e.getY(), e.getZ(), 2, Level.ExplosionInteraction.BLOCK);
            this.xo *= 0.6D;
            this.zo *= 0.6D;
            int var5 = EnchantmentHelper.getFireAspect(this);
            if (var5 > 0)
                e.setSecondsOnFire(var5 * 4);
        }
        return var4;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Immunity", getProtection());
        tag.putInt("ImmunityCooldown", this.getProtectionTimer());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setProtectionType(tag.getInt("Immunity"));
        this.setProtectionTimer(tag.getInt("ImmunityCooldown"));
    }



    @Override
    public int getMaxSpawnClusterSize() {return 3;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    private void setRandomProtectionValues() {
        DivineRPG.LOGGER.info("protection type: " + getProtection() + ". protection timer: " + getProtectionTimer());
        this.setProtectionType(random.nextInt(2));
        this.setProtectionTimer(200 + this.random.nextInt(200));
    }
}
