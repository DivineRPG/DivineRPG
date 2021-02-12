package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityMageBase;
import divinerpg.registries.LootTableRegistry;
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
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.sorcererHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.sorcererDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.sorcererSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.sorcererFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SORCERER;
    }
}