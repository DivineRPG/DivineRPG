package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import java.util.Random;

public class EntityCaveCrawler extends EntityDivineMob {

    public EntityCaveCrawler(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.15F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.caveCrawlerHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.caveCrawlerDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.caveCrawlerSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.caveCrawlerFollowRange);
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
        return LootTableRegistry.ENTITIES_CAVE_CRAWLER;
    }

}