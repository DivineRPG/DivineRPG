package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntityHellPig extends EntityDivineTameable {

    public EntityHellPig(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 2F);
        this.setTame(false);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return .99375F;
    }

    @Override
    public boolean isFood(ItemStack item) {
    	return isMeat(item);
    }

    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(Items.BLAZE_POWDER);
    }

    @Override
    public boolean removeWhenFarAway(double d) {
    	return !isTame();
    }
}
