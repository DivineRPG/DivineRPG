package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityMageBase;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.*;

public class EntitySorcerer extends EntityMageBase {

    public EntitySorcerer(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        //TODO - BulletType.SORCERER_SHOT
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.sorcererHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.sorcererDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.sorcererSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.sorcererFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.MORTUM_WORLD;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_SORCERER;
    }
}