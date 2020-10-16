package TeamDivineRPG.divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
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
        compound.putInt("Anger", angerLevel);
        if (angerTargetUUID != null) {
            compound.putString("Target", angerTargetUUID.toString());
        }
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        compound.getInt("Anger");
        compound.getString("Target");
    }

    protected void registerGoals() {
//        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
    }


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
}