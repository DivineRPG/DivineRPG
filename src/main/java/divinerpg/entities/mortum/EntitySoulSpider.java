package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.*;

public class EntitySoulSpider extends EntityDivineMonster {
    public EntitySoulSpider(EntityType<? extends EntitySoulSpider> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean fireImmune() {return true;}
    @Override public void tick() {
        super.tick();
        if(tickCount > 600 && !level().isClientSide) kill();
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GROWL.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}