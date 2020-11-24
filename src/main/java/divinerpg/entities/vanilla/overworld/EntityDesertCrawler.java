package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityDesertCrawler extends EntityDivineMob {

    public EntityDesertCrawler(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.15F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.desertCrawlerHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.desertCrawlerDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.desertCrawlerSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.desertCrawlerFollowRange);
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
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_DESERT_CRAWLER;
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && super.canSpawn(worldIn, spawnReasonIn);
    }
}