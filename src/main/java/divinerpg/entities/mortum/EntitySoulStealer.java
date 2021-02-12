package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.*;

public class EntitySoulStealer extends EntityDivineMob {

    public EntitySoulStealer(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.skythernFiendHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.skythernFiendDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.skythernFiendSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.skythernFiendFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, 12 * 20, 0, false, false));
                ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 12 * 20, 0, false, false));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SOUL_STEALER;
    }
}