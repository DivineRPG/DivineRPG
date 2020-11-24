package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityRainbour extends EntityDivineFlyingMob {
    private int angerLevel;
    private UUID angerTargetUUID;

    public EntityRainbour(EntityType<? extends EntityDivineFlyingMob> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.rainbourHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.rainbourDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.rainbourSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.rainbourFollowRange);
    }
    @Override
    public void setRevengeTarget(@Nullable LivingEntity livingBase)
    {
        super.setRevengeTarget(livingBase);

        if (livingBase != null)
        {
            this.angerTargetUUID = livingBase.getUniqueID();
        }
    }
    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        this.angerLevel = tag.getShort("Anger");
        String s = tag.getString("HurtBy");

        if (!s.isEmpty())
        {
            this.angerTargetUUID = UUID.fromString(s);
            PlayerEntity entityplayer = this.world.getPlayerByUuid(this.angerTargetUUID);
            this.setRevengeTarget(entityplayer);

            if (entityplayer != null)
            {
                this.attackingPlayer = entityplayer;
                this.recentlyHit = this.getRevengeTimer();
            }
        }
    }
    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putShort("Anger", (short)this.angerLevel);

        if (this.angerTargetUUID != null)
        {
            tag.putString("HurtBy", this.angerTargetUUID.toString());
        }
        else
        {
            tag.putString("HurtBy", "");
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source))
        {
            return false;
        }
        else
        {
            Entity entity = source.getTrueSource();

            if (entity instanceof PlayerEntity)
            {
                this.becomeAngryAt(entity);
            }

            return super.attackEntityFrom(source, amount);
        }
    }


    public boolean isAngry() {
        return this.angerLevel > 0;
    }

    private void becomeAngryAt(Entity target)
    {
        this.angerLevel = 400 + this.rand.nextInt(400);

        if (target instanceof LivingEntity)
        {
            this.setRevengeTarget((LivingEntity)target);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.isAngry()) {
            return super.attackEntityAsMob(entity);
        }
        return false;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    public IParticleData getParticleData() {
        return this.getDataManager().get(PARTICLE);
    }
    private static final DataParameter<IParticleData> PARTICLE = EntityDataManager.createKey(EntityRainbour.class, DataSerializers.PARTICLE_DATA);

    @OnlyIn(Dist.CLIENT)
    public void livingTick() {
        super.livingTick();
        for (int var3 = 0; var3 < 8; ++var3) {
            double d15 = (double)getPosX() + rand.nextDouble() * 0.6D + 0.2D;
            double d20 = (double)getPosY() + rand.nextDouble() * 0.6D + 0.2D;
            double d26 = (double)getPosZ() + rand.nextDouble() * 0.6D + 0.2D;
//            this.world.addParticle(ParticleType.SPARKLER, d15, d20, d26, 0.0D, 0.0D, 0.0D);
//                    this.getPosX() + (this.rand.nextDouble() - 0.5D) * (double) this.getWidth(),
//                    this.getPosY() + this.rand.nextDouble() * (double) this.getHeight() - 0.25D,
//                    this.getPosZ() + (this.rand.nextDouble() - 0.5D) * (double) this.getWidth(),
//                    (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
//                    (this.rand.nextDouble() - 0.5D) * 2.0D);
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.RAINBOUR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.RAINBOUR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAINBOUR_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_RAINBOUR;
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && super.canSpawn(worldIn, spawnReasonIn) && world.getLight(getPosition()) <= rand.nextInt(7);
    }

}