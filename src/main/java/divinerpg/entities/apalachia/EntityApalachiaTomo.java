package divinerpg.entities.apalachia;

import divinerpg.entities.base.EntityTomo;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityApalachiaTomo extends EntityTomo {

    public EntityApalachiaTomo(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.5875F;
    }
}
