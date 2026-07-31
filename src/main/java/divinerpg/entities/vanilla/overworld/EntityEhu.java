package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;

public class EntityEhu extends EntityDivineTameable {
    public EntityEhu(EntityType<? extends EntityEhu> type, Level worldIn) {super(type, worldIn, 1);}
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_EHU);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.TAMING_EHU);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GROWL.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}