package divinerpg.entities.vanilla;

import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityKingCrab extends EntityCrab {
    public EntityKingCrab(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue=40;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.4F;
    }
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_KING_CRAB;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.kingCrabHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.kingCrabDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.kingCrabSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.kingCrabFollowRange);
    }
}
