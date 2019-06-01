package naturix.divinerpg.objects.entities.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityPeacefulUntilAttacked extends EntityDivineRPGMob {
    private static final DataParameter<Boolean> ANGRY = EntityDataManager
            .<Boolean>createKey(EntityPeacefulUntilAttacked.class, DataSerializers.BOOLEAN);

    public EntityPeacefulUntilAttacked(World world) {
        super(world);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1F, true));
    }

    @Override
    public void setAttackTarget(@Nullable EntityLivingBase entity) {
        super.setAttackTarget(entity);
        if (entity != null && entity instanceof EntityPlayer && !((EntityPlayer) entity).capabilities.isCreativeMode
                && !isAngry()) {
            makeAngry();
        }
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(ANGRY, false);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        boolean angry = compound.getBoolean("Angry");
        if (angry) {
            makeAngry();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Angry", this.dataManager.get(ANGRY).booleanValue());
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getTrueSource();
        if (entity instanceof EntityPlayer) {
            this.setAttackTarget((EntityPlayer) entity);
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    public boolean isAngry() {
        return this.dataManager.get(ANGRY).booleanValue();
    }

    public void makeAngry() {
        this.dataManager.set(ANGRY, true);
        this.targetTasks.addTask(1,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, (Predicate) null));
    }

    @Override
    public boolean isPreventingPlayerRest(EntityPlayer playerIn) {
        return this.isAngry();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.isAngry()) {
            return super.attackEntityAsMob(entity);
        }
        return false;
    }
}