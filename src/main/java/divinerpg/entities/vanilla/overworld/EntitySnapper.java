package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.sounds.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EntitySnapper extends EntityDivineTameable {
    public EntitySnapper(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return .375F;
    }
    @Override
    public boolean isFood(ItemStack item) {
    	return item.is(ItemTags.FISHES);
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(ItemTags.FISHES);
    }
    @Override
    public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof Player) if(random.nextInt(3000) == 0) getOwner().addEffect(new MobEffectInstance(MobEffects.SATURATION, 5));
    }
    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.TURTLE_AMBIENT_LAND;
    }
    @Override
    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_30202_) {
        return SoundEvents.TURTLE_HURT;
    }
    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.TURTLE_DEATH;
    }
}
