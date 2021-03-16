package divinerpg.entities.apalachia;

import divinerpg.entities.base.EntityMageBase;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.*;

public class EntitySpellbinder extends EntityMageBase {
    public EntitySpellbinder(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        //TODO - BulletType.SPELLBINDER_SHOT
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.spellbinderHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.spellbinderDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.spellbinderSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.spellbinderFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.APALACHIA_WORLD;
    }
    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_SPELLBINDER;
    }
}