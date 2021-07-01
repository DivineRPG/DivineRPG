package divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EntityPeacefulUntilAttacked extends EntityDivineMob {
    protected static final DataParameter<Integer> ANGER = EntityDataManager.defineId(EntityPeacefulUntilAttacked.class, DataSerializers.INT);
    protected static final DataParameter<String> TARGET = EntityDataManager.defineId(EntityPeacefulUntilAttacked.class, DataSerializers.STRING);
    private int angerLevel;
    private UUID angerTargetUUID;

    public EntityPeacefulUntilAttacked(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ANGER, 0);
        this.entityData.define(TARGET, null);
    }

    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
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

    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.angerLevel = compound.getShort("Anger");
        String s = compound.getString("HurtBy");

        if (!s.isEmpty())
        {
            this.angerTargetUUID = UUID.fromString(s);
            PlayerEntity entityplayer = this.level.getPlayerByUUID(this.angerTargetUUID);
            this.setTarget(entityplayer);

            if (entityplayer != null)
            {
                this.setTarget(entityplayer);
                this.lastHurt = this.getLastHurtByMobTimestamp();
            }
        }
    }

//    @Override
//    protected void registerGoals() {
//        super.registerGoals();
//        if (isAngry()) {addAttackingAI();}
//    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }
    @Override
    public void setTarget(@Nullable LivingEntity livingBase) {
        super.setTarget(livingBase);

        if (livingBase != null) {
            this.angerTargetUUID = livingBase.getUUID();
        }
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getDirectEntity();
            if (entity instanceof PlayerEntity) {
                this.becomeAngryAt(entity);
            }
            return super.hurt(source, amount);
        }
    }


    public boolean isAngry() {
        return this.angerLevel > 0;
    }

    private void becomeAngryAt(Entity target) {
        this.angerLevel = 400 + this.random.nextInt(400);

        if (target instanceof LivingEntity) {
            this.setTarget((LivingEntity) target);
        }
    }



    @Override
    public boolean doHurtTarget(Entity entity) {
        if (this.isAngry()) {
            return super.doHurtTarget(entity);
        }
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (isAngry()) {
            angerLevel--;
            addAttackingAI();
        }
    }
}