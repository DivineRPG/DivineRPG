package divinerpg.entities.wildwood;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.*;

public class EntityMoonWolf extends Wolf {

    public EntityMoonWolf(EntityType<? extends Wolf> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.96875F;
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return !isTame();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }

}
