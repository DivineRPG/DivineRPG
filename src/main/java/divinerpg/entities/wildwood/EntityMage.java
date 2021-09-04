package divinerpg.entities.wildwood;

import divinerpg.entities.base.*;
import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityMage extends EntityMageBase {
    public EntityMage(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn, BulletType.MAGE_SHOT);
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader world) {
        return 0.0F;
    }
}