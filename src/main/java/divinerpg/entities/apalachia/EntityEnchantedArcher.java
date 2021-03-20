package divinerpg.entities.apalachia;


import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityEnchantedArcher extends EntityDivineMob implements IRangedAttackMob {


    public EntityEnchantedArcher(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.9F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.skythernArcherHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.skythernArcherDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.skythernArcherSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.skythernArcherFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.APALACHIA_WORLD;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
        goalSelector.addGoal(0, new RangedAttackGoal(this, 1, 15, 60, 15));
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float f) {
        //TODO - Enchanted archer arrow
//        this.world.spawnEntity(new EntityDivineArrow(this.world, ArrowType.ENCHANTED_ARCHER_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ARCHER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HIGH_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HIGH_HIT;
    }

}
