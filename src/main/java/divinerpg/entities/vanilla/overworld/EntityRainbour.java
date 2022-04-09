package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.controller.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class EntityRainbour extends EntityDivineFlyingMob {
    private int angerLevel;
    private UUID angerTargetUUID;

    public EntityRainbour(EntityType<? extends EntityDivineFlyingMob> type, World worldIn) {
        super(type, worldIn);
        this.lookControl = new EntityRainbour.RainbourLookController(this);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMobAttributes().add(Attributes.MAX_HEALTH, EntityStats.rainbourHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.rainbourDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.rainbourSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.rainbourFollowRange).add(Attributes.FLYING_SPEED, EntityStats.rainbourSpeed);
    }

    @Override
    public float getEyeHeight(Pose pose) {
        return 0.6F;
    }

    @Override
    public void setTarget(@Nullable LivingEntity livingBase) {
        super.setTarget(livingBase);

        if (livingBase != null)
        {
            this.angerTargetUUID = livingBase.getUUID();
        }
    }
    public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        this.angerLevel = tag.getShort("Anger");
        String s = tag.getString("HurtBy");

        if (!s.isEmpty())
        {
            this.angerTargetUUID = UUID.fromString(s);
            PlayerEntity entityplayer = this.getCommandSenderWorld().getPlayerByUUID(this.angerTargetUUID);
            this.setTarget(entityplayer);

            if (entityplayer != null)
            {
                this.lastHurtByPlayer = entityplayer;
                this.hurtTime = this.getLastHurtByMobTimestamp();
            }
        }
    }
    public void addAdditionalSaveData(CompoundNBT tag) {
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

            if (entity instanceof PlayerEntity)
            {
                this.becomeAngryAt(entity);
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

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }
    public IParticleData getParticleData() {
        return this.getEntityData().get(PARTICLE);
    }
    private static final DataParameter<IParticleData> PARTICLE = EntityDataManager.defineId(EntityRainbour.class, DataSerializers.PARTICLE);

    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            double d15 = getX() + random.nextDouble() * 0.6D + 0.2D;
            double d20 = getY() + random.nextDouble() * 0.6D + 0.2D;
            double d26 = getZ() + random.nextDouble() * 0.6D + 0.2D;

            if(level.isClientSide)
            level.addParticle(ParticleRegistry.SPARKLER.get(),d15 * (double) this.getBbWidth(),d20 + this.random.nextDouble() * (double) this.getBbHeight() - 0.25D,
                    d26 * (double) this.getBbWidth(), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
        }
    }

    @Override
    protected boolean isMovementNoisy() {
        return false;
    }

    @Override
    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
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


    class RainbourLookController extends LookController {
        RainbourLookController(MobEntity entity) {
            super(entity);
        }

        public void tick() {
            if (!EntityRainbour.this.isAngry()) {
                super.tick();
            }
        }
    }
}