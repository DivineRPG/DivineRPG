package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.TagRegistry;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityHellPig extends EntityDivineTameable {
    public EntityHellPig(EntityType<? extends EntityHellPig> type, Level worldIn) {super(type, worldIn, 2);}
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_FOODS_HELL_PIG);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.PET_TAMING_FOODS_HELL_PIG);}
    @Override public SoundEvent getAmbientSound() {return SoundEvents.PIG_AMBIENT;}
    @Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return SoundEvents.PIG_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.PIG_DEATH;}
}