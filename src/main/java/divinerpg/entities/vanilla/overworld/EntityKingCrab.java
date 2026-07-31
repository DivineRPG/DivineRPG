package divinerpg.entities.vanilla.overworld;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityKingCrab extends EntityCrab {
    public EntityKingCrab(EntityType<? extends EntityKingCrab> type, Level worldIn) {
        super(type, worldIn);
        xpReward = XP_REWARD_LARGE;
    }
}