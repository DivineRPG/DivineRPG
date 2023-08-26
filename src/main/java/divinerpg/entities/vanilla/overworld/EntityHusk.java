package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

public class EntityHusk extends EntityDivineTameable {
    public EntityHusk(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    protected EntityHusk(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn, 1F);
        tame(player);
    }
    @Override
    public boolean isFood(ItemStack item) {
    	return isMeat(item);
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return isMeat(item);
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.3F;}
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GROWL.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT.get();
    }
}