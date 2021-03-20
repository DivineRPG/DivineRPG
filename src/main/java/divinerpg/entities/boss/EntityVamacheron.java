package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityVamacheron extends EntityDivineBoss {


    public EntityVamacheron(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.0F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.vamacheronHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.vamacheronDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.vamacheronSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.vamacheronFollowRange);
    }
}
