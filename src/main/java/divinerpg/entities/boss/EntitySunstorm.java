package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntitySunstorm extends EntityDivineBoss implements IRangedAttackMob {

    public EntitySunstorm(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 1000;
    }

	@Override
    public void performRangedAttack(LivingEntity e, float f) {
		if(this.distanceTo(e)<3) {
        	e.setSecondsOnFire(3);
        }
//		double y = this.getBoundingBox().minY + 2.7D;
//        double tx = e.getX() - this.getX();
//        double ty = e.getBoundingBox().minY - y;
//        double tz = e.getZ() - this.getZ();

        for (double h = -1.5; h < 1.5; h += 0.5) {
            for (double r = 0; r < 1.5 - Math.abs(h); r += 0.5) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                    //TODO - Sunstorm ranged attack
//                    EntityTwilightMageShot shot = new EntityTwilightMageShot(this.world, this, BulletType.SUNSTORM);
//                    shot.posX = this.posX + r * Math.cos(theta);
//                    shot.posY = this.posY + 5 + h;
//                    shot.posZ = this.posZ + r * Math.sin(theta);
//                    shot.shoot(tx, ty, tz, 0.9f, 5);
//                    world.spawnEntity(shot);
                }
            }
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //TODO - Sunstorm AI
//        this.targetSelector.addGoal(0, new AISunstormAttack(this, 0.27F, 50, 10));
        this.targetSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
    }

    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.UNDEFINED;
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SPARKLER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.FIRE_EXTINGUISH;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.FIRE_EXTINGUISH;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 8)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.vamacheronSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.vamacheronFollowRange);
    }
}
