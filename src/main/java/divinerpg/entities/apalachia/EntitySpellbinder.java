package divinerpg.entities.apalachia;

import divinerpg.entities.base.*;
import divinerpg.enums.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntitySpellbinder extends EntityMageBase {
    public EntitySpellbinder(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn, BulletType.SPELLBINDER_SHOT);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.spellbinderHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.spellbinderDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.spellbinderSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.spellbinderFollowRange);
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader world) {
        return 0.0F;
    }
}