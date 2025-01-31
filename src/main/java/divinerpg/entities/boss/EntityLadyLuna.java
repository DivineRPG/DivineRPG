package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.magic.EntityLadyLunaSparkler;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class EntityLadyLuna extends EntityDivineBoss {
    public EntityLadyLuna(EntityType<? extends EntityLadyLuna> type, Level worldIn) {
        super(type, worldIn);
        setProtectionTimer(200 + random.nextInt(200));
    }
    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        if(level().isClientSide()) AttachmentRegistry.VARIANT.requestAttachment(this, null);
    }
    public int getProtection() {
        return AttachmentRegistry.VARIANT.getOrDefault(this, (byte) 2);
    }
    private int protectionTimer;

    private final List<BlockPos> acidPositions = new ArrayList<>();

    @Override
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
        Level level = level();
        if(level.isClientSide()) return;
        if(tickCount % 5 == 0)
            for(int x = (int) getX() - 2; x < (int) getX() + 2; x++) for(int y = (int) getBoundingBox().minY; y < (int) getBoundingBox().minY + 4; y++) for(int z = (int) getZ() - 2; z < (int) getZ() + 2; z++)
                if(level.getBlockState(new BlockPos(x, y, z)).is(BlockTags.LEAVES) || level.getBlockState(new BlockPos(x, y, z)).is(BlockTags.LOGS))
                    level.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 1);

        BlockPos current = new BlockPos((int)getX() - 1, (int)getY(), (int)getZ() - 1);
        BlockPos below = new BlockPos((int)getX() - 1, (int)getY() - 1, (int)getZ() - 1);
        BlockState belowState = level.getBlockState(below);
        if(level.getBlockState(current).getBlock() == Blocks.AIR && belowState.canOcclude() && belowState.hasLargeCollisionShape()) {
            level.setBlock(current, BlockRegistry.lunicAcid.get().defaultBlockState(), 1);
            acidPositions.add(current);
        }
        if(getProtection() == 0 && tickCount % 30 == 0) {
            Iterator<BlockPos> iter = acidPositions.iterator();
            while(iter.hasNext()) {
                BlockPos pos = iter.next();
                if(level.getBlockState(pos).getBlock() != BlockRegistry.lunicAcid.get()) iter.remove();
                else if(random.nextInt(4) == 0) {
                    EntityLadyLunaSparkler e = EntityRegistry.LADY_LUNA_SPARKLER.get().create(level);
                    e.setOwner(this);
                    e.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                    level.addFreshEntity(e);
                }
            }
        }
        if(getProtectionTimer() == 0) setRandomProtectionValues();
        else if(getProtectionTimer() > 0) setProtectionTimer(getProtectionTimer() - 1);
    }
    public void setProtectionType(int i) {
        AttachmentRegistry.VARIANT.set(this, (byte)i);
        if(i == 0) getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
        else getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32D);
    }
    public void setProtectionTimer(int i) {
        protectionTimer = i;
    }
    public int getProtectionTimer() {
        return protectionTimer;
    }
    @Override
    public boolean hurt(DamageSource source, float par2) {
        if(source.is(DamageTypes.EXPLOSION)) return false;
        if(source.is(DamageTypes.MAGIC) && getProtection() == 0) return false;
        else if((source.is(DamageTypes.MOB_PROJECTILE) || source.getMsgId().equals("thrown")) && getProtection() == 1) return false;
        else if(!source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC) && getProtection() == 2) return false;
        return super.hurt(source, par2);
    }
    @Override
    public boolean doHurtTarget(Entity e) {
        int dam = 20;
        Level level = level();
        boolean var4 = e.hurt(level.damageSources().mobAttack(this), dam);
        if(var4) {
            level.explode(this, e.getX(), e.getY(), e.getZ(), 2, Level.ExplosionInteraction.BLOCK);
            xo *= 0.6D;
            zo *= 0.6D;
			int var5 = EnchantmentHelper.getEnchantmentLevel(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), this);
            if(var5 > 0) e.igniteForSeconds(var5 * 4);
        } return var4;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("ImmunityCooldown", getProtectionTimer());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setProtectionTimer(tag.getInt("ImmunityCooldown"));
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
        setProtectionType(random.nextInt(2));
        setProtectionTimer(200 + random.nextInt(200));
    }
}
