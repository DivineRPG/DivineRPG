package divinerpg.entities.vanilla.overworld;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityKingCrab extends EntityCrab {

    public EntityKingCrab(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 10;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.125F;
    }
}
