package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityCaveCrawler extends EntityDivineMob {

    public EntityCaveCrawler(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.15F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.caveCrawlerHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.caveCrawlerDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.caveCrawlerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.caveCrawlerFollowRange);
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
            return level.dimension() == World.OVERWORLD && getY() < 35;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CRAWLER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CRAWLER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CRAWLER_HURT;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_CAVE_CRAWLER;
    }

}