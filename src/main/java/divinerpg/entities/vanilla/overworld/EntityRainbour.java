package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.registries.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityRainbour extends EntityDivineFlyingMob {
    private int angerLevel;
    private UUID angerTargetUUID;

    public EntityRainbour(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn);
        this.lookControl = new EntityRainbour.RainbourLookController(this);
    }

    @Override
    public float getEyeHeight(Pose pose) {
        return 0.6875F;
    }

    @Override
    public void setTarget(@Nullable LivingEntity livingBase) {
        super.setTarget(livingBase);

        if (livingBase != null)
        {
            if(livingBase instanceof Player player){
                if(!player.isCreative() || !player.isSpectator()){
                    this.angerTargetUUID = livingBase.getUUID();
                }
            }
        }
    }
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.angerLevel = tag.getShort("Anger");
        String s = tag.getString("HurtBy");

        if (!s.isEmpty())
        {
            this.angerTargetUUID = UUID.fromString(s);
            Player entityplayer = this.getCommandSenderWorld().getPlayerByUUID(this.angerTargetUUID);
            this.setTarget(entityplayer);

            if (entityplayer != null)
            {
                this.lastHurtByPlayer = entityplayer;
                this.hurtTime = this.getLastHurtByMobTimestamp();
            }
        }
    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
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
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source))
        {
            return false;
        }
        else
        {
            Entity entity = source.getDirectEntity();

            if (entity instanceof Player player) {
                if (!player.isCreative()) {
                    this.becomeAngryAt(entity);
                }
            }

            return super.hurt(source, amount);
        }
    }


    public boolean isAngry() {
        return this.angerLevel > 0;
    }

    private void becomeAngryAt(Entity target)
    {
        this.angerLevel = 400 + this.random.nextInt(400);

        if (target instanceof LivingEntity)
        {
            this.setTarget((LivingEntity)target);
        }
    }


    @Override
    public boolean doHurtTarget(Entity entity) {
        if (this.isAngry()) {
            return super.doHurtTarget(entity);
        }
        return false;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.6875F;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }
    public ParticleOptions getParticleData() {
        return this.getEntityData().get(PARTICLE);
    }
    private static final EntityDataAccessor<ParticleOptions> PARTICLE = SynchedEntityData.defineId(EntityRainbour.class, EntityDataSerializers.PARTICLE);

    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            double d15 = getX() + random.nextDouble() * 0.6D + 0.2D;
            double d20 = getY() + random.nextDouble() * 0.6D + 0.2D;
            double d26 = getZ() + random.nextDouble() * 0.6D + 0.2D;

            if(level().isClientSide)
            level().addParticle(ParticleRegistry.SPARKLER.get(),d15 * (double) this.getBbWidth(),d20 + this.random.nextDouble() * (double) this.getBbHeight() - 0.25D,
                    d26 * (double) this.getBbWidth(), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
        }
    }



    @Override
    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.RAINBOUR.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.RAINBOUR_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAINBOUR_HURT.get();
    }


    class RainbourLookController extends LookControl {
        RainbourLookController(Mob entity) {
            super(entity);
        }

        public void tick() {
            if (!EntityRainbour.this.isAngry()) {
                super.tick();
            }
        }
    }
}