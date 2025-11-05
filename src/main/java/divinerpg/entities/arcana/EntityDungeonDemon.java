package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityDungeonDemon extends EntityDivineMonster {
    public EntityDungeonDemon(EntityType<? extends EntityDungeonDemon> type, Level worldIn) {
        super(type, worldIn);
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
