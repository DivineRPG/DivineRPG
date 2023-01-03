package divinerpg.entities.wildwood;

import divinerpg.entities.base.*;
import divinerpg.enums.*;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityMage extends EntityMageBase {
    public EntityMage(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn, BulletType.MAGE_SHOT);
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }
}