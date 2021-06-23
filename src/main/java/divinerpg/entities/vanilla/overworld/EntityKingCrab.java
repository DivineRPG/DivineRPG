package divinerpg.entities.vanilla.overworld;

import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.*;

public class EntityKingCrab extends EntityCrab {
    public EntityKingCrab(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward=40;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.4F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.kingCrabHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.kingCrabDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.kingCrabSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.kingCrabFollowRange);
    }

}
