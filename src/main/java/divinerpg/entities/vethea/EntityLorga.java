package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class EntityLorga extends EntityDivineMonster {
    public boolean canSpawnMinions;
    public EntityLorga(EntityType<? extends EntityLorga> type, Level worldIn) {this(type, worldIn, true);}
    public EntityLorga(EntityType<? extends EntityLorga> type, Level worldIn, boolean canSpawnMinions) {
        super(type, worldIn);
        this.canSpawnMinions = canSpawnMinions;
    }
    @Override public int getMaxSpawnClusterSize() {return 8;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i < 8;}
    @Override public void tick() {
        super.tick();
        if(!level().isClientSide() && canSpawnMinions && getRandom().nextInt(64) == 0 && level().getEntities(null, new AABB(-10, -3, -10, 10, 3, 10)).size() < 8) {
        	BlockPos pos = blockPosition().offset(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
        	if(level().getBlockState(pos).isAir() && level().getBlockState(pos.above()).isAir()) EntityRegistry.LORGA.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, false, false).canSpawnMinions = false;
        }
    }
    @Override public void addAdditionalSaveData(CompoundTag tag) {
    	super.addAdditionalSaveData(tag);
    	tag.putBoolean("CanSpawnMinions", canSpawnMinions);
    }
    @Override public void readAdditionalSaveData(CompoundTag tag) {
    	super.readAdditionalSaveData(tag);
    	canSpawnMinions = tag.getBoolean("CanSpawnMinions");
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.LORGA.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.LORGA_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.LORGA_HURT.get();}
}