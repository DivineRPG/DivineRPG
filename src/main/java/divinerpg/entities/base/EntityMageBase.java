package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityMageBase extends EntityDivineMob {
    //TODO - Mage bullet type
//    private final BulletType bullet;

    public EntityMageBase(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        //this(type, worldIn, BulletType.MAGE_SHOT);
    }
//    public EntityMageBase(EntityType<? extends MobEntity> type, World worldIn, BulletType bullet) {
//        super(type, worldIn);
//        this.bullet=bullet;
//    }

//    private EntityMageBase(World worldIn) {
//        this(worldIn, BulletType.MAGE_SHOT);
//    }

//    protected EntityMageBase(World world, BulletType bullet) {
//        super(world);
//        this.bullet = bullet;
//        this.setSize(0.5F, 2.2F);
//    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.behemothHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.behemothDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.behemothSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.behemothFollowRange);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.ticksExisted % 20 == 0) {
            this.attackingPlayer = this.world.getClosestPlayer(this, 16D);
            if (this.attackingPlayer != null && !this.world.isRemote) {
                double tx = this.attackingPlayer.getPosX() - this.getPosX();
                double ty = this.attackingPlayer.getBoundingBox().minY - this.getPosY();
                double tz = this.attackingPlayer.getPosZ() - this.getPosZ();
                //TODO - Mage shot
//                EntityTwilightMageShot shot = new EntityTwilightMageShot(this.world, this, bullet);
//                shot.shoot(tx, ty, tz, 1.6f, 0);
//                this.world.spawnEntity(shot);
                this.world.playSound(null, this.attackingPlayer.getPosX(), this.attackingPlayer.getPosY(),
                        this.attackingPlayer.getPosZ(), SoundRegistry.MAGE_FIRE, SoundCategory.HOSTILE, 1.0F, 1.0F);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.INSECT;
    }
}