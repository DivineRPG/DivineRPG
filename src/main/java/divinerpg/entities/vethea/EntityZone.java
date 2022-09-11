package divinerpg.entities.vethea;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityZone extends EntityVetheaMob {

    public EntityZone(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
		this.setHealth(this.getMaxHealth());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.1F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.zoneHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.zoneDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.zoneSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.zoneFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public void tick() {
        super.tick();

        PlayerEntity player = level.getNearestPlayer(this, 32);
        if(player != null && !player.isCreative()) {
            this.setTarget(player);

            LivingEntity target = this.getTarget();
            if(!this.level.isClientSide && target != null && this.tickCount % 40 == 0 && this.isAlive()) {
                this.shootEntity(target);
            }
        }
    }

    private void shootEntity(LivingEntity target) {
        EntityDivineArrow arrow = new EntityDivineArrow(EntityRegistry.ARROW_SHOT, this.level, ArrowType.KAROS_ARROW, this, target, 1.6f, 12F);
        this.level.addFreshEntity(arrow);
    }

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ZONE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ZONE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ZONE_HURT;
    }
}