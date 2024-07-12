package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;

public class EntityDungeonPrisoner extends EntityDivineMonster {
    public EntityDungeonPrisoner(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public boolean isAggressive() {return true;}
    @Override public boolean fireImmune() {return true;}

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (!level().isClientSide()) {
            EntityRegistry.DUNGEON_DEMON.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
            this.playSound(SoundRegistry.DUNGEON_PRISONER_CHANGE.get(), 1, 1);
            this.remove(Entity.RemovalReason.DISCARDED);
        }
        return super.doHurtTarget(entity);
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUNGEON_PRISONER.get();
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUNGEON_PRISONER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUNGEON_PRISONER_HURT.get();
    }

}