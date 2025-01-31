package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EntityHellPig extends EntityDivineTameable {
    public EntityHellPig(EntityType<? extends EntityHellPig> type, Level worldIn) {super(type, worldIn, 2);}
    @Override public boolean fireImmune() {return true;}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(Items.BLAZE_POWDER);}
    @Nullable
    @Override public SoundEvent getAmbientSound() {return SoundEvents.PIG_AMBIENT;}
    @Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return SoundEvents.PIG_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.PIG_DEATH;}
}