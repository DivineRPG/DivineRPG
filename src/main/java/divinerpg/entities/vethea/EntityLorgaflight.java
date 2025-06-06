package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineFlyingMonster;
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

import java.util.List;

public class EntityLorgaflight extends EntityDivineFlyingMonster {
    public boolean canSpawnMinions;
    public EntityLorgaflight(EntityType<? extends EntityLorgaflight> type, Level worldIn) {this(type, worldIn, true);}
    public EntityLorgaflight(EntityType<? extends EntityLorgaflight> type, Level worldIn, boolean canSpawnMinions) {
        super(type, worldIn);
        this.canSpawnMinions = canSpawnMinions;
    }
    @Override
    public void flyingAIStep() {
        if(getTarget() == null && random.nextBoolean()) {
            List<EntityLorgaflight> list = level().getEntitiesOfClass(EntityLorgaflight.class, new AABB(-5, -5, -5, 5, 5, 5));
            if(!list.isEmpty()) {
                EntityLorgaflight partner = list.get(0);
                if(partner.pathfindPos != null) pathfindPos = partner.pathfindPos.add(position().subtract(partner.position()).multiply(.9, .9, .9));
            }
        } super.flyingAIStep();
    }

    @Override public void tick() {
        super.tick();
        if(!level().isClientSide() && canSpawnMinions && getRandom().nextInt(64) == 0 && level().getEntities(null, new AABB(-10, -3, -10, 10, 3, 10)).size() < 8) {
            BlockPos pos = blockPosition().offset(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
            if(level().getBlockState(pos).isAir() && level().getBlockState(pos.above()).isAir()) EntityRegistry.LORGA_FLIGHT.get().spawn((ServerLevel) level(), (ItemStack) null, null, pos, MobSpawnType.MOB_SUMMONED, false, false).canSpawnMinions = false;
        }
    }
    @Override public int getMaxSpawnClusterSize() {return 8;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i < 8;}
    @Override public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("CanSpawnMinions", canSpawnMinions);
    }
    @Override public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        canSpawnMinions = tag.getBoolean("CanSpawnMinions");
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.LORGAFLIGHT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.LORGAFLIGHT_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.LORGAFLIGHT_HURT.get();}
}