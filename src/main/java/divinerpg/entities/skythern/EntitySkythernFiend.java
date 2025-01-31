package divinerpg.entities.skythern;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.*;

import static divinerpg.registries.SoundRegistry.INSECT;

public class EntitySkythernFiend extends EntityDivineMonster {
    public EntitySkythernFiend(EntityType<? extends EntitySkythernFiend> type, Level worldIn) {super(type, worldIn);}
    @Override public int getArmorValue() {return 10;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return INSECT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return INSECT.get();}
    @Override protected SoundEvent getDeathSound() {return INSECT.get();}
}