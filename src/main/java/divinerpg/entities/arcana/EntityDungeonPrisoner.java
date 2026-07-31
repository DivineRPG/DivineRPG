package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityDungeonPrisoner extends EntityDivineMonster {
    public EntityDungeonPrisoner(EntityType<? extends EntityDungeonPrisoner> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public boolean doHurtTarget(ServerLevel level, Entity entity) {
        if (!level().isClientSide()) {
            EntityRegistry.DUNGEON_DEMON.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), EntitySpawnReason.MOB_SUMMONED, true, false);
            this.playSound(SoundRegistry.DUNGEON_PRISONER_CHANGE.get(), 1, 1);
            this.remove(Entity.RemovalReason.DISCARDED);
        }
        return super.doHurtTarget(level, entity);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DUNGEON_PRISONER.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DUNGEON_PRISONER_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DUNGEON_PRISONER_HURT.get();}
}