package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityTheEye extends EntityDivineMob {

    public EntityTheEye(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.theEyeHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.theEyeDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.theEyeSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.theEyeFollowRange);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            PlayerEntity player = this.level.getNearestPlayer(this, 64.0D);
            if (player != null) {
                if(!player.isCreative() && !player.isSpectator()){
                Vector3d lookVec = player.getViewVector(1.0F).normalize();
                Vector3d lookAtMeVec = new Vector3d(this.getX() - player.getX(),
                        this.getBoundingBox().minY + this.getBbHeight() - (player.getY() + player.getEyeHeight()),
                        this.getZ() - player.getZ());
                double distMagnitude = lookAtMeVec.length();
                lookAtMeVec = lookAtMeVec.normalize();
                double var7 = lookVec.distanceTo(lookAtMeVec);
                if (var7 > 1.0D - 0.025D / distMagnitude && getSensing().canSee(player)) {
                    player.addEffect(new EffectInstance(Effects.BLINDNESS, 100, 0, false, true));
                    if (player instanceof PlayerEntity) {
                        TriggerRegistry.DIVINERPG_EYE.trigger((ServerPlayerEntity) player);
                    }
                }
            }
        }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.THE_EYE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.THE_EYE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.THE_EYE_HURT;
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || pos.getY() <= 16 && worldIn.getLightEmission(pos) < 8;
    }
}