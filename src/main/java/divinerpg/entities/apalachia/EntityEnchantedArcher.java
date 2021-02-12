package divinerpg.entities.apalachia;


import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.*;

public class EntityEnchantedArcher extends EntityDivineMob implements IRangedAttackMob {


    public EntityEnchantedArcher(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.9F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.skythernArcherHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.skythernArcherDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.skythernArcherSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.skythernArcherFollowRange);
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
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
        goalSelector.addGoal(0, new RangedAttackGoal(this, 1, 15, 60, 15));
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float f) {
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ENCHANTED_ARCHER;
    }

}
