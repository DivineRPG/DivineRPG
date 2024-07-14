package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EntityHellPig extends EntityDivineTameable {

    public EntityHellPig(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 2F);
        this.setTame(false , false);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(Items.BLAZE_POWDER);
    }

    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PIG_DEATH;
    }
}
