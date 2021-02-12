package divinerpg.entities.apalachia;

import divinerpg.entities.base.EntityMageBase;
import divinerpg.registries.LootTableRegistry;
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
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.spellbinderHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.spellbinderDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.spellbinderSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.spellbinderFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SPELLBINDER;
    }
}