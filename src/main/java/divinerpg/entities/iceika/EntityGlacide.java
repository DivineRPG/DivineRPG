package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityGlacide extends EntityDivineMob {


    public EntityGlacide(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.glacideHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.glacideDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.glacideSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.glacideFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GLACIDE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GLACIDE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GLACIDE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_GLACIDE;
    }
}
