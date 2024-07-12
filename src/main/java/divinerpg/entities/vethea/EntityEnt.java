package divinerpg.entities.vethea;


import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityEnt extends EntityDivineMonster {

    public EntityEnt(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }
    @Override public boolean isAggressive() {return true;}

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ENT_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ENT_HURT.get();
    }
}