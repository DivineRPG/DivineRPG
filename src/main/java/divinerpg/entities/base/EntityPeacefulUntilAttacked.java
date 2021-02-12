package divinerpg.entities.base;

import divinerpg.DivineRPG;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityPeacefulUntilAttacked extends EntityDivineMob {
    protected static final DataParameter<Integer> ANGER = EntityDataManager.createKey(EntityPeacefulUntilAttacked.class, DataSerializers.VARINT);
    protected static final DataParameter<String> TARGET = EntityDataManager.createKey(EntityPeacefulUntilAttacked.class, DataSerializers.STRING);
    private int angerLevel;
    private UUID angerTargetUUID;

    public EntityPeacefulUntilAttacked(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(ANGER, 0);
        this.dataManager.register(TARGET, null);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Anger", (short)this.angerLevel);

        if (this.angerTargetUUID != null)
        {
            compound.putString("HurtBy", this.angerTargetUUID.toString());
        }
        else
        {
            compound.putString("HurtBy", "");
        }
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.angerLevel = compound.getShort("Anger");
        String s = compound.getString("HurtBy");

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

//    @Override
//    protected void registerGoals() {
//        super.registerGoals();
//        if (isAngry()) {addAttackingAI();}
//    }


    @Override
    public void setRevengeTarget(@Nullable LivingEntity livingBase) {
        super.setRevengeTarget(livingBase);

        if (livingBase != null) {
            this.angerTargetUUID = livingBase.getUniqueID();
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();
            if (entity instanceof PlayerEntity) {
                this.becomeAngryAt(entity);
            }
            return super.attackEntityFrom(source, amount);
        }
    }


    public boolean isAngry() {
        return this.angerLevel > 0;
    }

    private void becomeAngryAt(Entity target) {
        this.angerLevel = 400 + this.rand.nextInt(400);

        if (target instanceof LivingEntity) {
            this.setRevengeTarget((LivingEntity) target);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.isAngry()) {
            return super.attackEntityAsMob(entity);
        }
        return false;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (isAngry()) {
            angerLevel--;
            addAttackingAI();
        }
    }
}