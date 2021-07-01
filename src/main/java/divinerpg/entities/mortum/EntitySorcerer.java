package divinerpg.entities.mortum;

import divinerpg.entities.base.*;
import divinerpg.enums.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.*;

public class EntitySorcerer extends EntityMageBase {

    public EntitySorcerer(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn, BulletType.SORCERER_SHOT);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.sorcererHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.sorcererDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.sorcererSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.sorcererFollowRange);
    }

}