package divinerpg.entities.vanilla.overworld;

import com.sun.javafx.geom.Vec3d;
import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;

public class EntityTheEye extends EntityDivineMob {

    public EntityTheEye(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.theEyeHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.theEyeDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.theEyeSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.theEyeFollowRange);
    }
    @Override
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            PlayerEntity player = this.world.getClosestPlayer(this, 64.0D);
            if (player != null) {
                Vector3d lookVec = player.getLook(1.0F).normalize();
                Vector3d lookAtMeVec = new Vector3d(this.getPosX() - player.getPosX(),
                        this.getBoundingBox().minY + this.getHeight() - (player.getPosY() + player.getEyeHeight()),
                        this.getPosZ() - player.getPosZ());
                double distMagnitude = lookAtMeVec.length();
                lookAtMeVec = lookAtMeVec;
                double var7 = lookVec.dotProduct(lookAtMeVec);
                if (var7 > 1.0D - 0.025D / distMagnitude && player.canEntityBeSeen(this)) {
                    if(!player.isCreative() || !player.isSpectator()) {
                        player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100, 0, false, true));
                        if (player instanceof PlayerEntity) {
                            //TODO - The eye advancement
//                        TriggerRegistry.DIVINERPG_EYE.trigger(player);
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_THE_EYE;
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && getPosition().getY() <= 16 && super.canSpawn(worldIn, spawnReasonIn);
    }
}