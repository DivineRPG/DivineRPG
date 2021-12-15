package divinerpg.entities.vanilla.end;

import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityEnderWatcher extends EndermanEntity {
    public EntityEnderWatcher(EntityType<? extends EndermanEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.5F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.enderWatcherHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.enderWatcherDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.enderWatcherSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.enderWatcherFollowRange);
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }
}
