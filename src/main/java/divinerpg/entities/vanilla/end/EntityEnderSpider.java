package divinerpg.entities.vanilla.end;

import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityEnderSpider extends EndermanEntity {
    public EntityEnderSpider(EntityType<? extends EndermanEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.45F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.enderSpiderHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.enderSpiderDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.enderSpiderSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.enderSpiderFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HELL_SPIDER;
    }

}
